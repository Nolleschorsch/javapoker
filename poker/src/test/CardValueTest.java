package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import poker.*;

class CardValueTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
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
	void testCardValue() {
		fail("Not yet implemented");
	}

	@Test
	void testGetValue() {
		var expected = 2;
		var actual = CardValue.Deuce.getValue();
		assertEquals(expected, actual);
	}

	@Test
	void testGetCardValueByIntDeuce() {
		var expected = CardValue.Deuce;
		var actual = CardValue.getCardValueByInt(2);
		assertEquals(expected, actual);
	}

	@Test
	void testGetCardValueByIntThree() {
		var expected = CardValue.Three;
		var actual = CardValue.getCardValueByInt(3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntFour() {
		var expected = CardValue.Four;
		var actual = CardValue.getCardValueByInt(4);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntFive() {
		var expected = CardValue.Five;
		var actual = CardValue.getCardValueByInt(5);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntSix() {
		var expected = CardValue.Six;
		var actual = CardValue.getCardValueByInt(6);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntSeven() {
		var expected = CardValue.Seven;
		var actual = CardValue.getCardValueByInt(7);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntEight() {
		var expected = CardValue.Eight;
		var actual = CardValue.getCardValueByInt(8);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntNine() {
		var expected = CardValue.Nine;
		var actual = CardValue.getCardValueByInt(9);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntTen() {
		var expected = CardValue.Ten;
		var actual = CardValue.getCardValueByInt(10);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntJack() {
		var expected = CardValue.Jack;
		var actual = CardValue.getCardValueByInt(11);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntQueen() {
		var expected = CardValue.Queen;
		var actual = CardValue.getCardValueByInt(12);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntKing() {
		var expected = CardValue.King;
		var actual = CardValue.getCardValueByInt(13);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntAce() {
		var expected = CardValue.Ace;
		var actual = CardValue.getCardValueByInt(14);
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetCardValueByIntAceDefault() {
		var expected = CardValue.Ace;
		var actual = CardValue.getCardValueByInt(42);
		assertEquals(expected, actual);
	}
}
