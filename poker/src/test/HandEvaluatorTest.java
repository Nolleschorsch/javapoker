package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import poker.Card;
import poker.Hand;
import poker.HandEvaluator;
import poker.HandData;

class HandEvaluatorTest {

	private static Hand handAceHigh;
	private static Hand handAceHigh2;
	private static Hand handTenHigh;
	private static Hand handFullHouse;
	private static Hand handWheel;
	private static Hand handWheelWrong;
	private static Hand handPairDeuces;
	private static Hand handTwoPairAcesAndDeuces;
	private static Hand handThreeOfAKindDeuces;
	private static Hand handStraight;
	private static Hand handFlush;
	private static Hand handFourOfAKindDeuces;
	private static Hand handStraightFlush;
	private static Hand handRoyalFlush;
	
	private static List<Hand> allHands;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		handAceHigh = new Hand(CardsFixtures.cardsAceHigh());
		handAceHigh2 = new Hand(CardsFixtures.cardsAceHigh2());
		handTenHigh = new Hand(CardsFixtures.cardsTenHigh());
		handFullHouse = new Hand(CardsFixtures.cardsFullHouse());
		handWheel = new Hand(CardsFixtures.cardsWheel());
		handWheelWrong = new Hand(CardsFixtures.cardsWheelWrong());
		handPairDeuces = new Hand(CardsFixtures.cardsPairDeuces());
		handTwoPairAcesAndDeuces = new Hand(CardsFixtures.cardsTwoPairAcesAndDeuces());
		handThreeOfAKindDeuces = new Hand(CardsFixtures.cardsThreeOfAKindDeuces());
		handStraight = new Hand(CardsFixtures.cardsStraight());
		handFlush = new Hand(CardsFixtures.cardsFlush());
		handFourOfAKindDeuces = new Hand(CardsFixtures.cardsFourOfAKindDeuces());
		handStraightFlush = new Hand(CardsFixtures.cardsStraightFlush());
		handRoyalFlush = new Hand(CardsFixtures.cardsRoyalFlush());
		
		allHands = new ArrayList<>(List.of(
				handAceHigh,
				handAceHigh2,
				handTenHigh,
				handFullHouse,
				handWheel,
				handWheelWrong,
				handPairDeuces,
				handTwoPairAcesAndDeuces,
				handThreeOfAKindDeuces,
				handStraight,
				handFlush,
				handFourOfAKindDeuces,
				handStraightFlush,
				handRoyalFlush
				));
		
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
	void testHandEvaluator() {
		try {
			var hands = new ArrayList<>(List.of(handAceHigh, handTenHigh));
			new HandEvaluator(hands);
			new HandEvaluator();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testEvaluateWinner() {
		
		// TODO: use some kind of spy, stub, mock to check if stuff gets actualy called the desired way.
		
		var hands = new ArrayList<>(List.of(handAceHigh, handTenHigh, handFullHouse));
		var he = new HandEvaluator(hands);
		
		// fullhouse wins
		var expectedValues = new ArrayList<HandData>(List.of(
						he.evaluateHand(handFullHouse),
						he.evaluateHand(handAceHigh),
						he.evaluateHand(handTenHigh)
				));
		
		var actualValues = he.evaluateWinner();
		
		assertEquals(expectedValues.toString(), actualValues.toString());
		
	}

	@Test
	void testEvaluateHandStraightFlush() {
		
		var he = new HandEvaluator();
		
		var handType = "Straight Flush!";
		var handValue = 0;
		var numericCardValues = he.getNumericCardValues(handStraightFlush);
		var numericCardValuesTransformed = he.transformToWheel(numericCardValues);
		
		var expected = new HandData(handType, handValue, numericCardValuesTransformed, handStraightFlush);
		
		var hand = handStraightFlush;
		var actual = he.evaluateHand(hand);
		
		assertEquals(expected.toString(), actual.toString());
		
		
	}

	@Test
	void testEvaluateHandFourOfAKind() {
		
		var he = new HandEvaluator();
		
		var handType = "Four of a kind!";
		var handValue = 1;
		var numericCardValues = he.getNumericCardValues(handFourOfAKindDeuces);
		
		var expected = new HandData(handType, handValue, numericCardValues, handFourOfAKindDeuces);
		
		var hand = handFourOfAKindDeuces;
		var actual = he.evaluateHand(hand);
		
		assertEquals(expected.toString(), actual.toString());
		
		
	}
	
	@Test
	void testEvaluateHandFullHouse() {
		
		var he = new HandEvaluator();
		
		var handType = "Fullhouse!";
		var handValue = 2;
		var numericCardValues = he.getNumericCardValues(handFullHouse);
		
		var expected = new HandData(handType, handValue, numericCardValues, handFullHouse);
		
		var hand = handFullHouse;
		var actual = he.evaluateHand(hand);
		
		assertEquals(expected.toString(), actual.toString());
		
		
	}
	
	@Test
	void testEvaluateHandFlush() {
		
		var he = new HandEvaluator();
		
		var handType = "Flush!";
		var handValue = 3;
		var numericCardValues = he.getNumericCardValues(handFlush);
		
		var expected = new HandData(handType, handValue, numericCardValues, handFlush);
		
		var hand = handFlush;
		var actual = he.evaluateHand(hand);
		
		assertEquals(expected.toString(), actual.toString());
		
		
	}
	
	@Test
	void testEvaluateHandStraight() {
		
		var he = new HandEvaluator();
		
		var handType = "Straight!";
		var handValue = 4;
		var numericCardValues = he.getNumericCardValues(handStraight);
		var numericCardValuesTransformed = he.transformToWheel(numericCardValues);
		
		var expected = new HandData(handType, handValue, numericCardValuesTransformed, handStraight);
		
		var hand = handStraight;
		var actual = he.evaluateHand(hand);
		
		assertEquals(expected.toString(), actual.toString());
		
		
	}
	
	@Test
	void testEvaluateHandStraightWheel() {
		
		var he = new HandEvaluator();
		
		var handType = "Straight!";
		var handValue = 4;
		var numericCardValues = he.getNumericCardValues(handWheel);
		var numericCardValuesTransformed = he.transformToWheel(numericCardValues);
		
		var expected = new HandData(handType, handValue, numericCardValuesTransformed, handWheel);
		
		var hand = handWheel;
		var actual = he.evaluateHand(hand);
		
		assertEquals(expected.toString(), actual.toString());
		
		
	}
	
	@Test
	void testEvaluateHandThreeOfAKind() {
		
		var he = new HandEvaluator();
		
		var handType = "Three of a kind!";
		var handValue = 5;
		var numericCardValues = he.getNumericCardValues(handThreeOfAKindDeuces);
		
		var expected = new HandData(handType, handValue, numericCardValues, handThreeOfAKindDeuces);
		
		var hand = handThreeOfAKindDeuces;
		var actual = he.evaluateHand(hand);
		
		assertEquals(expected.toString(), actual.toString());
		
		
	}
	
	@Test
	void testEvaluateHandTwoPair() {
		
		var he = new HandEvaluator();
		
		var handType = "Two pair!";
		var handValue = 6;
		var numericCardValues = he.getNumericCardValues(handTwoPairAcesAndDeuces);
		
		var expected = new HandData(handType, handValue, numericCardValues, handTwoPairAcesAndDeuces);
		
		var hand = handTwoPairAcesAndDeuces;
		var actual = he.evaluateHand(hand);
		
		assertEquals(expected.toString(), actual.toString());
		
	}	
	
	@Test
	void testEvaluateHandPair() {
		
		var he = new HandEvaluator();
		
		var handType = "Pair!";
		var handValue = 7;
		var numericCardValues = he.getNumericCardValues(handPairDeuces);
		
		var expected = new HandData(handType, handValue, numericCardValues, handPairDeuces);
		
		var hand = handPairDeuces;
		var actual = he.evaluateHand(hand);
		
		assertEquals(expected.toString(), actual.toString());
		
	}
	
	@Test
	void testEvaluateHandHighCard() {
		
		var he = new HandEvaluator();
		
		var handType = "High card!";
		var handValue = 8;
		var numericCardValues = he.getNumericCardValues(handAceHigh);
		
		var expected = new HandData(handType, handValue, numericCardValues, handAceHigh);
		
		var hand = handAceHigh;
		var actual = he.evaluateHand(hand);
		
		assertEquals(expected.toString(), actual.toString());
		
	}
	
	@Test
	void testGetNumericCardValues() {
		
		var expected = Arrays.asList(14, 11, 7, 5, 2);
		var hands = new ArrayList<Hand>();
		var he = new HandEvaluator(hands);
		var actual = he.getNumericCardValues(handAceHigh);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetUniqueCardValuesAceHigh() {
		
		var expected = new HashSet(Arrays.asList(14, 11, 7, 5, 2));
		var hands = new ArrayList<Hand>();
		var he = new HandEvaluator(hands);
		var numericValues = he.getNumericCardValues(handAceHigh);
		var actual = he.getUniqueCardValues(numericValues);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testGetUniqueCardValuesFullHouse() {
		
		var expected = new HashSet(Arrays.asList(2, 3, 3, 2, 2));
		var hands = new ArrayList<Hand>();
		var he = new HandEvaluator(hands);
		var numericValues = he.getNumericCardValues(handFullHouse);
		var actual = he.getUniqueCardValues(numericValues);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testTransformToWheelIsWheel() {
		
		var expected = Arrays.asList(1,2,3,4,5);
		var hands = new ArrayList<Hand>();
		var he = new HandEvaluator(hands);
		var numericValues = he.getNumericCardValues(handWheel);
		var actual = he.transformToWheel(numericValues);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testTransformToWheelNotWheel() {
		
		var expected = Arrays.asList(14,13,12,11,2);
		var hands = new ArrayList<Hand>();
		var he = new HandEvaluator(hands);
		var numericValues = he.getNumericCardValues(handWheelWrong);
		var actual = he.transformToWheel(numericValues);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testIsHighCard() {
		var he = new HandEvaluator();
		assertTrue(he.isHighCard());
	}

	@Test
	void testIsPairTrue() {

		var he = new HandEvaluator();
		var numericCardvalues = he.getNumericCardValues(handPairDeuces);
		var uniqueNumericCardValues = he.getUniqueCardValues(numericCardvalues);
		
		assertTrue(he.isPair(uniqueNumericCardValues));
		
	}

	@Test
	void testIsPairFalse() {
		
		var he = new HandEvaluator();
		
		var handsToSkip = new ArrayList<>(List.of(handPairDeuces));
		var handsToTest = new ArrayList<>(allHands);
		handsToTest.removeAll(handsToSkip);
		
		for(Hand hand : handsToTest) {
			
			var numericCardvalues = he.getNumericCardValues(hand);
			var uniqueNumericCardValues = he.getUniqueCardValues(numericCardvalues);
			
			assertFalse(he.isPair(uniqueNumericCardValues));
			
		}
		
	}
	
	@Test
	void testIsTwoPairTrue() {

		var he = new HandEvaluator();
		var numericCardvalues = he.getNumericCardValues(handTwoPairAcesAndDeuces);
		var uniqueNumericCardValues = he.getUniqueCardValues(numericCardvalues);
		
		assertTrue(he.isTwoPair(uniqueNumericCardValues, numericCardvalues));
		
	}

	@Test
	void testIsTwoPairFalse() {

		var he = new HandEvaluator();
		
		var handsToSkip = new ArrayList<>(List.of(handTwoPairAcesAndDeuces));
		var handsToTest = new ArrayList<>(allHands);
		handsToTest.removeAll(handsToSkip);
		
		for (Hand hand : handsToTest) {
			
			var numericCardvalues = he.getNumericCardValues(hand);
			var uniqueNumericCardValues = he.getUniqueCardValues(numericCardvalues);
			
			assertFalse(he.isTwoPair(uniqueNumericCardValues, numericCardvalues));
			
		}
		
	}
	
	@Test
	void testIsThreeOfAKindTrue() {

		var he = new HandEvaluator();
		var numericCardvalues = he.getNumericCardValues(handThreeOfAKindDeuces);
		var uniqueNumericCardValues = he.getUniqueCardValues(numericCardvalues);
		
		assertTrue(he.isThreeOfAKind(uniqueNumericCardValues, numericCardvalues));
		
	}

	@Test
	void testIsThreeOfAKindFalse() {

		var he = new HandEvaluator();
		
		var handsToSkip = new ArrayList<>(List.of(handThreeOfAKindDeuces));
		var handsToTest = new ArrayList<>(allHands);
		handsToTest.removeAll(handsToSkip);
		
		for (Hand hand : handsToTest) {
			
			var numericCardvalues = he.getNumericCardValues(hand);
			var uniqueNumericCardValues = he.getUniqueCardValues(numericCardvalues);
			
			assertFalse(he.isThreeOfAKind(uniqueNumericCardValues, numericCardvalues));
			
		}
		
	}
	
	@Test
	void testIsStraightTrue() {

		var he = new HandEvaluator();
		
		assertTrue(he.isStraight(handStraight));
		assertTrue(he.isStraight(handWheel));
		assertTrue(he.isStraight(handStraightFlush));
		assertTrue(he.isStraight(handRoyalFlush));
	}

	@Test
	void testIsStraightFalse() {
		
		var he = new HandEvaluator();
		
		var handsToSkip = new ArrayList<>(List.of(
				handStraight,
				handWheel,
				handStraightFlush,
				handRoyalFlush));
		var handsToTest = new ArrayList<>(allHands);
		handsToTest.removeAll(handsToSkip);
		
		for(Hand hand : handsToTest) {
			assertFalse(he.isStraight(hand));
		}

	}
	
	@Test
	void testIsFlushTrue() {
		
		var he = new HandEvaluator();
		
		assertTrue(he.isFlush(handFlush));
		assertTrue(he.isFlush(handStraightFlush));
		assertTrue(he.isFlush(handRoyalFlush));
		
	}

	@Test
	void testIsFlushFalse() {
		
		var he = new HandEvaluator();
		
		var handsToSkip = new ArrayList<>(List.of(handFlush, handStraightFlush, handRoyalFlush));
		var handsToTest = new ArrayList<>(allHands);
		handsToTest.removeAll(handsToSkip);
		
		for (Hand hand : handsToTest) {
			assertFalse(he.isFlush(hand));
		}
		
	}
	
	@Test
	void testIsFullHouseTrue() {

		var he = new HandEvaluator();
		var numericCardvalues = he.getNumericCardValues(handFullHouse);
		var uniqueNumericCardValues = he.getUniqueCardValues(numericCardvalues);
		
		assertTrue(he.isFullHouse(uniqueNumericCardValues, numericCardvalues));
		
	}

	@Test
	void testIsFullHouseFalse() {

		var he = new HandEvaluator();
		
		var handsToSkip = new ArrayList<>(List.of(handFullHouse));
		var handsToTest = new ArrayList<>(allHands);
		handsToTest.removeAll(handsToSkip);
		
		for (Hand hand : handsToTest) {
			
			var numericCardvalues = he.getNumericCardValues(hand);
			var uniqueNumericCardValues = he.getUniqueCardValues(numericCardvalues);
			
			assertFalse(he.isFullHouse(uniqueNumericCardValues, numericCardvalues));
		}
		
	}
	
	@Test
	void testIsFourOfAKindTrue() {
		
		var he = new HandEvaluator();
		var numericCardvalues = he.getNumericCardValues(handFourOfAKindDeuces);
		var uniqueNumericCardValues = he.getUniqueCardValues(numericCardvalues);
		
		assertTrue(he.isFourOfAKind(uniqueNumericCardValues, numericCardvalues));
		
	}

	@Test
	void testIsFourOfAKindFalse() {
		
		var he = new HandEvaluator();
		
		var handsToSkip = new ArrayList<>(List.of(handFourOfAKindDeuces));
		var handsToTest = new ArrayList<>(allHands);
		handsToTest.removeAll(handsToSkip);
		
		for (Hand hand : handsToTest) {
			
			var numericCardvalues = he.getNumericCardValues(hand);
			var uniqueNumericCardValues = he.getUniqueCardValues(numericCardvalues);
			
			assertFalse(he.isFourOfAKind(uniqueNumericCardValues, numericCardvalues));
		}
		
	}
	
	@Test
	void testIsStraightFlushTrue() {

		var he = new HandEvaluator();

		assertTrue(he.isStraightFlush(handStraightFlush));
		assertTrue(he.isStraightFlush(handRoyalFlush));
		
	}

	@Test
	void testIsStraightFlushFalse() {

		var he = new HandEvaluator();
		
		var handsToSkip = new ArrayList<>(List.of(handStraightFlush, handRoyalFlush));
		var handsToTest = new ArrayList<>(allHands);
		handsToTest.removeAll(handsToSkip);
		
		
		for ( Hand hand : handsToTest) {
			assertFalse(he.isStraightFlush(hand));
		}
		
	}
	
	@Test
	void testPrintWinner() {
		var expected = String.format("Hand AceC, JackD, SevenC, FiveS, DeuceH wins with High card!%n", null);
		
		var handType = "High card!";
		var handValue = 8;
		var numericCardValues = Arrays.asList(14, 11, 7, 5, 2);
		var winner = new HandData(handType, handValue, numericCardValues, handAceHigh);
		
		var he = new HandEvaluator();
		
		var actual = he.printWinner(winner);
		
		assertEquals(expected, actual);
		
	}

	@Test
	void testPrintSplitPot() {
		
		var exp1 = String.format("Hand AceC, JackD, SevenC, FiveS, DeuceH splitts pot with High card!%n", null);
		var exp2 = String.format("Hand AceD, JackS, SevenH, FiveC, DeuceC splitts pot with High card!%n", null);
		var expected = exp1 + exp2;
		
		var handType = "High card!";
		var handValue = 8;
		var numericCardValues = Arrays.asList(14,11,7,5,2);
		
		var winners = new ArrayList<HandData>(List.of(
				new HandData(handType, handValue, numericCardValues, handAceHigh),
				new HandData(handType, handValue, numericCardValues, handAceHigh2)
				));
		
		var he = new HandEvaluator();
		var actual = he.printSplitPot(winners);
		
		System.out.println(expected);
		System.out.println(actual);
		
		assertEquals(expected, actual);
		
	}

	@Test
	void testPrintLosers() {
		
		var exp1 = String.format("Hand AceC, JackD, SevenC, FiveS, DeuceH loses with High card!%n", null);
		var exp2 = String.format("Hand AceD, JackS, SevenH, FiveC, DeuceC loses with High card!%n", null);
		var expected = exp1 + exp2;
		
		var handType = "High card!";
		var handValue = 8;
		var numericCardValues = Arrays.asList(14,11,7,5,2);
		
		var winners = new ArrayList<HandData>(List.of(
				new HandData(handType, handValue, numericCardValues, handAceHigh),
				new HandData(handType, handValue, numericCardValues, handAceHigh2)
				));
		
		var he = new HandEvaluator();
		var actual = he.printLosers(winners);
		
		System.out.println(expected);
		System.out.println(actual);
		
		assertEquals(expected, actual);
	}

}
