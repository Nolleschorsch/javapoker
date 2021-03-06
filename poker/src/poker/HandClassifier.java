package poker;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class HandClassifier {
	
	public HandType classifyHand(List<Card> cards) {
		
		HandType handType;

		List<Integer> numericCardValues = cards.stream().map(Card::getNumericValue).collect(Collectors.toList());
		Set<Integer> uniqueNumericCardValues = Set.copyOf(numericCardValues);
		
		if (this.isStraightFlush(cards)) {
			handType = HandType.STRAIGHTFLUSH;
		}
		else if (this.isFourOfAKind(uniqueNumericCardValues, numericCardValues)) {
			handType = HandType.FOUROFAKIND;
		}
		else if (this.isFullHouse(uniqueNumericCardValues, numericCardValues)) {
			handType = HandType.FULLHOUSE;
		}
		else if (this.isFlush(cards)) {
			handType = HandType.FLUSH;
		}
		else if (this.isStraight(cards)) {
			handType = HandType.STRAIGHT;
		}
		else if (this.isThreeOfAKind(uniqueNumericCardValues, numericCardValues)) {
			handType = HandType.THREEOFAKIND;
		}
		else if (this.isTwoPair(uniqueNumericCardValues, numericCardValues)) {
			handType = HandType.TWOPAIR;
		}
		else if (this.isPair(uniqueNumericCardValues)) {
			handType = HandType.PAIR;
		}
		else {
			handType = HandType.HIGHCARD;
		}
		
		return handType;

	}
	
	public boolean isPair(Set<Integer> uniqueNumericCardValues) {
		// In order for the dealt hand to be of rank 'Pair' exactly two cards are of the same value, thus the resulting Set is of size four e.g (K, K , 5, 3, 2)
		return uniqueNumericCardValues.size() == 4;
	}
	
	public boolean isTwoPair(Set<Integer> uniqueNumericCardValues, List<Integer> numericCardValues) {
		// Set size is three AND occurences in List is either 2 or 1 e.g (A, A, K, K, 2)
		var validOccurenceCount = true;
		for (int value : uniqueNumericCardValues) {
			if (Collections.frequency(numericCardValues, value) > 2) {
				validOccurenceCount = false;
				break;
			}
			
		}
		return uniqueNumericCardValues.size() == 3 && validOccurenceCount;
	}
	
	public boolean isThreeOfAKind(Set<Integer> uniqueNumericCardValues, List<Integer> numericCardValues) {
		// Set size is three AND occurences in List are either 3 or 1 e.g. (Q, Q, Q, 7, 5)
		var validOccurenceCount = true;
		for (int value : uniqueNumericCardValues) {
			int occurenceCount = Collections.frequency(numericCardValues, value);
			if (occurenceCount != 3 && occurenceCount != 1) {
				validOccurenceCount = false;
				break;
			}
			
		}
		return uniqueNumericCardValues.size() == 3 && validOccurenceCount;
	}
	
	public boolean isStraight(List<Card> cards) {

		// Hand is ordered, in turn to be a straight the difference in values of two adjectant cards needs to be one.
		// Edge case (A, 5, 4, 3, 2) is also a straight.
		// first card Ace, second card 5, should be enough to cover the edge case.
		boolean possibleWheel = cards.get(0).getNumericValue() == 14 && cards.get(1).getNumericValue() == 5;
		for(var i=1; i<5; i++) {
			int gap = cards.get(i-1).getNumericValue() - cards.get(i).getNumericValue();
			if (gap != 1 && !(gap == 9 && possibleWheel)) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isFlush(List<Card> cards) {
		// In order for the hand to be a flush, each cards needs to be of the same suit.
		CardSuit suit = cards.get(0).getSuit();
		for(var i=0; i<5; i++) {
			if(cards.get(i).getSuit() != suit) {
				return false;
			}
		}
		return true;
	}
	
	public boolean isFullHouse(Set<Integer> uniqueNumericCardValues, List<Integer> numericCardValues) {
		// Set size is two and occurences in List are either 3 or 2 e.g. (3, 3, 3, J, J)
		var validOccurenceCount = true;
		for (int value : uniqueNumericCardValues) {
			int occurenceCount = Collections.frequency(numericCardValues, value);
			if (occurenceCount != 3 && occurenceCount != 2) {
				validOccurenceCount = false;
				break;
			}
			
		}
		return uniqueNumericCardValues.size() == 2 && validOccurenceCount;
	}
	
	public boolean isFourOfAKind(Set<Integer> uniqueNumericCardValues, List<Integer> numericCardValues) {
		// Set size is two and occurences in List are either 4 or 1 e.g. (8, 8, 8, 8, T)
		var validOccurenceCount = true;
		for (int value : uniqueNumericCardValues) {
			int occurenceCount = Collections.frequency(numericCardValues, value);
			if (occurenceCount != 4 && occurenceCount != 1) {
				validOccurenceCount = false;
				break;
			}
			
		}
		
		return uniqueNumericCardValues.size() == 2 && validOccurenceCount;
	}
	
	public boolean isStraightFlush(List<Card> cards) {
		// straightflush as the name suggests, the hand needs to be a straight and a flush at the same time.
		return this.isFlush(cards) && this.isStraight(cards);
	}
	
}
