package poker;

import java.util.ArrayList;
import java.util.List;


public class HandData implements  Comparable<HandData>{
	
	private String handType;
	private int handValue;
	private List<Integer> numericCardValues;
	private Hand hand;
	private HandEvaluator handEvaluator;
	
	public HandData(String handType, int handValue, List<Integer> numericCardValues, Hand hand) {
		// TODO: remove/move passed args. not clean/unneccesary stuff
		this.handType = handType;
		this.handValue = handValue;
		this.numericCardValues = numericCardValues;
		this.hand = hand;
		this.handEvaluator = new HandEvaluator();
	}
	
	public int getHandValue() {
		return this.handValue;
	}
	
	public List<Integer> getNumericCardValues() {
		return this.numericCardValues;
	}
	
	public Hand getHand() {
		return this.hand;
	}
	
	public String getHandType() {
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
	public int compareHighCard(Hand otherHand) {
		
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
	public List<Integer> foo(Hand hand) { 
		
		List<Integer> bla;
		
		if (this.handEvaluator.isStraight(hand)) {
			var otherNumericCardValues = this.handEvaluator.getNumericCardValues(hand);
			bla = this.handEvaluator.transformToWheel(otherNumericCardValues);
		} else {
			bla = this.handEvaluator.getNumericCardValues(hand);
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
