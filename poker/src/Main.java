import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
	      
		Deck deck = new Deck();
	    List<Hand> hands = deck.shuffleUpAndDeal(2);

		List<Hand> hands1 = new ArrayList<>(
				List.of(HandFixtures.straightFlush(), HandFixtures.flush())
		);
	    
	    
		List<Hand> hands2 = new ArrayList<>(
				List.of(HandFixtures.highcardAce(), HandFixtures.highcardQueen())
		);
		
		List<Hand> hands3 = new ArrayList<>(
				List.of(HandFixtures.straight(), HandFixtures.straightWheel())
		);
		
		List<Hand> hands4 = new ArrayList<>(
				List.of(HandFixtures.pairSixes(), HandFixtures.pairTens())
		);
		
		List<Hand> hands5 = new ArrayList<>(
				List.of(HandFixtures.pairTens(), HandFixtures.pairTensLow())
		);
		
	    var he = new HandEvaluator(hands);
	    he.evaluateWinner();
	    
	}
	
}
