package poker;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

	private Random random;
	private List<Card> cards;
	
	public Deck(Random random) {
		this.random = random;
		this.cards = generateDeck();
	}
	
	public Deck() {
		this(new Random());
	}
	
	public List<Card> generateDeck() {
		
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
	
	public List<Card> getDeck() {
		return this.cards;
	}
	
	public void shuffle() {
		Collections.shuffle(this.cards, random);
	}
	
	public Card deal() {
		// remove first card and return it
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
