import java.util.List;

public class Main {

	public static void main(String[] args) {
	      
		Deck deck = new Deck();
	    List<Hand> hands = deck.shuffleUpAndDeal(2);
		
	    var he = new HandEvaluator(hands);
	    he.evaluateWinner();
	    
	}
	
}
