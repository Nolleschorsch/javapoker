import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards;
	
	Deck() {
		CardSuit[] suits = CardSuit.values();
		CardValue[] values = CardValue.values();
		
		this.cards = new ArrayList<>();
		
		for (var i=0; i<suits.length; i++) {
			for(var j=0; j<values.length; j++) {
				var card = new Card(suits[i], values[j]);
				this.cards.add(card);
			}
		}
		
	}
	
	List<Card> getDeck() {
		return this.cards;
	}
	
	private void shuffle() {
		Collections.shuffle(this.cards);
	}
	
	private Card deal() {
		var card = this.cards.get(0);
		this.cards.remove(0);
		return card;
	}
	
	List<Hand> shuffleUpAndDeal(int playerCount) {
		
		this.shuffle();
		
		List<Hand> hands = new ArrayList<>();
		for(var i=0; i<playerCount; i++) {
			List<Card> playerCards = new ArrayList<>(); 
			for(var j=0; j<5; j++) {
				playerCards.add(this.deal());
			}
			var hand = new Hand(playerCards);
			hands.add(hand);
		}
		
		return hands;
	}
	
}
