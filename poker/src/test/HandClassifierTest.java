package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

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
		
		handStraightFlush = new Hand(CardsFixtures.cardsStraightFlush());
		handFourOfAKind = new Hand(CardsFixtures.cardsFourOfAKindDeuces());
		handFullHouse = new Hand(CardsFixtures.cardsFullHouse());
		handFlush = new Hand(CardsFixtures.cardsFlush());
		handStraight = new Hand(CardsFixtures.cardsStraight());
		handStraightWheel = new Hand(CardsFixtures.cardsStraightWheel());
		handStraightWheelWrong = new Hand(CardsFixtures.cardsStraightWheelWrong());
		handThreeOfAKind = new Hand(CardsFixtures.cardsThreeOfAKindDeuces());
		handTwoPair =  new Hand(CardsFixtures.cardsTwoPairAcesAndDeuces());
		handPair =  new Hand(CardsFixtures.cardsPairDeuces());
		handPairSixes = new Hand(CardsFixtures.cardsPairSixes());
		handPairTens = new Hand(CardsFixtures.cardsPairTens());
		handPairTensLow = new Hand(CardsFixtures.cardsPairTensLow());
		handHighcardAce = new Hand(CardsFixtures.cardsHighcardAce());
		handHighcardQueen = new Hand(CardsFixtures.cardsHighcardQueen());
		
		allHands = new ArrayList<>(List.of(
				
				handStraightFlush, handFourOfAKind, handFullHouse, handFlush, handStraight,
				handStraightWheel, handStraightWheelWrong, handThreeOfAKind, handTwoPair,
				handPair, handPairSixes, handPairTens, handPairTensLow, handHighcardAce,
				handHighcardQueen

				));
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
		
		var expected = HandType.STRAIGHTFLUSH;
		
		var goodHands = new ArrayList<Hand>(List.of(handStraightFlush, new Hand(CardsFixtures.cardsStraightFlushWheel())));
		var badHands = new ArrayList<Hand>(allHands);
		
		
		badHands.removeAll(goodHands);

		for (Hand hand : goodHands) {
			assertEquals(expected, handClassifier.classifyHand(hand.getCards()));
		}
		
		for (Hand hand : badHands) {
			assertNotEquals(expected, handClassifier.classifyHand(hand.getCards()));
		}
		
	}

	@Test
	void testClassifyHandFourOfKind() {
		
		var expected = HandType.FOUROFAKIND;
		
		var goodHands = new ArrayList<Hand>(List.of(handFourOfAKind));
		var badHands = new ArrayList<Hand>(allHands);
		
		badHands.removeAll(goodHands);

		for (Hand hand : goodHands) {
			assertEquals(expected, handClassifier.classifyHand(hand.getCards()));
		}
		
		for (Hand hand : badHands) {
			assertNotEquals(expected, handClassifier.classifyHand(hand.getCards()));
		}
		
	}
	
	@Test
	void testClassifyHandFullHouse() {
		
		var expected = HandType.FULLHOUSE;
		
		var goodHands = new ArrayList<Hand>(List.of(handFullHouse));
		var badHands = new ArrayList<Hand>(allHands);
		
		badHands.removeAll(goodHands);

		for (Hand hand : goodHands) {
			assertEquals(expected, handClassifier.classifyHand(hand.getCards()));
		}
		
		for (Hand hand : badHands) {
			assertNotEquals(expected, handClassifier.classifyHand(hand.getCards()));
		}
		
	}
	
	@Test
	void testClassifyHandFlush() {

		var expected = HandType.FLUSH;

		var goodHands = new ArrayList<Hand>(List.of(handFlush));
		var badHands = new ArrayList<Hand>(allHands);
		
		badHands.removeAll(goodHands);

		for (Hand hand : goodHands) {
			assertEquals(expected, handClassifier.classifyHand(hand.getCards()));
		}
		
		for (Hand hand : badHands) {
			assertNotEquals(expected, handClassifier.classifyHand(hand.getCards()));
		}
		
	}
	
	@Test
	void testClassifyHandStraight() {

		var expected = HandType.STRAIGHT;

		var goodHands = new ArrayList<Hand>(List.of(handStraight, handStraightWheel));
		var badHands = new ArrayList<Hand>(allHands);
		
		badHands.removeAll(goodHands);

		for (Hand hand : goodHands) {
			assertEquals(expected, handClassifier.classifyHand(hand.getCards()));
		}
		
		for (Hand hand : badHands) {
			assertNotEquals(expected, handClassifier.classifyHand(hand.getCards()));
		}
		
	}
	
	@Test
	void testClassifyHandThreeOfAKind() {

		var expected = HandType.THREEOFAKIND;
	
		var goodHands = new ArrayList<Hand>(List.of(handThreeOfAKind));
		var badHands = new ArrayList<Hand>(allHands);
		
		badHands.removeAll(goodHands);

		for (Hand hand : goodHands) {
			assertEquals(expected, handClassifier.classifyHand(hand.getCards()));
		}
		
		for (Hand hand : badHands) {
			assertNotEquals(expected, handClassifier.classifyHand(hand.getCards()));
		}
		
	}
	
	@Test
	void testClassifyHandTwoPair() {

		var expected = HandType.TWOPAIR;
		
		var goodHands = new ArrayList<Hand>(List.of(handTwoPair));
		var badHands = new ArrayList<Hand>(allHands);
		
		badHands.removeAll(goodHands);

		for (Hand hand : goodHands) {
			assertEquals(expected, handClassifier.classifyHand(hand.getCards()));
		}
		
		for (Hand hand : badHands) {
			assertNotEquals(expected, handClassifier.classifyHand(hand.getCards()));
		}
		
	}
	
	@Test
	void testClassifyHandPair() {

		var expected = HandType.PAIR;
		
		var goodHands = new ArrayList<Hand>(List.of(handPair, handPairSixes, handPairTens, handPairTensLow));
		var badHands = new ArrayList<Hand>(allHands);
		
		badHands.removeAll(goodHands);

		for (Hand hand : goodHands) {
			assertEquals(expected, handClassifier.classifyHand(hand.getCards()));
		}
		
		for (Hand hand : badHands) {
			assertNotEquals(expected, handClassifier.classifyHand(hand.getCards()));
		}
		
	}
	
	@Test
	void testClassifyHandHighCard() {
		
		var expected = HandType.HIGHCARD;
		
		var goodHands = new ArrayList<Hand>(List.of(handHighcardAce, handHighcardQueen, handStraightWheelWrong));
		var badHands = new ArrayList<Hand>(allHands);
		
		badHands.removeAll(goodHands);

		for (Hand hand : goodHands) {
			assertEquals(expected, handClassifier.classifyHand(hand.getCards()));
		}
		
		for (Hand hand : badHands) {
			assertNotEquals(expected, handClassifier.classifyHand(hand.getCards()));
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
			assertTrue(handClassifier.isStraight(hand.getCards()));
		}
		
		for (Hand hand : badHands) {
			assertFalse(handClassifier.isStraight(hand.getCards()));
		}
		
	}

	@Test
	void testIsFlush() {

		var goodHands = new ArrayList<Hand>(List.of(handFlush, handStraightFlush));
		var badHands = new ArrayList<Hand>(allHands);
		badHands.removeAll(goodHands);
		
		for (Hand hand : goodHands) {
			assertTrue(handClassifier.isFlush(hand.getCards()));
		}
		
		for (Hand hand : badHands) {
			assertFalse(handClassifier.isFlush(hand.getCards()));
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
			assertTrue(handClassifier.isStraightFlush(hand.getCards()));
		}
		
		for (Hand hand : badHands) {
			assertFalse(handClassifier.isStraightFlush(hand.getCards()));
		}
		
	}

}
