package test;

import java.util.ArrayList;
import java.util.List;

import poker.Card;
import poker.CardSuit;
import poker.CardValue;

public class CardsFixtures {

	private CardsFixtures() {}
	
	public static List<Card> cardsAceHigh() {
		
		var card1 = new Card(CardSuit.C, CardValue.Seven);
		var card2 = new Card(CardSuit.D, CardValue.Jack);
		var card3 = new Card(CardSuit.H, CardValue.Deuce);
		var card4 = new Card(CardSuit.C, CardValue.Ace);
		var card5 = new Card(CardSuit.S, CardValue.Five);
		
		return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	}
	
	public static List<Card> cardsAceHigh2() {
		
		var card1 = new Card(CardSuit.H, CardValue.Seven);
		var card2 = new Card(CardSuit.S, CardValue.Jack);
		var card3 = new Card(CardSuit.C, CardValue.Deuce);
		var card4 = new Card(CardSuit.D, CardValue.Ace);
		var card5 = new Card(CardSuit.C, CardValue.Five);
		
		return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	}
	
	public static List<Card> cardsTenHigh() {
		
		var card1 = new Card(CardSuit.C, CardValue.Deuce);
		var card2 = new Card(CardSuit.D, CardValue.Ten);
		var card3 = new Card(CardSuit.H, CardValue.Three);
		var card4 = new Card(CardSuit.C, CardValue.Six);
		var card5 = new Card(CardSuit.S, CardValue.Eight);
		
		return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	}
	
	public static List<Card> cardsFullHouse() {
		
		var card1 = new Card(CardSuit.C, CardValue.Deuce);
		var card2 = new Card(CardSuit.D, CardValue.Three);
		var card3 = new Card(CardSuit.H, CardValue.Three);
		var card4 = new Card(CardSuit.D, CardValue.Deuce);
		var card5 = new Card(CardSuit.S, CardValue.Deuce);
		
		return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	}
	
	public static List<Card> cardsWheel() {
		
		var card1 = new Card(CardSuit.C, CardValue.Deuce);
		var card2 = new Card(CardSuit.D, CardValue.Ace);
		var card3 = new Card(CardSuit.H, CardValue.Three);
		var card4 = new Card(CardSuit.C, CardValue.Five);
		var card5 = new Card(CardSuit.S, CardValue.Four);
		
		return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
		
	}
	
	public static List<Card> cardsWheelWrong() {
		
		var card1 = new Card(CardSuit.C, CardValue.Deuce);
	    var card2 = new Card(CardSuit.D, CardValue.Jack);
	    var card3 = new Card(CardSuit.S, CardValue.Queen);
	    var card4 = new Card(CardSuit.H, CardValue.King);
	    var card5 = new Card(CardSuit.C, CardValue.Ace);
	    
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
		
	}
	
	public static List<Card> cardsPairDeuces() {
		
		var card1 = new Card(CardSuit.C, CardValue.Deuce);
	    var card2 = new Card(CardSuit.D, CardValue.Seven);
	    var card3 = new Card(CardSuit.H, CardValue.Deuce);
	    var card4 = new Card(CardSuit.S, CardValue.Ten);
	    var card5 = new Card(CardSuit.C, CardValue.Ace);
	    
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
	
	public static List<Card> cardsTwoPairAcesAndDeuces() {
		
		var card1 = new Card(CardSuit.C, CardValue.Deuce);
	    var card2 = new Card(CardSuit.D, CardValue.Deuce);
	    var card3 = new Card(CardSuit.H, CardValue.Four);
	    var card4 = new Card(CardSuit.S, CardValue.Ace);
	    var card5 = new Card(CardSuit.C, CardValue.Ace);
		
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
	
	public static List<Card> cardsThreeOfAKindDeuces() {
		
		var card1 = new Card(CardSuit.C, CardValue.Deuce);
	    var card2 = new Card(CardSuit.D, CardValue.Deuce);
	    var card3 = new Card(CardSuit.H, CardValue.Deuce);
	    var card4 = new Card(CardSuit.S, CardValue.King);
	    var card5 = new Card(CardSuit.C, CardValue.Ace);
	    
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
	
	public static List<Card> cardsStraight() {
		
		var card1 = new Card(CardSuit.C, CardValue.Deuce);
	    var card2 = new Card(CardSuit.D, CardValue.Three);
	    var card3 = new Card(CardSuit.S, CardValue.Four);
	    var card4 = new Card(CardSuit.H, CardValue.Five);
	    var card5 = new Card(CardSuit.C, CardValue.Six);
		
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
	
	public static List<Card> cardsFlush() {
		
		var card1 = new Card(CardSuit.D, CardValue.Deuce);
	    var card2 = new Card(CardSuit.D, CardValue.Seven);
	    var card3 = new Card(CardSuit.D, CardValue.Queen);
	    var card4 = new Card(CardSuit.D, CardValue.Jack);
	    var card5 = new Card(CardSuit.D, CardValue.Ace);
	    
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
	
	public static List<Card> cardsFourOfAKindDeuces() {
		
		var card1 = new Card(CardSuit.C, CardValue.Deuce);
	    var card2 = new Card(CardSuit.D, CardValue.Deuce);
	    var card3 = new Card(CardSuit.H, CardValue.Deuce);
	    var card4 = new Card(CardSuit.S, CardValue.Deuce);
	    var card5 = new Card(CardSuit.C, CardValue.Ace);

	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
	
	public static List<Card> cardsStraightFlush() {
		
		var card1 = new Card(CardSuit.C, CardValue.Deuce);
	    var card2 = new Card(CardSuit.C, CardValue.Three);
	    var card3 = new Card(CardSuit.C, CardValue.Four);
	    var card4 = new Card(CardSuit.C, CardValue.Five);
	    var card5 = new Card(CardSuit.C, CardValue.Six);
		
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
	
	public static List<Card> cardsStraightFlushWheel() {
		
		var card1 = new Card(CardSuit.C, CardValue.Deuce);
	    var card2 = new Card(CardSuit.C, CardValue.Three);
	    var card3 = new Card(CardSuit.C, CardValue.Four);
	    var card4 = new Card(CardSuit.C, CardValue.Five);
	    var card5 = new Card(CardSuit.C, CardValue.Ace);
		
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
	
	public static List<Card> cardsRoyalFlush() {
		
		var card1 = new Card(CardSuit.C, CardValue.Ace);
	    var card2 = new Card(CardSuit.C, CardValue.King);
	    var card3 = new Card(CardSuit.C, CardValue.Queen);
	    var card4 = new Card(CardSuit.C, CardValue.Jack);
	    var card5 = new Card(CardSuit.C, CardValue.Ten);
		
	    return new ArrayList<>(List.of(card1, card2, card3, card4, card5));
	    
	}
}
