import java.util.List;

import poker.Deck;
import poker.Hand;
import poker.HandEvaluator;

public class Main {

	public static void main(String[] args) {
	      
		Deck deck = new Deck();
	    List<Hand> hands = deck.shuffleUpAndDeal(2);
		
	    var he = new HandEvaluator(hands);
	    he.evaluateWinner();
	    
	}
	
}
