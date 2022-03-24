package poker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	private List<Card> cards;
	
	public Deck() {
		
		this.cards = generateDeck();
//		this.cards = new ArrayList<>();
//		
//		for (var i=0; i<suits.length; i++) {
//			for(var j=0; j<values.length; j++) {
//				var card = new Card(suits[i], values[j]);
//				this.cards.add(card);
//			}
//		}
		
	}
	
	private List<Card> generateDeck() {
		
		CardSuit[] suits = CardSuit.values();
		CardValue[] values = CardValue.values();
		
		var cards = new ArrayList<Card>();
		
		for (var i=0; i<suits.length; i++) {
			for(var j=0; j<values.length; j++) {
				var card = new Card(suits[i], values[j]);
				cards.add(card);
			}
		}
		
		return cards;
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
	
	public List<Hand> shuffleUpAndDeal(int playerCount) {
		
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
