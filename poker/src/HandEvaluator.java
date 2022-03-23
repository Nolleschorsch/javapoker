import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class HandEvaluator {

	private List<Hand> hands;
	
	class HandData implements  Comparable<HandData>{
		
		private String handType;
		private int handValue;
		private List<Integer> numericCardValues;
		private Hand hand;
		
		HandData(String handType, int handValue, List<Integer> numericCardValues, Hand hand) {
			this.handType = handType;
			this.handValue = handValue;
			this.numericCardValues = numericCardValues;
			this.hand = hand;
		}
		
		int getHandValue() {
			return this.handValue;
		}
		
		List<Integer> getNumericCardValues() {
			return this.numericCardValues;
		}
		
		Hand getHand() {
			return this.hand;
		}
		
		String getHandType() {
			return this.handType;
		}
		
		public int compareTo(HandData handData) {
			
			var cmp = Integer.compare(this.getHandValue(), handData.getHandValue());
			
			if (cmp == 0) {
				cmp = this.compareHighCard(handData.getHand());
			}
			
			return cmp;
			
		}
		
		//TODO: rename stuff...
		private int compareHighCard(Hand otherHand) {
			
			var otherStuff = this.foo(otherHand);
			var thisStuff = this.foo(this.hand);
			
			for (var i=0; i<5; i++) {
				
				if (otherStuff.get(i) > thisStuff.get(i)) {
					return 1;
				} else if (otherStuff.get(i) < thisStuff.get(i)) {
					return -1;
				}
			}
			
			return 0;
		}
		
		//TODO: rename stuff...
		private List<Integer> foo(Hand hand) { 
			
			List<Integer> bla;
			
			if (HandEvaluator.this.isStraight(hand)) {
				var otherNumericCardValues = HandEvaluator.this.getNumericCardValues(hand);
				bla = HandEvaluator.this.transformToWheel(otherNumericCardValues);
			} else {
				bla = HandEvaluator.this.getNumericCardValues(hand);
			}
			
			return bla;
		}
		
		
		public Hand getHandByNumericValues() {
			List<Card> cards = new ArrayList<>();
			for (int numericCardValue : this.numericCardValues) {
				var suit = CardSuit.randomSuit();
				var cardValue = CardValue.getCardValueByInt(numericCardValue);
				var card = new Card(suit, cardValue);
				cards.add(card);
			}
			return new Hand(cards);
		}
		
		public String toString() {
			return String.format("Type: %s%nValue: %d", this.handType, this.handValue);
		}
		
	}
	
	HandEvaluator(List<Hand> hands) {
		this.hands = hands;
	}
	
	
	void evaluateWinner() {
		
		List<HandData> handDataList = new ArrayList<>();
		String winMessage;
		String lossMessage;
		
		for (Hand hand : this.hands) {
			var handData = this.evaluateHand(hand);
			handDataList.add(handData);
		}
		
		Collections.sort(handDataList);
		
		var winner = handDataList.get(0);
		var winners = new ArrayList<>(List.of(winner));
		List<HandEvaluator.HandData> losers = new ArrayList<>();
		
		for (var i=1; i<handDataList.size(); i++) {
			var data = handDataList.get(i);
			if (data.getHandValue() == winner.getHandValue() && data.getNumericCardValues().equals(winner.getNumericCardValues())) {
				winners.add(data);
			} else {
				losers.add(data);
			}	
		}
		
		winMessage = winners.size() == 1 ? this.printWinner(winner) : this.printSplitPot(winners);
		lossMessage = losers.size() > 0 ? this.printLosers(losers) : "";
		
		System.out.println(winMessage);
		System.out.println(lossMessage);
		
		//return handDataList;
		
	}
	
	HandData evaluateHand(Hand hand) {
		
		String handType;
		int handValue;

		List<Integer> numericCardValues = this.getNumericCardValues(hand);
		Set<Integer> uniqueNumericCardValues = this.getUniqueCardValues(numericCardValues);
		
		if (isStraightFlush(hand)) {
			handType = "Straight Flush!";
			handValue = 0;
			numericCardValues = this.transformToWheel(numericCardValues);
		}
		else if (isFourOfAKind(uniqueNumericCardValues, numericCardValues)) {
			handType = "Four of a kind!";
			handValue = 1;
		}
		else if (isFullHouse(uniqueNumericCardValues, numericCardValues)) {
			handType = "Fullhouse!";
			handValue = 2;
		}
		else if (isFlush(hand)) {
			handType = "Flush!";
			handValue = 3;
		}
		else if (isStraight(hand)) {
			handType = "Straight!";
			handValue = 4;
			numericCardValues = this.transformToWheel(numericCardValues);
		}
		else if (isThreeOfAKind(uniqueNumericCardValues, numericCardValues)) {
			handType = "Three of a kind!";
			handValue = 5;
		}
		else if (isTwoPair(uniqueNumericCardValues, numericCardValues)) {
			handType = "Two pair!";
			handValue = 6;
		}
		else if (isPair(uniqueNumericCardValues)) {
			handType = "Pair!";
			handValue = 7;
		}
		else {
			handType = "High card!";
			handValue = 8;
		}
		
		return new HandData(handType, handValue, numericCardValues, hand);

	}
	
	private List<Integer> getNumericCardValues(Hand hand) {
		List<Integer> numericCardValues = new ArrayList<>();
		for (Card card : hand.getCards()) {
			numericCardValues.add(card.getNumericValue());
		}
		return numericCardValues;
	}
	
	private Set<Integer> getUniqueCardValues(List<Integer> numericCardValues) {
		return Set.copyOf(numericCardValues);
	}
	
	private List<Integer> transformToWheel(List<Integer> numericCardValues) {
		if (numericCardValues.get(0) == 14 && numericCardValues.get(1) == 5) {
			numericCardValues.set(0, 1);
			Collections.sort(numericCardValues);
		}
		return numericCardValues;
	}
	
	boolean isHighCard() {
		// Lazy approach: if the dealt hand is none of the other cases, it is - by default - a high card. --> always return true
		return true;
	}
	
	boolean isPair(Set<Integer> uniqueNumericCardValues) {
		// In order for the dealt hand to be of rank 'Pair' exactly two cards are of the same value, thus the resulting Set is of size four e.g (K, K , 5, 3, 2)
		return uniqueNumericCardValues.size() == 4;
	}
	
	boolean isTwoPair(Set<Integer> uniqueNumericCardValues, List<Integer> numericCardValues) {
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
	
	boolean isThreeOfAKind(Set<Integer> uniqueNumericCardValues, List<Integer> numericCardValues) {
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
	
	boolean isStraight(Hand hand) {

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
	
	boolean isFlush(Hand hand) {
		// In order for the hand to be a flush, each cards needs to be of the same suit.
		CardSuit suit = hand.getCard(0).getSuit();
		for(var i=0; i<5; i++) {
			if(hand.getCard(i).getSuit() != suit) {
				return false;
			}
		}
		return true;
	}
	
	boolean isFullHouse(Set<Integer> uniqueNumericCardValues, List<Integer> numericCardValues) {
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
	
	boolean isFourOfAKind(Set<Integer> uniqueNumericCardValues, List<Integer> numericCardValues) {
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
	
	boolean isStraightFlush(Hand hand) {
		// straightflush as the name suggests, the hand needs to be a straight and a flush at the same time.
		return this.isFlush(hand) && this.isStraight(hand);
	}
	
	String printWinner(HandData winner) {
		return String.format("Hand %s wins with %s%n", winner.getHand().toString(), winner.getHandType());
		
	}
	
	String printSplitPot(List<HandData> winners) {
		
		List<String> winnerStringList = new ArrayList<>();
		
		for (HandData winner : winners) {
			var winnerString = String.format("Hand %s splitts pot with %s%n", winner.getHand().toString(), winner.getHandType());
			winnerStringList.add(winnerString);
		}
		
		return String.join("", winnerStringList);
	}
	
	String printLosers(List<HandData> losers) {
		
		List<String> loserStringList = new ArrayList<>();
		
		for (HandData loser : losers) {
			var loserString = String.format("Hand %s loses with %s%n", loser.getHand().toString(), loser.getHandType());
			loserStringList.add(loserString);
		}
		
		return String.join("", loserStringList);
	}
	
}
