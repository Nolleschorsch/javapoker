package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import poker.*;

class CardValueTest {

	@Test
	void testGetValue() {
		var expected = 2;
		var actual = CardValue.DEUCE.getValue();
		assertEquals(expected, actual);
	}

	@Test
	void testGetShortcutString() {

		assertEquals("2", CardValue.DEUCE.getShortcutString());
		assertEquals("3", CardValue.THREE.getShortcutString());
		assertEquals("4", CardValue.FOUR.getShortcutString());
		assertEquals("5", CardValue.FIVE.getShortcutString());
		assertEquals("6", CardValue.SIX.getShortcutString());
		assertEquals("7", CardValue.SEVEN.getShortcutString());
		assertEquals("8", CardValue.EIGHT.getShortcutString());
		assertEquals("9", CardValue.NINE.getShortcutString());
		assertEquals("T", CardValue.TEN.getShortcutString());
		assertEquals("J", CardValue.JACK.getShortcutString());
		assertEquals("Q", CardValue.QUEEN.getShortcutString());
		assertEquals("K", CardValue.KING.getShortcutString());
		assertEquals("A", CardValue.ACE.getShortcutString());

	}
	
	@Test
	void testGetVerboseString() {
		
		assertEquals("Deuce", CardValue.DEUCE.getVerboseString());
		assertEquals("Three", CardValue.THREE.getVerboseString());
		assertEquals("Four", CardValue.FOUR.getVerboseString());
		assertEquals("Five", CardValue.FIVE.getVerboseString());
		assertEquals("Six", CardValue.SIX.getVerboseString());
		assertEquals("Seven", CardValue.SEVEN.getVerboseString());
		assertEquals("Eight", CardValue.EIGHT.getVerboseString());
		assertEquals("Nine", CardValue.NINE.getVerboseString());
		assertEquals("Ten", CardValue.TEN.getVerboseString());
		assertEquals("Jack", CardValue.JACK.getVerboseString());
		assertEquals("Queen", CardValue.QUEEN.getVerboseString());
		assertEquals("King", CardValue.KING.getVerboseString());
		assertEquals("Ace", CardValue.ACE.getVerboseString());
		
	}
	
	@Test
	void testGetCardValueByIntDeuce() {
		var expected = CardValue.DEUCE;
		var actual = CardValue.getCardValueByInt(2);
		assertEquals(expected, actual);
	}

	@Test
	void testGetCardValueByIntThree() {
		var expected = CardValue.THREE;
		var actual = CardValue.getCardValueByInt(3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntFour() {
		var expected = CardValue.FOUR;
		var actual = CardValue.getCardValueByInt(4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntFive() {
		var expected = CardValue.FIVE;
		var actual = CardValue.getCardValueByInt(5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntSix() {
		var expected = CardValue.SIX;
		var actual = CardValue.getCardValueByInt(6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntSeven() {
		var expected = CardValue.SEVEN;
		var actual = CardValue.getCardValueByInt(7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntEight() {
		var expected = CardValue.EIGHT;
		var actual = CardValue.getCardValueByInt(8);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntNine() {
		var expected = CardValue.NINE;
		var actual = CardValue.getCardValueByInt(9);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntTen() {
		var expected = CardValue.TEN;
		var actual = CardValue.getCardValueByInt(10);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntJack() {
		var expected = CardValue.JACK;
		var actual = CardValue.getCardValueByInt(11);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntQueen() {
		var expected = CardValue.QUEEN;
		var actual = CardValue.getCardValueByInt(12);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntKing() {
		var expected = CardValue.KING;
		var actual = CardValue.getCardValueByInt(13);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntAce() {
		var expected = CardValue.ACE;
		var actual = CardValue.getCardValueByInt(14);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntAceDefault() {
		var expected = CardValue.ACE;
		var actual = CardValue.getCardValueByInt(42);
		assertEquals(expected, actual);
	}
}
