package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import poker.*;

class HandTest {

	@Test
	void testHand() {
		try {
			new Hand(CardsFixtures.cardsHighcardAce());
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testGetCards() {
		
		// SevenC, JackS, DeuceH, AceC, FiveS
		var cards = new ArrayList<>(CardsFixtures.cardsHighcardAce());
		// after Hand.sortByOccurences() -> AceC, JackD, SevenC, FiveS, DeuceH
		
		var expected = new ArrayList<Card>(List.of(
				cards.get(3),
				cards.get(1),
				cards.get(0),
				cards.get(4),
				cards.get(2)
			));
		
		var hand = new Hand(CardsFixtures.cardsHighcardAce());
		var actual = hand.getCards();
		
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	void testGetCard() {
		
		// SevenC, JackS, DeuceH, AceC, FiveS
		var cards = new ArrayList<>(CardsFixtures.cardsHighcardAce());
		// after Hand.sortByOccurences() -> AceC, JackD, SevenC, FiveS, DeuceH
		var hand = new Hand(CardsFixtures.cardsHighcardAce());
		
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
			
			assertEquals(expected.toString(), actual.toString());
			
		}
		
	}

	@Test
	void testGetSize() {
		
		var expected = 5;
		var hand = new Hand(CardsFixtures.cardsHighcardAce());
		var actual = hand.getSize();
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testToStringNoStraightNoTransform() {

		var expected = "Ac, Jd, 7c, 5s, 2h";
		var hand = new Hand(CardsFixtures.cardsHighcardAce());
		var actual = hand.toString();
		
		assertEquals(expected, actual);
	}

	@Test
	void testToStringStraightNoTransform() {

		var expected = "6c, 5h, 4s, 3d, 2c";
		var hand = new Hand(CardsFixtures.cardsStraight());
		var actual = hand.toString();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testToStringStraightWithTransform() {

		var expected = "5c, 4s, 3h, 2c, Ad";
		var hand = new Hand(CardsFixtures.cardsStraightWheel());
		var actual = hand.toString();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testToStringStraightFlushNoTransform() {

		var expected = "Ac, Kc, Qc, Jc, Tc";
		var hand = new Hand(CardsFixtures.cardsRoyalFlush());
		var actual = hand.toString();
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testToStringStraightFlushWithTransform() {

		var expected = "5c, 4c, 3c, 2c, Ac";
		var hand = new Hand(CardsFixtures.cardsStraightFlushWheel());
		var actual = hand.toString();
		
		assertEquals(expected, actual);
	}
	
	
	@Test
	void testGetNumericCardValues() {
		
		var expected = Arrays.asList(14, 11, 7, 5, 2);
		var hand = new Hand(CardsFixtures.cardsHighcardAce());
		
		assertEquals(expected, hand.getNumericCardValues());
		
	}

	@Test
	void testGetAdditionalHandInfoStraightFlush() {
		
		var hand = new Hand(CardsFixtures.cardsRoyalFlush());
		var expected = "Ace to Ten";
		
		assertEquals(expected, hand.getAdditionalHandInfo());
		
	}
	
	@Test
	void testGetAdditionalHandInfoStraight() {
		
		var hand1 = new Hand(CardsFixtures.cardsStraightWheel());
		var hand2 = new Hand(CardsFixtures.cardsStraight());
		
		var expected1 = "Five to Ace";
		var expected2 = "Six to Deuce";
		
		assertEquals(expected1, hand1.getAdditionalHandInfo());
		assertEquals(expected2, hand2.getAdditionalHandInfo());
		
	}
	
	@Test
	void testGetAdditionalHandInfoFourOfAKind() {
		
		var hand = new Hand(CardsFixtures.cardsFourOfAKindDeuces());
		var expected = "Deuces, (A kicker)";
		
		assertEquals(expected, hand.getAdditionalHandInfo());
		
	}
	
	@Test
	void testGetAdditionalHandInfoFullHouse() {
		
		var hand = new Hand(CardsFixtures.cardsFullHouse());
		var expected = "Deuces full of Threes";
		
		assertEquals(expected, hand.getAdditionalHandInfo());
		
	}
	
	@Test
	void testGetAdditionalHandInfoFlush() {
		
		var hand = new Hand(CardsFixtures.cardsFlush());
		var expected = "Ace high, (Q, J, 7, 2 kicker)";
		
		assertEquals(expected, hand.getAdditionalHandInfo());
		
	}
	
	@Test
	void testGetAdditionalHandInfoThreeOfAKind() {
		
		var hand = new Hand(CardsFixtures.cardsThreeOfAKindDeuces());
		var expected = "Deuces, (A, K kicker)";
		
		assertEquals(expected, hand.getAdditionalHandInfo());
		
	}
	
	@Test
	void testGetAdditionalHandInfoTwoPair() {
		
		var hand = new Hand(CardsFixtures.cardsTwoPairAcesAndDeuces());
		var expected = "Aces and Deuces, (4 kicker)";
		
		assertEquals(expected, hand.getAdditionalHandInfo());
		
	}
	
	@Test
	void testGetAdditionalHandInfoPair() {
		
		var hand = new Hand(CardsFixtures.cardsPairDeuces());
		var expected = "of Deuces, (A, T, 7 kicker)";
		
		assertEquals(expected, hand.getAdditionalHandInfo());
		
	}
	
	@Test
	void testGetAdditionalHandInfoHighcard() {
		
		var hand = new Hand(CardsFixtures.cardsHighcardAce());
		var expected = "Ace, (J, 7, 5, 2 kicker)";
		
		assertEquals(expected, hand.getAdditionalHandInfo());
		
	}
	
	@Test
	void testGetHandType() {
		
		var expected = HandType.HIGHCARD;
		var hand = new Hand(CardsFixtures.cardsHighcardAce());
		
		assertEquals(expected, hand.getHandType(hand.getCards()));
		
	}
	
	@Test
	void testTransformToWheelStraight() {
		
		var expected = Arrays.asList(1,2,3,4,5);
		var hand = new Hand(CardsFixtures.cardsStraightWheel());
		var numericCardValues = hand.getNumericCardValues();
		
		assertNotEquals(expected, numericCardValues);
		assertEquals(expected, hand.transformToWheel(numericCardValues));
		
	}
	
	@Test
	void testTransformToWheelStraightNoWheel() {
		
		var expected = Arrays.asList(6,5,4,3,2);
		var hand = new Hand(CardsFixtures.cardsStraight());
		var numericCardValues = hand.getNumericCardValues();
		
		assertEquals(expected, numericCardValues);
		assertEquals(expected, hand.transformToWheel(numericCardValues));
		
	}
	
	@Test
	void testTransformToWheelStraightFlush() {
		
		var expected = Arrays.asList(1,2,3,4,5);
		var hand = new Hand(CardsFixtures.cardsStraightFlushWheel());
		var numericCardValues = hand.getNumericCardValues();
		
		assertNotEquals(expected, numericCardValues);
		assertEquals(expected, hand.transformToWheel(numericCardValues));
		
	}
	
	@Test
	void testTransformToWheelStraightFlushNoWheel() {
		
		var expected = Arrays.asList(14,13,12,11,10);
		var hand = new Hand(CardsFixtures.cardsRoyalFlush());
		var numericCardValues = hand.getNumericCardValues();
		
		assertEquals(expected, numericCardValues);
		assertEquals(expected, hand.transformToWheel(numericCardValues));
		
	}
	
	@Test
	void testTransformToWheelCardsStraightWheel() {
		
		var expected = new ArrayList<Card>(List.of(
				new Card(CardSuit.C, CardValue.FIVE),
				new Card(CardSuit.S, CardValue.FOUR),
				new Card(CardSuit.H, CardValue.THREE),
				new Card(CardSuit.C, CardValue.DEUCE),
				new Card(CardSuit.D, CardValue.ACE)
				));
		var hand = new Hand(CardsFixtures.cardsStraightWheel());
		
		assertNotEquals(expected.toString(), hand.getCards().toString());
		assertEquals(expected.toString(), hand.transformToWheelCards(hand.getCards()).toString());
	}
	
	@Test
	void testTransformToWheelCardsStraightNoWheel() {
		
		var expected = new ArrayList<Card>(List.of(
				new Card(CardSuit.C, CardValue.SIX),
				new Card(CardSuit.H, CardValue.FIVE),
				new Card(CardSuit.S, CardValue.FOUR),
				new Card(CardSuit.D, CardValue.THREE),
				new Card(CardSuit.C, CardValue.DEUCE)
				));
		var hand = new Hand(CardsFixtures.cardsStraight());
		
		assertEquals(expected.toString(), hand.getCards().toString());
		assertEquals(expected.toString(), hand.transformToWheelCards(hand.getCards()).toString());
	}
	
	@Test
	void testTransformToWheelCardsStraightFlushWheel() {
		
		var expected = new ArrayList<Card>(List.of(
				new Card(CardSuit.C, CardValue.FIVE),
				new Card(CardSuit.C, CardValue.FOUR),
				new Card(CardSuit.C, CardValue.THREE),
				new Card(CardSuit.C, CardValue.DEUCE),
				new Card(CardSuit.C, CardValue.ACE)
				));
		var hand = new Hand(CardsFixtures.cardsStraightFlushWheel());
		
		assertNotEquals(expected.toString(), hand.getCards().toString());
		assertEquals(expected.toString(), hand.transformToWheelCards(hand.getCards()).toString());
	}
	
	@Test
	void testTransformToWheelCardsStraightFlushNoWheel() {
		
		var expected = new ArrayList<Card>(List.of(
				new Card(CardSuit.C, CardValue.ACE),
				new Card(CardSuit.C, CardValue.KING),
				new Card(CardSuit.C, CardValue.QUEEN),
				new Card(CardSuit.C, CardValue.JACK),
				new Card(CardSuit.C, CardValue.TEN)
				));
		var hand = new Hand(CardsFixtures.cardsRoyalFlush());
		
		assertEquals(expected.toString(), hand.getCards().toString());
		assertEquals(expected.toString(), hand.transformToWheelCards(hand.getCards()).toString());
	}
	
	@Test
	void testTransformToWheelCardsImpossible() {
		
		// this case is never reached in code because there is a check wether the HandType is STRAIGHT or STRAIGHTFLUSH
		// before transformToWheelCards gets called. JUnit complained about a missed branch so here we go.
		
		var expected = new ArrayList<Card>(List.of(
				new Card(CardSuit.C, CardValue.ACE),
				new Card(CardSuit.D, CardValue.JACK),
				new Card(CardSuit.C, CardValue.SEVEN),
				new Card(CardSuit.S, CardValue.FIVE),
				new Card(CardSuit.H, CardValue.DEUCE)
				));
		var hand = new Hand(CardsFixtures.cardsHighcardAce());
		
		assertEquals(expected.toString(), hand.getCards().toString());
		assertEquals(expected.toString(), hand.transformToWheelCards(hand.getCards()).toString());
	}
	
	@Test
	void testSortByOccurencesAceHigh() {
		
		// SevenC, JackS, DeuceH, AceC, FiveS
		var cards = new ArrayList<>(CardsFixtures.cardsHighcardAce());
		// after Hand.sortByOccurences() -> AceC, JackD, SevenC, FiveS, DeuceH
			
		var expected = new ArrayList<Card>(List.of(
				cards.get(3),
				cards.get(1),
				cards.get(0),
				cards.get(4),
				cards.get(2)
			));
		
		var hand = new Hand(CardsFixtures.cardsHighcardAce());
		var actual = hand.sortByOccurences(cards);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testSortByOccurencesFullHouse() {
		
		// DeuceC, ThreeD, ThreeH, DeuceD, DeuceS
		var cards = new ArrayList<>(CardsFixtures.cardsFullHouse());
		// after Hand.sortByOccurences() -> DeuceS, DeuceD, DeuceC, ThreeH, ThreeD
			
		var expected = new ArrayList<Card>(List.of(
				cards.get(4),
				cards.get(3),
				cards.get(0),
				cards.get(2),
				cards.get(1)
			));
		
		var hand = new Hand(CardsFixtures.cardsFullHouse());
		var actual = hand.sortByOccurences(cards);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testCompareToBigger() {
		
		var expected = -1;
		var hand1 = new Hand(CardsFixtures.cardsStraightFlush());
		var hand2 = new Hand(CardsFixtures.cardsHighcardAce());
		
		assertEquals(expected, hand1.compareTo(hand2));
		
	}
	
	@Test
	void testCompareToSmaller() {
		
		var expected = 1;
		var hand1 = new Hand(CardsFixtures.cardsTwoPairAcesAndDeuces());
		var hand2 = new Hand(CardsFixtures.cardsStraightWheel());
		
		assertEquals(expected, hand1.compareTo(hand2));
		
	}
	
	@Test
	void testCompareToEqual() {
		
		var expected = 0;
		var hand1 = new Hand(CardsFixtures.cardsFlush());
		var hand2 = new Hand(CardsFixtures.cardsFlushEqual());
		
		assertEquals(expected, hand1.compareTo(hand2));
		
	}
	
	@Test
	void testCompareHighCardBigger() {
		
		var expected = -1;
		var hand = new Hand(CardsFixtures.cardsHighcardAce());
		var otherHand = new Hand(CardsFixtures.cardsHighcardTen());
		var actual = hand.compareHighCard(otherHand);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testCompareHighCardBiggerCaseStraight() {
		
		var expected = -1;
		var hand = new Hand(CardsFixtures.cardsStraight());
		var otherHand = new Hand(CardsFixtures.cardsStraightWheel());
		
		var actual = hand.compareHighCard(otherHand);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testCompareHighCardSmaller() {
		
		var expected = 1;
		var hand = new Hand(CardsFixtures.cardsHighcardTen());
		var otherHand = new Hand(CardsFixtures.cardsHighcardAce());
		var actual = hand.compareHighCard(otherHand);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testCompareHighCardSmallerCaseStraightFlush() {
		
		var expected = 1;
		var hand = new Hand(CardsFixtures.cardsStraightFlush());
		var otherHand = new Hand(CardsFixtures.cardsRoyalFlush());
		var actual = hand.compareHighCard(otherHand);
		
		assertEquals(expected, actual);
		
	}
	
	@Test
	void testCompareHighCardEqual() {
		
		var expected = 0;
		var hand = new Hand(CardsFixtures.cardsHighcardAce());
		var otherHand = new Hand(CardsFixtures.cardsHighcardAceEqual());
		var actual = hand.compareHighCard(otherHand);
		
		assertEquals(expected, actual);
		
	}
	
}
