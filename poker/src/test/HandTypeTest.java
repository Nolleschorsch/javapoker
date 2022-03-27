package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import poker.HandType;

class HandTypeTest {

	@Test
	void testGetRank() {
		
		assertEquals(0, HandType.STRAIGHTFLUSH.getRank());
		assertEquals(1, HandType.FOUROFAKIND.getRank());
		assertEquals(2, HandType.FULLHOUSE.getRank());
		assertEquals(3, HandType.FLUSH.getRank());
		assertEquals(4, HandType.STRAIGHT.getRank());
		assertEquals(5, HandType.THREEOFAKIND.getRank());
		assertEquals(6, HandType.TWOPAIR.getRank());
		assertEquals(7, HandType.PAIR.getRank());
		assertEquals(8, HandType.HIGHCARD.getRank());
		
	}

	@Test
	void testGetName() {
		
		assertEquals("StraightFlush", HandType.STRAIGHTFLUSH.getName());
		assertEquals("FourOfAKind", HandType.FOUROFAKIND.getName());
		assertEquals("FullHouse", HandType.FULLHOUSE.getName());
		assertEquals("Flush", HandType.FLUSH.getName());
		assertEquals("Straight", HandType.STRAIGHT.getName());
		assertEquals("ThreeOfAKind", HandType.THREEOFAKIND.getName());
		assertEquals("TwoPair", HandType.TWOPAIR.getName());
		assertEquals("Pair", HandType.PAIR.getName());
		assertEquals("HighCard", HandType.HIGHCARD.getName());
	}

}
