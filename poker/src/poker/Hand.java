package poker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Hand implements Comparable<Hand> {

	private List<Card> cards;
	private List<Integer> numericCardValues;
	private HandType handType;
	
	public Hand(List<Card> cards) {
		this.cards = this.sortByOccurences(cards);
		this.handType = this.getHandType(this.cards);
		this.numericCardValues = this.getNumericCardValues();
	}
	
	public List<Card> getCards() {
		return this.cards;
	}
	
	public Card getCard(int index) {
		return this.cards.get(index);
	}

	public int getSize() {
		return this.cards.size();
	}
	
	public String toString() {
		
		var transformedCards = new ArrayList<Card>();
		
		var needsTransform = 
				(this.getHandType(cards) == HandType.Straight || this.getHandType(cards) == HandType.StraightFlush) &&
				(cards.get(0).getNumericValue() == 14 && cards.get(1).getNumericValue() == 5);
		
		if (needsTransform) {
			transformedCards.addAll(cards.subList(1, 5));
			transformedCards.add(cards.get(0));
			
		} else {
			transformedCards.addAll(cards);
		}
		
		return transformedCards.stream().map(Card::getShortcutString)
                .collect(Collectors.joining(", "));

	}
	
	public List<Integer> getNumericCardValues() {
		List<Integer> numCardValues = new ArrayList<>();
		for (Card card : this.getCards()) {
			numCardValues.add(card.getNumericValue());
		}
		return numCardValues;
	}
	
	public HandType getHandType(List<Card> cards) {
		
		var handClassifier = new HandClassifier();
		
		return handClassifier.classifyHand(cards);
	}
	
	public String getAdditionalHandInfo() {
		
		String additionalHandInfo;
		var kickerString = "";
		
		if (this.handType == HandType.StraightFlush || this.handType == HandType.Straight) {
			
			//TODO: cleanup this whole wheel mess...
			var transformedCards = this.transformToWheelCards(this.cards);
			var start= transformedCards.get(0).getValue();
			var end = transformedCards.get(4).getValue();

			additionalHandInfo = String.format("%s to %s", start, end);
			
		} else if (this.handType == HandType.FourOfAKind) {
			
			kickerString = this.getKickerString(this.getCards().subList(4, 5));
			additionalHandInfo = String.format("%ss, (%s kicker)", this.getCard(0).getValue(), kickerString);
			
		} else if (this.handType == HandType.FullHouse) {
			
			additionalHandInfo = String.format("%ss full of %ss", this.getCard(0).getValue(), this.getCard(3).getValue());
			
		} else if (this.handType == HandType.Flush) {
			
			kickerString = this.getKickerString(this.getCards().subList(1, 5));
			additionalHandInfo = String.format("%s high, (%s kicker)", this.getCard(0).getValue(), kickerString);
			
		} else if (this.handType == HandType.ThreeOfAKind) {
			
			kickerString = this.getKickerString(this.getCards().subList(3,5));
			additionalHandInfo = String.format("%ss, (%s kicker)", this.getCard(0).getValue(), kickerString);
			
		} else if (this.handType == HandType.TwoPair) {
			
			kickerString = this.getKickerString(this.getCards().subList(4, 5));
			additionalHandInfo = String.format(
					"%ss and %ss, (%s kicker)",
					this.getCard(0).getValue(),
					this.getCard(2).getValue(),
					kickerString
					);
			
		} else if (this.handType == HandType.Pair) {
			
			kickerString = this.getKickerString(this.getCards().subList(2, 5));
			additionalHandInfo = String.format("of %ss, (%s kicker)", this.getCard(0).getValue(), kickerString);
			
		} else {
			kickerString = this.getKickerString(this.getCards().subList(1, 5));
			additionalHandInfo = String.format("%s, (%s kicker)", this.getCard(0).getValue(), kickerString);
		}
		
		return additionalHandInfo;
		
	}
	
	public String getKickerString(List<Card> cards) {
		return cards.stream().map(card -> card.getValue().getShortcutString())
                .collect(Collectors.joining(", "));
	}
	
	public List<Integer> transformToWheel(List<Integer> numericCardValues) {
		
		if (numericCardValues.get(0) == 14 && numericCardValues.get(1) == 5) {
			numericCardValues.set(0, 1);
			Collections.sort(numericCardValues);
		}
		
		return numericCardValues;
	}
	
	public List<Card> transformToWheelCards(List<Card> cards) {
		
		var transformedCards = new ArrayList<Card>();
		
		var needsTransform = 
				(this.getHandType(cards) == HandType.Straight || this.getHandType(cards) == HandType.StraightFlush) &&
				(cards.get(0).getNumericValue() == 14 && cards.get(1).getNumericValue() == 5);
		
		if (needsTransform) {
			transformedCards.addAll(cards.subList(1, 5));
			transformedCards.add(cards.get(0));
			
		} else {
			transformedCards.addAll(cards);
		}
		
		
		return transformedCards;
		
	}
	
	public List<Card> sortByOccurences(List<Card> cards) {
		
		var values = new ArrayList<Integer>();
		for (Card c: cards) {
			values.add(c.getNumericValue());
		}
		
		var cardsX = new ArrayList<Card>(cards);
		
		cardsX.sort((card1, card2) -> {
			int freq1 = Collections.frequency(values, card1.getNumericValue());
			int freq2 = Collections.frequency(values, card2.getNumericValue());
		    var cmp = Integer.compare(freq1, freq2);
		    if (cmp == 0)
		        cmp = Integer.compare(card1.getNumericValue(), card2.getNumericValue());
		    return cmp;
		});
	
		Collections.reverse(cardsX);
		
		return cardsX;

	}
	
	public int compareTo(Hand otherHand) {

		var cmp = Integer.compare(this.handType.getRank(), otherHand.handType.getRank());
		
		if (cmp == 0) {
			cmp = this.compareHighCard(otherHand);
		}
		
		return cmp;
		
	}
	
	public int compareHighCard(Hand otherHand) {
		
		// change the numericCardValue of an Ace to 1 if he hand is a straight.
		var numValues = (this.handType == HandType.Straight || this.handType == HandType.StraightFlush)
				? this.transformToWheel(this.numericCardValues) : this.numericCardValues;
		
		var otherNumValues = (otherHand.handType == HandType.Straight || this.handType == HandType.StraightFlush)
				? otherHand.transformToWheel(otherHand.getNumericCardValues()) : otherHand.getNumericCardValues();
		
		for (var i=0; i<5; i++) {
			
			if (otherNumValues.get(i) > numValues.get(i)) {
				return 1;
			} else if (otherNumValues.get(i) < numValues.get(i)) {
				return -1;
			}
		}
		
		return 0;
	}

}
