import java.util.ArrayList;
import java.util.List;

public class HandFixtures {

	static Hand straightFlush() {
		
		var a = new Card(CardSuit.C, CardValue.Deuce);
	    var b = new Card(CardSuit.C, CardValue.Three);
	    var c = new Card(CardSuit.C, CardValue.Four);
	    var d = new Card(CardSuit.C, CardValue.Five);
	    var e = new Card(CardSuit.C, CardValue.Six);
	    
	    List<Card> cards = new ArrayList<>(List.of(d,e,a,c,b));
	    
	    return new Hand(cards);
	    
	}
	
	static Hand fourOfAKind() {
		
		var a = new Card(CardSuit.C, CardValue.Deuce);
	    var b = new Card(CardSuit.D, CardValue.Deuce);
	    var c = new Card(CardSuit.H, CardValue.Deuce);
	    var d = new Card(CardSuit.S, CardValue.Deuce);
	    var e = new Card(CardSuit.C, CardValue.Ace);
	    
	    List<Card> cards = new ArrayList<>(List.of(d,e,a,c,b));
	    
	    return new Hand(cards);
	    
	}
	
	static Hand fullHouse() {
		
		var a = new Card(CardSuit.C, CardValue.Deuce);
	    var b = new Card(CardSuit.D, CardValue.Deuce);
	    var c = new Card(CardSuit.H, CardValue.Deuce);
	    var d = new Card(CardSuit.S, CardValue.Ace);
	    var e = new Card(CardSuit.C, CardValue.Ace);
	    
	    List<Card> cards = new ArrayList<>(List.of(d,e,a,c,b));
	    
	    return new Hand(cards);
	    
	}
	
	static Hand flush() {
		
		var a = new Card(CardSuit.D, CardValue.Deuce);
	    var b = new Card(CardSuit.D, CardValue.Seven);
	    var c = new Card(CardSuit.D, CardValue.Queen);
	    var d = new Card(CardSuit.D, CardValue.Jack);
	    var e = new Card(CardSuit.D, CardValue.Ace);
	    
	    List<Card> cards = new ArrayList<>(List.of(d,e,a,c,b));
	    
	    return new Hand(cards);
	    
	}
	
	static Hand straight() {
		
		var a = new Card(CardSuit.C, CardValue.Deuce);
	    var b = new Card(CardSuit.D, CardValue.Three);
	    var c = new Card(CardSuit.S, CardValue.Four);
	    var d = new Card(CardSuit.H, CardValue.Five);
	    var e = new Card(CardSuit.C, CardValue.Six);
	    
	    List<Card> cards = new ArrayList<>(List.of(d,e,a,c,b));
	    
	    return new Hand(cards);
	    
	}
	
	static Hand straightWheel() {
		
		var a = new Card(CardSuit.C, CardValue.Deuce);
	    var b = new Card(CardSuit.D, CardValue.Three);
	    var c = new Card(CardSuit.S, CardValue.Four);
	    var d = new Card(CardSuit.H, CardValue.Five);
	    var e = new Card(CardSuit.C, CardValue.Ace);
	    
	    List<Card> cards = new ArrayList<>(List.of(d,e,a,c,b));
	    
	    return new Hand(cards);

	}
	
	static Hand straightWheelWrong() {
		
		var a = new Card(CardSuit.C, CardValue.Deuce);
	    var b = new Card(CardSuit.D, CardValue.Jack);
	    var c = new Card(CardSuit.S, CardValue.Queen);
	    var d = new Card(CardSuit.H, CardValue.King);
	    var e = new Card(CardSuit.C, CardValue.Ace);
	    
	    List<Card> cards = new ArrayList<>(List.of(d,e,a,c,b));
	    
	    return new Hand(cards);

	}
	
	static Hand threeOfAKind() {
		
		var a = new Card(CardSuit.C, CardValue.Deuce);
	    var b = new Card(CardSuit.D, CardValue.Deuce);
	    var c = new Card(CardSuit.H, CardValue.Deuce);
	    var d = new Card(CardSuit.S, CardValue.King);
	    var e = new Card(CardSuit.C, CardValue.Ace);
	    
	    List<Card> cards = new ArrayList<>(List.of(d,e,a,c,b));
	    
	    return new Hand(cards);
	    
	}
	
	static Hand twoPair() {
		
		var a = new Card(CardSuit.C, CardValue.Deuce);
	    var b = new Card(CardSuit.D, CardValue.Deuce);
	    var c = new Card(CardSuit.H, CardValue.Four);
	    var d = new Card(CardSuit.S, CardValue.Ace);
	    var e = new Card(CardSuit.C, CardValue.Ace);
	    
	    List<Card> cards = new ArrayList<>(List.of(d,e,a,c,b));
	    
	    return new Hand(cards);

	}
	
	static Hand pair() {
		
		var a = new Card(CardSuit.C, CardValue.Deuce);
	    var b = new Card(CardSuit.D, CardValue.Seven);
	    var c = new Card(CardSuit.H, CardValue.Deuce);
	    var d = new Card(CardSuit.S, CardValue.Ten);
	    var e = new Card(CardSuit.C, CardValue.Ace);
	    
	    List<Card> cards = new ArrayList<>(List.of(d,e,a,c,b));
	    
	    return new Hand(cards);

	}
	
	static Hand highcardAce() {
		
		var a = new Card(CardSuit.C, CardValue.Deuce);
	    var b = new Card(CardSuit.D, CardValue.Three);
	    var c = new Card(CardSuit.H, CardValue.Nine);
	    var d = new Card(CardSuit.S, CardValue.King);
	    var e = new Card(CardSuit.C, CardValue.Ace);
	    
	    List<Card> cards = new ArrayList<>(List.of(d,e,a,c,b));
	    
	    return new Hand(cards);

	}
	
	static Hand highcardQueen() {
		
		var a = new Card(CardSuit.C, CardValue.Deuce);
	    var b = new Card(CardSuit.D, CardValue.Three);
	    var c = new Card(CardSuit.H, CardValue.Nine);
	    var d = new Card(CardSuit.S, CardValue.Ten);
	    var e = new Card(CardSuit.C, CardValue.Queen);
	    
	    List<Card> cards = new ArrayList<>(List.of(d,e,a,c,b));
	    
	    return new Hand(cards);
	}
	
	static Hand pairSixes() {
		
		var a = new Card(CardSuit.C, CardValue.Six);
	    var b = new Card(CardSuit.D, CardValue.Six);
	    var c = new Card(CardSuit.H, CardValue.King);
	    var d = new Card(CardSuit.S, CardValue.Nine);
	    var e = new Card(CardSuit.C, CardValue.Three);
	    
	    List<Card> cards = new ArrayList<>(List.of(d,e,a,c,b));
	    
	    return new Hand(cards);
	}
	
	static Hand pairTens() {
		
		var a = new Card(CardSuit.C, CardValue.Ten);
	    var b = new Card(CardSuit.D, CardValue.Ten);
	    var c = new Card(CardSuit.H, CardValue.Ace);
	    var d = new Card(CardSuit.S, CardValue.Nine);
	    var e = new Card(CardSuit.C, CardValue.Eight);
	    
	    List<Card> cards = new ArrayList<>(List.of(d,e,a,c,b));
	    
	    return new Hand(cards);
	}
	
	static Hand pairTensLow() {
		
		var a = new Card(CardSuit.H, CardValue.Ten);
	    var b = new Card(CardSuit.S, CardValue.Ten);
	    var c = new Card(CardSuit.C, CardValue.Ace);
	    var d = new Card(CardSuit.D, CardValue.Nine);
	    var e = new Card(CardSuit.C, CardValue.Seven);
	    
	    List<Card> cards = new ArrayList<>(List.of(d,e,a,c,b));
	    
	    return new Hand(cards);
	}
}
