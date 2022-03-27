package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import poker.Card;
import poker.CardSuit;
import poker.CardValue;


class CardTest {

	@Test
	void testCard() {
		
		try {
			new Card(CardSuit.C, CardValue.EIGHT);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testGetSuit() {
		
		var expected = CardSuit.C;
		var card = new Card(CardSuit.C, CardValue.DEUCE);
		var actual = card.getSuit();
		
		assertEquals(expected, actual);
	}

	@Test
	void testGetValue() {
		
		var expected = CardValue.QUEEN;
		var card = new Card(CardSuit.H, CardValue.QUEEN);
		var actual = card.getValue();
		
		assertEquals(expected, actual);
	}

	@Test
	void testGetNumericValue() {
		
		var expected = 10;
		var card = new Card(CardSuit.D, CardValue.TEN);
		var actual = card.getNumericValue();
		
		assertEquals(expected, actual);
	}

	@Test
	void testToString() {
		
		var expected = "AceS";
		var card = new Card(CardSuit.S, CardValue.ACE);
		var actual = card.toString();
		
		assertEquals(expected, actual);
	}

	@Test
	void testCompareToBigger() {
		
		var expected = -1;
		var card = new Card(CardSuit.S, CardValue.ACE);
		var otherCard = new Card(CardSuit.D, CardValue.JACK);
		var actual = card.compareTo(otherCard);
		
		assertEquals(expected, actual);
		
	}

	@Test
	void testCompareToSmaller() {
		
		var expected = 1;
		var card = new Card(CardSuit.S, CardValue.THREE);
		var otherCard = new Card(CardSuit.D, CardValue.SIX);
		var actual = card.compareTo(otherCard);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testCompareToEqual() {
		
		var expected = -0;
		var card = new Card(CardSuit.S, CardValue.KING);
		var otherCard = new Card(CardSuit.D, CardValue.KING);
		var actual = card.compareTo(otherCard);
		
		assertEquals(expected, actual);
		
	}
}
