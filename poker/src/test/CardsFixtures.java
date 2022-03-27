package test;

import java.util.ArrayList;
import java.util.List;

import poker.Card;
import poker.CardSuit;
import poker.CardValue;

public class CardsFixtures {

	private CardsFixtures() {}
	
	public static List<Card> cardsHighcardAce() {
		
		var card1 = new Card(CardSuit.C, CardValue.SEVEN);
		var card2 = new Card(CardSuit.D, CardValue.JACK);
		var card3 = new Card(CardSuit.H, CardValue.DEUCE);
		var card4 = new Card(CardSuit.C, CardValue.ACE);
		var card5 = new Card(CardSuit.S, CardValue.FIVE);
		
		return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
		
	}
	
	public static List<Card> cardsHighcardAceEqual() {
		
		var card1 = new Card(CardSuit.H, CardValue.SEVEN);
		var card2 = new Card(CardSuit.S, CardValue.JACK);
		var card3 = new Card(CardSuit.C, CardValue.DEUCE);
		var card4 = new Card(CardSuit.D, CardValue.ACE);
		var card5 = new Card(CardSuit.C, CardValue.FIVE);
		
		return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
		
	}
	
	public static List<Card> cardsHighcardQueen() {
		
		var card1 = new Card(CardSuit.C, CardValue.DEUCE);
	    var card2 = new Card(CardSuit.D, CardValue.THREE);
	    var card3 = new Card(CardSuit.H, CardValue.NINE);
	    var card4 = new Card(CardSuit.S, CardValue.TEN);
	    var card5 = new Card(CardSuit.C, CardValue.QUEEN);
		
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
	
	public static List<Card> cardsHighcardTen() {
		
		var card1 = new Card(CardSuit.C, CardValue.DEUCE);
		var card2 = new Card(CardSuit.D, CardValue.TEN);
		var card3 = new Card(CardSuit.H, CardValue.THREE);
		var card4 = new Card(CardSuit.C, CardValue.SIX);
		var card5 = new Card(CardSuit.S, CardValue.EIGHT);
		
		return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
		
	}
	
	public static List<Card> cardsPairDeuces() {
		
		var card1 = new Card(CardSuit.C, CardValue.DEUCE);
	    var card2 = new Card(CardSuit.D, CardValue.SEVEN);
	    var card3 = new Card(CardSuit.H, CardValue.DEUCE);
	    var card4 = new Card(CardSuit.S, CardValue.TEN);
	    var card5 = new Card(CardSuit.C, CardValue.ACE);
	    
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
	
	public static List<Card> cardsPairSixes() {
		
		var card1 = new Card(CardSuit.C, CardValue.SIX);
	    var card2 = new Card(CardSuit.D, CardValue.SIX);
	    var card3 = new Card(CardSuit.H, CardValue.KING);
	    var card4 = new Card(CardSuit.S, CardValue.NINE);
	    var card5 = new Card(CardSuit.C, CardValue.THREE);
	    
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
	
	public static List<Card> cardsPairTens() {
		
		var card1 = new Card(CardSuit.C, CardValue.TEN);
		var card2 = new Card(CardSuit.D, CardValue.TEN);
		var card3 = new Card(CardSuit.H, CardValue.ACE);
		var card4 = new Card(CardSuit.S, CardValue.NINE);
		var card5 = new Card(CardSuit.C, CardValue.EIGHT);
		
		return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
		

	}
	
	public static List<Card> cardsPairTensLow() {
		
		var card1 = new Card(CardSuit.H, CardValue.TEN);
	    var card2 = new Card(CardSuit.S, CardValue.TEN);
	    var card3 = new Card(CardSuit.C, CardValue.ACE);
	    var card4 = new Card(CardSuit.D, CardValue.NINE);
	    var card5 = new Card(CardSuit.C, CardValue.SEVEN);
		
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
	
	public static List<Card> cardsTwoPairAcesAndDeuces() {
		
		var card1 = new Card(CardSuit.C, CardValue.DEUCE);
	    var card2 = new Card(CardSuit.D, CardValue.DEUCE);
	    var card3 = new Card(CardSuit.H, CardValue.FOUR);
	    var card4 = new Card(CardSuit.S, CardValue.ACE);
	    var card5 = new Card(CardSuit.C, CardValue.ACE);
		
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
	
	public static List<Card> cardsThreeOfAKindDeuces() {
		
		var card1 = new Card(CardSuit.C, CardValue.DEUCE);
	    var card2 = new Card(CardSuit.D, CardValue.DEUCE);
	    var card3 = new Card(CardSuit.H, CardValue.DEUCE);
	    var card4 = new Card(CardSuit.S, CardValue.KING);
	    var card5 = new Card(CardSuit.C, CardValue.ACE);
	    
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
	
	public static List<Card> cardsStraight() {
		
		var card1 = new Card(CardSuit.C, CardValue.DEUCE);
	    var card2 = new Card(CardSuit.D, CardValue.THREE);
	    var card3 = new Card(CardSuit.S, CardValue.FOUR);
	    var card4 = new Card(CardSuit.H, CardValue.FIVE);
	    var card5 = new Card(CardSuit.C, CardValue.SIX);
		
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
	
	public static List<Card> cardsStraightWheel() {
		
		var card1 = new Card(CardSuit.C, CardValue.DEUCE);
		var card2 = new Card(CardSuit.D, CardValue.ACE);
		var card3 = new Card(CardSuit.H, CardValue.THREE);
		var card4 = new Card(CardSuit.C, CardValue.FIVE);
		var card5 = new Card(CardSuit.S, CardValue.FOUR);
		
		return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
		
	}
	
	public static List<Card> cardsStraightWheelWrong() {
		
		var card1 = new Card(CardSuit.C, CardValue.DEUCE);
	    var card2 = new Card(CardSuit.D, CardValue.JACK);
	    var card3 = new Card(CardSuit.S, CardValue.QUEEN);
	    var card4 = new Card(CardSuit.H, CardValue.KING);
	    var card5 = new Card(CardSuit.C, CardValue.ACE);
	    
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
		
	}
	
	public static List<Card> cardsFlush() {
		
		var card1 = new Card(CardSuit.D, CardValue.DEUCE);
	    var card2 = new Card(CardSuit.D, CardValue.SEVEN);
	    var card3 = new Card(CardSuit.D, CardValue.QUEEN);
	    var card4 = new Card(CardSuit.D, CardValue.JACK);
	    var card5 = new Card(CardSuit.D, CardValue.ACE);
	    
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
	
	public static List<Card> cardsFlushEqual() {
		
		var card1 = new Card(CardSuit.S, CardValue.DEUCE);
	    var card2 = new Card(CardSuit.S, CardValue.SEVEN);
	    var card3 = new Card(CardSuit.S, CardValue.QUEEN);
	    var card4 = new Card(CardSuit.S, CardValue.JACK);
	    var card5 = new Card(CardSuit.S, CardValue.ACE);
	    
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
	
	public static List<Card> cardsFullHouse() {
		
		var card1 = new Card(CardSuit.C, CardValue.DEUCE);
		var card2 = new Card(CardSuit.D, CardValue.THREE);
		var card3 = new Card(CardSuit.H, CardValue.THREE);
		var card4 = new Card(CardSuit.D, CardValue.DEUCE);
		var card5 = new Card(CardSuit.S, CardValue.DEUCE);
		
		return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
		
	}
	
	public static List<Card> cardsFourOfAKindDeuces() {
		
		var card1 = new Card(CardSuit.C, CardValue.DEUCE);
	    var card2 = new Card(CardSuit.D, CardValue.DEUCE);
	    var card3 = new Card(CardSuit.H, CardValue.DEUCE);
	    var card4 = new Card(CardSuit.S, CardValue.DEUCE);
	    var card5 = new Card(CardSuit.C, CardValue.ACE);

	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
	
	public static List<Card> cardsStraightFlush() {
		
		var card1 = new Card(CardSuit.C, CardValue.DEUCE);
	    var card2 = new Card(CardSuit.C, CardValue.THREE);
	    var card3 = new Card(CardSuit.C, CardValue.FOUR);
	    var card4 = new Card(CardSuit.C, CardValue.FIVE);
	    var card5 = new Card(CardSuit.C, CardValue.SIX);
		
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
	
	public static List<Card> cardsStraightFlushWheel() {
		
		var card1 = new Card(CardSuit.C, CardValue.DEUCE);
	    var card2 = new Card(CardSuit.C, CardValue.THREE);
	    var card3 = new Card(CardSuit.C, CardValue.FOUR);
	    var card4 = new Card(CardSuit.C, CardValue.FIVE);
	    var card5 = new Card(CardSuit.C, CardValue.ACE);
		
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
	
	public static List<Card> cardsRoyalFlush() {
		
		var card1 = new Card(CardSuit.C, CardValue.ACE);
	    var card2 = new Card(CardSuit.C, CardValue.KING);
	    var card3 = new Card(CardSuit.C, CardValue.QUEEN);
	    var card4 = new Card(CardSuit.C, CardValue.JACK);
	    var card5 = new Card(CardSuit.C, CardValue.TEN);
		
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
}
