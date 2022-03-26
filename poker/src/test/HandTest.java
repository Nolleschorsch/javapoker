package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import poker.*;

class HandTest {
	
	private static List<Card> cardsAceHigh;
	private static List<Card> cardsAceHigh2;
	private static List<Card> cardsTenHigh;
	private static List<Card> cardsFullHouse;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		cardsAceHigh = CardsFixtures.cardsAceHigh();
		cardsAceHigh2 = CardsFixtures.cardsAceHigh2();
		cardsTenHigh = CardsFixtures.cardsTenHigh();
		cardsFullHouse = CardsFixtures.cardsFullHouse();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testHand() {
		try {
			new Hand(cardsAceHigh);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testGetCards() {
		
		// SevenC, JackS, DeuceH, AceC, FiveS
		var cards = new ArrayList<>(cardsAceHigh);
		// after Hand.sortByOccurences() -> AceC, JackD, SevenC, FiveS, DeuceH
		
		var expected = new ArrayList<Card>(List.of(
				cards.get(3),
				cards.get(1),
				cards.get(0),
				cards.get(4),
				cards.get(2)
			));
		
		var hand = new Hand(cardsAceHigh);
		var actual = hand.getCards();
		
		assertEquals(expected, actual);
	}

	@Test
	void testGetCard() {
		
		// SevenC, JackS, DeuceH, AceC, FiveS
		var cards = new ArrayList<>(cardsAceHigh);
		// after Hand.sortByOccurences() -> AceC, JackD, SevenC, FiveS, DeuceH
		var hand = new Hand(cardsAceHigh);
		
		var expectedValues = new ArrayList<Card>(List.of(
				cards.get(3),
				cards.get(1),
				cards.get(0),
				cards.get(4),
				cards.get(2)
			));
		
		for (var i=0; i<5; i++) {
			
			var expected = expectedValues.get(i);
			var actual = hand.getCard(i);
			
			assertEquals(expected, actual);
			
		}
		
	}

	@Test
	void testGetSize() {
		
		var expected = 5;
		var hand = new Hand(cardsAceHigh);
		var actual = hand.getSize();
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testToString() {

		var expected = "AceC, JackD, SevenC, FiveS, DeuceH";
		var hand = new Hand(cardsAceHigh);
		var actual = hand.toString();
		
		assertEquals(expected, actual);
	}

	@Test
	void testGetNumericCardValues() {
		
		var expected = Arrays.asList(14, 11, 7, 5, 2);
		var hand = new Hand(cardsAceHigh);
		
		assertEquals(expected, hand.getNumericCardValues());
		
	}

	@Test
	void testGetHandType() {
		
		var expected = HandType.HighCard;
		var hand = new Hand(cardsAceHigh);
		
		assertEquals(expected, hand.getHandType(hand));
		
	}
	
	@Test
	void testTransformToWheel() {
		
		var expected = Arrays.asList(1,2,3,4,5);
		var hand = HandFixtures.straightWheel();
		var numericCardValues = hand.getNumericCardValues();
		
		assertNotEquals(expected, numericCardValues);
		assertEquals(expected, hand.transformToWheel(numericCardValues));
		
	}
	
	@Test
	void testSortByOccurencesAceHigh() {
		
		// SevenC, JackS, DeuceH, AceC, FiveS
		var cards = new ArrayList<>(cardsAceHigh);
		// after Hand.sortByOccurences() -> AceC, JackD, SevenC, FiveS, DeuceH
			
		var expected = new ArrayList<Card>(List.of(
				cards.get(3),
				cards.get(1),
				cards.get(0),
				cards.get(4),
				cards.get(2)
			));
		
		var hand = new Hand(cardsAceHigh);
		var actual = hand.sortByOccurences(cards);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testSortByOccurencesFullHouse() {
		
		// DeuceC, ThreeD, ThreeH, DeuceD, DeuceS
		var cards = new ArrayList<>(cardsFullHouse);
		// after Hand.sortByOccurences() -> DeuceS, DeuceD, DeuceC, ThreeH, ThreeD
			
		var expected = new ArrayList<Card>(List.of(
				cards.get(4),
				cards.get(3),
				cards.get(0),
				cards.get(2),
				cards.get(1)
			));
		
		var hand = new Hand(cardsFullHouse);
		var actual = hand.sortByOccurences(cards);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testCompareToBigger() {
		
		var expected = -1;
		var hand1 = HandFixtures.straightFlush();
		var hand2 = HandFixtures.highcardQueen();
		
		assertEquals(expected, hand1.compareTo(hand2));
		
	}
	
	@Test
	void testCompareToSmaller() {
		
		var expected = 1;
		var hand1 = HandFixtures.twoPair();
		var hand2 = HandFixtures.straightWheel();
		
		assertEquals(expected, hand1.compareTo(hand2));
		
	}
	
	@Test
	void testCompareToEqual() {
		
		var expected = 0;
		var hand1 = HandFixtures.flush();
		var hand2 = HandFixtures.flush2();
		
		assertEquals(expected, hand1.compareTo(hand2));
		
	}
	
	@Test
	void testCompareHighCardBigger() {
		
		var expected = -1;
		var hand = new Hand(cardsAceHigh);
		var otherHand = new Hand(cardsTenHigh);
		var actual = hand.compareHighCard(otherHand);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testCompareHighCardBiggerCaseStraight() {
		
		var expected = -1;
		var hand = HandFixtures.straight();
		var otherHand = HandFixtures.straightWheel();
		var actual = hand.compareHighCard(otherHand);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testCompareHighCardSmaller() {
		
		var expected = 1;
		var hand = new Hand(cardsTenHigh);
		var otherHand = new Hand(cardsAceHigh);
		var actual = hand.compareHighCard(otherHand);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testCompareHighCardSmallerCaseStraightFlush() {
		
		var expected = 1;
		var hand = HandFixtures.straightFlush();
		var otherHand = new Hand(CardsFixtures.cardsRoyalFlush());
		var actual = hand.compareHighCard(otherHand);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testCompareHighCardEqual() {
		
		var expected = 0;
		var hand = new Hand(cardsAceHigh);
		var otherHand = new Hand(cardsAceHigh2);
		var actual = hand.compareHighCard(otherHand);
		
		assertEquals(expected, actual);
		
	}
	
}
