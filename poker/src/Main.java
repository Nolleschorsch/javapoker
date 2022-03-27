import java.util.ArrayList;
import java.util.List;

import poker.Deck;
import poker.Hand;
import poker.HandEvaluator;
import test.CardsFixtures;

public class Main {

	public static void main(String[] args) {
	    
		var playerCount = 5;
		
		Deck deck = new Deck();
	    List<Hand> hands = deck.shuffleUpAndDeal(playerCount);
		
	    var he = new HandEvaluator();
	    
	    // List of Strings with size 2. First item represents the winners, second item the losers (if there are any)
	    var result = he.evaluateWinner(hands);
	    
	    System.out.println(result.get(0));
	    System.out.println(result.get(1));
	    
	    
	}
	
}
