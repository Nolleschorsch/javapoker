package poker;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class HandClassifier {
	
	public HandType classifyHand(Hand hand) {
		
		HandType handType;

		List<Integer> numericCardValues = hand.getNumericCardValues();
		Set<Integer> uniqueNumericCardValues = Set.copyOf(numericCardValues);
		
		if (this.isStraightFlush(hand)) {
			handType = HandType.StraightFlush;
		}
		else if (this.isFourOfAKind(uniqueNumericCardValues, numericCardValues)) {
			handType = HandType.FourOfAKind;
		}
		else if (this.isFullHouse(uniqueNumericCardValues, numericCardValues)) {
			handType = HandType.FullHouse;
		}
		else if (this.isFlush(hand)) {
			handType = HandType.Flush;
		}
		else if (this.isStraight(hand)) {
			handType = HandType.Straight;
		}
		else if (this.isThreeOfAKind(uniqueNumericCardValues, numericCardValues)) {
			handType = HandType.ThreeOfAKind;
		}
		else if (this.isTwoPair(uniqueNumericCardValues, numericCardValues)) {
			handType = HandType.TwoPair;
		}
		else if (this.isPair(uniqueNumericCardValues)) {
			handType = HandType.Pair;
		}
		else {
			handType = HandType.HighCard;
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
	
	public boolean isStraight(Hand hand) {

		// Hand is ordered, in turn to be a straight the difference in values of two adjectant cards needs to be one.
		// Edge case (A, 5, 4, 3, 2) is also a straight.
		// first card Ace, second card 5, should be enough to cover the edge case.
		boolean possibleWheel = hand.getCard(0).getNumericValue() == 14 && hand.getCard(1).getNumericValue() == 5;
		for(var i=1; i<5; i++) {
			int gap = hand.getCard(i-1).getNumericValue() - hand.getCard(i).getNumericValue();
			if (gap != 1 && !(gap == 9 && possibleWheel)) {
				return false;
			}
		}
		
		return true;
	}
	
	public boolean isFlush(Hand hand) {
		// In order for the hand to be a flush, each cards needs to be of the same suit.
		CardSuit suit = hand.getCard(0).getSuit();
		for(var i=0; i<5; i++) {
			if(hand.getCard(i).getSuit() != suit) {
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
	
	public boolean isStraightFlush(Hand hand) {
		// straightflush as the name suggests, the hand needs to be a straight and a flush at the same time.
		return this.isFlush(hand) && this.isStraight(hand);
	}
	
}
