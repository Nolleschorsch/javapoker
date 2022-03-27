package poker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HandEvaluator {
	
	public List<String> evaluateWinner(List<Hand> hands) {
		
		String winMessage;
		String lossMessage;
		
		Collections.sort(hands);
		
		var winner = hands.get(0);
		var winners = new ArrayList<>(List.of(winner));
		List<Hand> losers = new ArrayList<>();
		
		for (var i=1; i<hands.size(); i++) {
			var hand = hands.get(i);
			var handType = hand.getHandType(hand.getCards());
			
			if (handType == winner.getHandType(winner.getCards()) &&
				hand.getNumericCardValues().equals(winner.getNumericCardValues())
				) {
				winners.add(hand);
			} else {
				losers.add(hand);
			}	
		}
		
		winMessage = winners.size() == 1 ? this.printWinner(winner) : this.printSplitPot(winners);
		lossMessage = losers.isEmpty() ? "" : this.printLosers(losers);
		
		return new ArrayList<>(List.of(winMessage, lossMessage));
		
	}
	
	public String printWinner(Hand winner) {
		return String.format(
				"Hand (%s) wins with %s %s%n",
				winner.toString(),
				winner.getHandType(winner.getCards()).getName(),
				winner.getAdditionalHandInfo()
				);
		
	}
	
	public String printSplitPot(List<Hand> winners) {
		
		List<String> winnerStringList = new ArrayList<>();
		
		for (Hand winner : winners) {
			var winnerString = String.format(
					"Hand (%s) splitts pot with %s %s%n",
					winner.toString(),
					winner.getHandType(winner.getCards()).getName(),
					winner.getAdditionalHandInfo()
					);
			winnerStringList.add(winnerString);
		}
		
		return String.join("", winnerStringList);
	}
	
	public String printLosers(List<Hand> losers) {
		
		List<String> loserStringList = new ArrayList<>();
		
		for (Hand loser : losers) {
			var loserString = String.format(
					"Hand (%s) loses with %s %s%n",
					loser.toString(),
					loser.getHandType(loser.getCards()).getName(),
					loser.getAdditionalHandInfo()
					);
			loserStringList.add(loserString);
		}
		
		return String.join("", loserStringList);
	}
	
}
