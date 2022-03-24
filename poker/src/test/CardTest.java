package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import poker.*;

class CardTest {

	private static CardSuit suitClub;
	private static CardSuit suitDiamond;
	private static CardSuit suitHeart;
	private static CardSuit suitSpade;
	
	private static CardValue deuce;
	private static CardValue three;
	private static CardValue four;
	private static CardValue five;
	private static CardValue six;
	private static CardValue seven;
	private static CardValue eight;
	private static CardValue nine;
	private static CardValue ten;
	private static CardValue jack;
	private static CardValue queen;
	private static CardValue king;
	private static CardValue ace;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		suitClub = CardSuit.C;
		suitDiamond = CardSuit.D;
		suitHeart = CardSuit.H;
		suitSpade = CardSuit.S;
		
		deuce = CardValue.Deuce;
		three = CardValue.Three;
		four = CardValue.Four;
		five = CardValue.Five;
		six = CardValue.Six;
		seven = CardValue.Seven;
		eight = CardValue.Eight;
		nine = CardValue.Nine;
		ten = CardValue.Ten;
		jack = CardValue.Jack;
		queen = CardValue.Queen;
		king = CardValue.King;
		ace = CardValue.Ace;
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCard() {
		
		try {
			new Card(suitClub, eight);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testGetSuit() {
		
		var expected = CardSuit.C;
		var card = new Card(suitClub, deuce);
		var actual = card.getSuit();
		
		assertEquals(expected, actual);
	}

	@Test
	void testGetValue() {
		
		var expected = CardValue.Queen;
		var card = new Card(suitHeart, queen);
		var actual = card.getValue();
		
		assertEquals(expected, actual);
	}

	@Test
	void testGetNumericValue() {
		
		var expected = 10;
		var card = new Card(suitDiamond, ten);
		var actual = card.getNumericValue();
		
		assertEquals(expected, actual);
	}

	@Test
	void testToString() {
		
		var expected = "AceS";
		var card = new Card(suitSpade, ace);
		var actual = card.toString();
		
		assertEquals(expected, actual);
	}

	@Test
	void testCompareToBigger() {
		
		var expected = -1;
		var card = new Card(suitSpade, ace);
		var otherCard = new Card(suitDiamond, jack);
		var actual = card.compareTo(otherCard);
		
		assertEquals(expected, actual);
		
	}

	@Test
	void testCompareToSmaller() {
		
		var expected = 1;
		var card = new Card(suitSpade, three);
		var otherCard = new Card(suitDiamond, six);
		var actual = card.compareTo(otherCard);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testCompareToEqual() {
		
		var expected = -0;
		var card = new Card(suitSpade, king);
		var otherCard = new Card(suitDiamond, king);
		var actual = card.compareTo(otherCard);
		
		assertEquals(expected, actual);
		
	}
}
