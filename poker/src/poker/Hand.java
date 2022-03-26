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
		this.numericCardValues = this.getNumericCardValues();
		this.handType = this.getHandType(this);
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
		
		return this.cards.stream().map(Object::toString)
                .collect(Collectors.joining(", "));

	}
	
	public List<Integer> getNumericCardValues() {
		List<Integer> numericCardValues = new ArrayList<>();
		for (Card card : this.getCards()) {
			numericCardValues.add(card.getNumericValue());
		}
		return numericCardValues;
	}
	
	public HandType getHandType(Hand hand) {
		
		var handClassifier = new HandClassifier();
		
		return handClassifier.classifyHand(hand);
	}
	
	public List<Integer> transformToWheel(List<Integer> numericCardValues) {
		
		if (numericCardValues.get(0) == 14 && numericCardValues.get(1) == 5) {
			numericCardValues.set(0, 1);
			Collections.sort(numericCardValues);
		}
		
		return numericCardValues;
	}
	
	public List<Card> sortByOccurences(List<Card> cards) {
		
		var values = new ArrayList<Integer>();
		for (Card c: cards) {
			values.add(c.getNumericValue());
		}
		
		cards.sort((card1, card2) -> {
			int freq1 = Collections.frequency(values, card1.getNumericValue());
			int freq2 = Collections.frequency(values, card2.getNumericValue());
		    var cmp = Integer.compare(freq1, freq2);
		    if (cmp == 0)
		        cmp = Integer.compare(card1.getNumericValue(), card2.getNumericValue());
		    return cmp;
		});
	
		Collections.reverse(cards);
		
		return cards;

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
