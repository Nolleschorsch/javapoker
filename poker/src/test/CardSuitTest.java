package test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import poker.CardSuit;

class CardSuitTest {

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
	void testGetVerboseString() {
		
		assertEquals("Clubs", CardSuit.C.getVerboseString());
		assertEquals("Diamonds", CardSuit.D.getVerboseString());
		assertEquals("Hearts", CardSuit.H.getVerboseString());
		assertEquals("Spades", CardSuit.S.getVerboseString());
		
	}
	
	@Test
	void testGetShortcutString() {
		
		assertEquals("c", CardSuit.C.getShortcutString());
		assertEquals("d", CardSuit.D.getShortcutString());
		assertEquals("h", CardSuit.H.getShortcutString());
		assertEquals("s", CardSuit.S.getShortcutString());
		
	}

}
