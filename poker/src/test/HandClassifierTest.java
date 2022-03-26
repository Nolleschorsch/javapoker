package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import poker.Deck;
import poker.Hand;
import poker.HandClassifier;
import poker.HandType;

class HandClassifierTest {

	private static HandClassifier handClassifier;
	
	private static Hand handStraightFlush;
	private static Hand handFourOfAKind;
	private static Hand handFullHouse;
	private static Hand handFlush;
	private static Hand handStraight;
	private static Hand handStraightWheel;
	private static Hand handStraightWheelWrong;
	private static Hand handThreeOfAKind;
	private static Hand handTwoPair;
	private static Hand handPair;
	private static Hand handPairSixes;
	private static Hand handPairTens;
	private static Hand handPairTensLow;
	private static Hand handHighcardAce;
	private static Hand handHighcardQueen;
	
	private static List<Hand> allHands;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		handClassifier = new HandClassifier();
		
		handStraightFlush = HandFixtures.straightFlush();
		handFourOfAKind = HandFixtures.fourOfAKind();
		handFullHouse = HandFixtures.fullHouse();
		handFlush = HandFixtures.flush();
		handStraight = HandFixtures.straight();
		handStraightWheel = HandFixtures.straightWheel();
		handStraightWheelWrong = HandFixtures.straightWheelWrong();
		handThreeOfAKind = HandFixtures.threeOfAKind();
		handTwoPair =  HandFixtures.twoPair();
		handPair =  HandFixtures.pair();
		handPairSixes = HandFixtures.pairSixes();
		handPairTens = HandFixtures.pairTens();
		handPairTensLow = HandFixtures.pairTensLow();
		handHighcardAce = HandFixtures.highcardAce();
		handHighcardQueen = HandFixtures.highcardQueen();
		
		allHands = new ArrayList<>(List.of(
				
				handStraightFlush, handFourOfAKind, handFullHouse, handFlush, handStraight,
				handStraightWheel, handStraightWheelWrong, handThreeOfAKind, handTwoPair,
				handPair, handPairSixes, handPairTens, handPairTensLow, handHighcardAce,
				handHighcardQueen

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
	void testHandClassifier() {
		try {
			new HandClassifier();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testClassifyHandStraightFlush() {
		
		var expected = HandType.StraightFlush;
		
		var goodHands = new ArrayList<Hand>(List.of(handStraightFlush));
		var badHands = new ArrayList<Hand>(allHands);
		
		badHands.removeAll(goodHands);

		for (Hand hand : goodHands) {
			assertEquals(expected, handClassifier.classifyHand(hand));
		}
		
		for (Hand hand : badHands) {
			assertNotEquals(expected, handClassifier.classifyHand(hand));
		}
		
	}

	@Test
	void testClassifyHandFourOfKind() {
		
		var expected = HandType.FourOfAKind;
		
		var goodHands = new ArrayList<Hand>(List.of(handFourOfAKind));
		var badHands = new ArrayList<Hand>(allHands);
		
		badHands.removeAll(goodHands);

		for (Hand hand : goodHands) {
			assertEquals(expected, handClassifier.classifyHand(hand));
		}
		
		for (Hand hand : badHands) {
			assertNotEquals(expected, handClassifier.classifyHand(hand));
		}
		
	}
	
	@Test
	void testClassifyHandFullHouse() {
		
		var expected = HandType.FullHouse;
		
		var goodHands = new ArrayList<Hand>(List.of(handFullHouse));
		var badHands = new ArrayList<Hand>(allHands);
		
		badHands.removeAll(goodHands);

		for (Hand hand : goodHands) {
			assertEquals(expected, handClassifier.classifyHand(hand));
		}
		
		for (Hand hand : badHands) {
			assertNotEquals(expected, handClassifier.classifyHand(hand));
		}
		
	}
	
	@Test
	void testClassifyHandFlush() {

		var expected = HandType.Flush;

		var goodHands = new ArrayList<Hand>(List.of(handFlush));
		var badHands = new ArrayList<Hand>(allHands);
		
		badHands.removeAll(goodHands);

		for (Hand hand : goodHands) {
			assertEquals(expected, handClassifier.classifyHand(hand));
		}
		
		for (Hand hand : badHands) {
			assertNotEquals(expected, handClassifier.classifyHand(hand));
		}
		
	}
	
	@Test
	void testClassifyHandStraight() {

		var expected = HandType.Straight;

		var goodHands = new ArrayList<Hand>(List.of(handStraight, handStraightWheel));
		var badHands = new ArrayList<Hand>(allHands);
		
		badHands.removeAll(goodHands);

		for (Hand hand : goodHands) {
			assertEquals(expected, handClassifier.classifyHand(hand));
		}
		
		for (Hand hand : badHands) {
			assertNotEquals(expected, handClassifier.classifyHand(hand));
		}
		
	}
	
	@Test
	void testClassifyHandThreeOfAKind() {

		var expected = HandType.ThreeOfAKind;
	
		var goodHands = new ArrayList<Hand>(List.of(handThreeOfAKind));
		var badHands = new ArrayList<Hand>(allHands);
		
		badHands.removeAll(goodHands);

		for (Hand hand : goodHands) {
			assertEquals(expected, handClassifier.classifyHand(hand));
		}
		
		for (Hand hand : badHands) {
			assertNotEquals(expected, handClassifier.classifyHand(hand));
		}
		
	}
	
	@Test
	void testClassifyHandTwoPair() {

		var expected = HandType.TwoPair;
		
		var goodHands = new ArrayList<Hand>(List.of(handTwoPair));
		var badHands = new ArrayList<Hand>(allHands);
		
		badHands.removeAll(goodHands);

		for (Hand hand : goodHands) {
			assertEquals(expected, handClassifier.classifyHand(hand));
		}
		
		for (Hand hand : badHands) {
			assertNotEquals(expected, handClassifier.classifyHand(hand));
		}
		
	}
	
	@Test
	void testClassifyHandPair() {

		var expected = HandType.Pair;
		
		var goodHands = new ArrayList<Hand>(List.of(handPair, handPairSixes, handPairTens, handPairTensLow));
		var badHands = new ArrayList<Hand>(allHands);
		
		badHands.removeAll(goodHands);

		for (Hand hand : goodHands) {
			assertEquals(expected, handClassifier.classifyHand(hand));
		}
		
		for (Hand hand : badHands) {
			assertNotEquals(expected, handClassifier.classifyHand(hand));
		}
		
	}
	
	@Test
	void testClassifyHandHighCard() {
		
		var expected = HandType.HighCard;
		
		var goodHands = new ArrayList<Hand>(List.of(handHighcardAce, handHighcardQueen, handStraightWheelWrong));
		var badHands = new ArrayList<Hand>(allHands);
		
		badHands.removeAll(goodHands);

		for (Hand hand : goodHands) {
			assertEquals(expected, handClassifier.classifyHand(hand));
		}
		
		for (Hand hand : badHands) {
			assertNotEquals(expected, handClassifier.classifyHand(hand));
		}
		
	}
	
	@Test
	void testIsPair() {
		
		var goodHands = new ArrayList<Hand>(List.of(handPair, handPairSixes, handPairTens, handPairTensLow));
		var badHands = new ArrayList<Hand>(allHands);
		badHands.removeAll(goodHands);
		
		for (Hand hand : goodHands) {
			var uniqueNumericCardValues = Set.copyOf(hand.getNumericCardValues());
			assertTrue(handClassifier.isPair(uniqueNumericCardValues));
		}
		
		for (Hand hand : badHands) {
			var uniqueNumericCardValues = Set.copyOf(hand.getNumericCardValues());
			assertFalse(handClassifier.isPair(uniqueNumericCardValues));
		}
		
	}

	@Test
	void testIsTwoPair() {
		
		var goodHands = new ArrayList<Hand>(List.of(handTwoPair));
		var badHands = new ArrayList<Hand>(allHands);
		badHands.removeAll(goodHands);
		
		for (Hand hand : goodHands) {
			var numericCardValues = hand.getNumericCardValues();
			var uniqueNumericCardValues = Set.copyOf(numericCardValues);
			assertTrue(handClassifier.isTwoPair(uniqueNumericCardValues, numericCardValues));
		}
		
		for (Hand hand : badHands) {
			var numericCardValues = hand.getNumericCardValues();
			var uniqueNumericCardValues = Set.copyOf(numericCardValues);
			assertFalse(handClassifier.isTwoPair(uniqueNumericCardValues, numericCardValues));
		}
		
	}

	@Test
	void testIsThreeOfAKind() {
		
		var goodHands = new ArrayList<Hand>(List.of(handThreeOfAKind));
		var badHands = new ArrayList<Hand>(allHands);
		badHands.removeAll(goodHands);
		
		for (Hand hand : goodHands) {
			var numericCardValues = hand.getNumericCardValues();
			var uniqueNumericCardValues = Set.copyOf(numericCardValues);
			assertTrue(handClassifier.isThreeOfAKind(uniqueNumericCardValues, numericCardValues));
		}
		
		for (Hand hand : badHands) {
			var numericCardValues = hand.getNumericCardValues();
			var uniqueNumericCardValues = Set.copyOf(numericCardValues);
			assertFalse(handClassifier.isThreeOfAKind(uniqueNumericCardValues, numericCardValues));
		}
		
	}

	@Test
	void testIsStraight() {

		var goodHands = new ArrayList<Hand>(List.of(handStraight, handStraightWheel, handStraightFlush));
		var badHands = new ArrayList<Hand>(allHands);
		badHands.removeAll(goodHands);
		
		for (Hand hand : goodHands) {
			assertTrue(handClassifier.isStraight(hand));
		}
		
		for (Hand hand : badHands) {
			assertFalse(handClassifier.isStraight(hand));
		}
		
	}

	@Test
	void testIsFlush() {

		var goodHands = new ArrayList<Hand>(List.of(handFlush, handStraightFlush));
		var badHands = new ArrayList<Hand>(allHands);
		badHands.removeAll(goodHands);
		
		for (Hand hand : goodHands) {
			assertTrue(handClassifier.isFlush(hand));
		}
		
		for (Hand hand : badHands) {
			assertFalse(handClassifier.isFlush(hand));
		}
		
	}

	@Test
	void testIsFullHouse() {
		
		var goodHands = new ArrayList<Hand>(List.of(handFullHouse));
		var badHands = new ArrayList<Hand>(allHands);
		badHands.removeAll(goodHands);
		
		for (Hand hand : goodHands) {
			var numericCardValues = hand.getNumericCardValues();
			var uniqueNumericCardValues = Set.copyOf(numericCardValues);
			assertTrue(handClassifier.isFullHouse(uniqueNumericCardValues, numericCardValues));
		}
		
		for (Hand hand : badHands) {
			var numericCardValues = hand.getNumericCardValues();
			var uniqueNumericCardValues = Set.copyOf(numericCardValues);
			assertFalse(handClassifier.isFullHouse(uniqueNumericCardValues, numericCardValues));
		}
		
	}

	@Test
	void testIsFourOfAKind() {

		var goodHands = new ArrayList<Hand>(List.of(handFourOfAKind));
		var badHands = new ArrayList<Hand>(allHands);
		badHands.removeAll(goodHands);
		
		for (Hand hand : goodHands) {
			var numericCardValues = hand.getNumericCardValues();
			var uniqueNumericCardValues = Set.copyOf(numericCardValues);
			assertTrue(handClassifier.isFourOfAKind(uniqueNumericCardValues, numericCardValues));
		}
		
		for (Hand hand : badHands) {
			var numericCardValues = hand.getNumericCardValues();
			var uniqueNumericCardValues = Set.copyOf(numericCardValues);
			assertFalse(handClassifier.isFourOfAKind(uniqueNumericCardValues, numericCardValues));
		}
		
	}

	@Test
	void testIsStraightFlush() {
		
		var goodHands = new ArrayList<Hand>(List.of(handStraightFlush));
		var badHands = new ArrayList<Hand>(allHands);
		badHands.removeAll(goodHands);
		
		for (Hand hand : goodHands) {
			assertTrue(handClassifier.isStraightFlush(hand));
		}
		
		for (Hand hand : badHands) {
			assertFalse(handClassifier.isStraightFlush(hand));
		}
		
	}

}
