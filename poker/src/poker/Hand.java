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
				(this.getHandType(cards) == HandType.STRAIGHT || this.getHandType(cards) == HandType.STRAIGHTFLUSH) &&
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
		
		// adds additional handinfo e.g what kind of pair and kicker cards
		
		String additionalHandInfo;
		var kickerString = "";
		var kindString = "";
		var kindString2 = "";
		
		if (this.handType == HandType.STRAIGHTFLUSH || this.handType == HandType.STRAIGHT) {
			
			var transformedCards = this.transformToWheelCards(this.cards);
			var start = transformedCards.get(0).getValue().getVerboseString();
			var end = transformedCards.get(4).getValue().getVerboseString();

			additionalHandInfo = String.format("%s to %s", start, end);
			
		} else if (this.handType == HandType.FOUROFAKIND) {
			
			kickerString = this.getKickerString(this.getCards().subList(4, 5));
			kindString = this.getCard(0).getValue().getVerboseString();
			
			additionalHandInfo = String.format("%ss, (%s kicker)", kindString, kickerString);
			
		} else if (this.handType == HandType.FULLHOUSE) {
			
			kindString = this.getCard(0).getValue().getVerboseString();
			kindString2 = this.getCard(3).getValue().getVerboseString();
			
			additionalHandInfo = String.format("%ss full of %ss", kindString, kindString2);
			
		} else if (this.handType == HandType.FLUSH) {
			
			kickerString = this.getKickerString(this.getCards().subList(1, 5));
			kindString = this.getCard(0).getValue().getVerboseString();
			
			additionalHandInfo = String.format("%s high, (%s kicker)", kindString, kickerString);
			
		} else if (this.handType == HandType.THREEOFAKIND) {
			
			kickerString = this.getKickerString(this.getCards().subList(3,5));
			kindString =  this.getCard(0).getValue().getVerboseString();
			
			additionalHandInfo = String.format("%ss, (%s kicker)", kindString, kickerString);
			
		} else if (this.handType == HandType.TWOPAIR) {
			
			kickerString = this.getKickerString(this.getCards().subList(4, 5));
			kindString = this.getCard(0).getValue().getVerboseString();
			kindString2 = this.getCard(2).getValue().getVerboseString();
			
			additionalHandInfo = String.format("%ss and %ss, (%s kicker)", kindString, kindString2, kickerString);
			
		} else if (this.handType == HandType.PAIR) {
			
			kickerString = this.getKickerString(this.getCards().subList(2, 5));
			kindString = this.getCard(0).getValue().getVerboseString();
			
			additionalHandInfo = String.format("of %ss, (%s kicker)", kindString, kickerString);
			
		} else {
			
			kickerString = this.getKickerString(this.getCards().subList(1, 5));
			kindString = this.getCard(0).getValue().getVerboseString();
			
			additionalHandInfo = String.format("%s, (%s kicker)", kindString, kickerString);
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
				(this.getHandType(cards) == HandType.STRAIGHT || this.getHandType(cards) == HandType.STRAIGHTFLUSH) &&
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
		var numValues = (this.handType == HandType.STRAIGHT || this.handType == HandType.STRAIGHTFLUSH)
				? this.transformToWheel(this.numericCardValues) : this.numericCardValues;
		
		var otherNumValues = (otherHand.handType == HandType.STRAIGHT || this.handType == HandType.STRAIGHTFLUSH)
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
