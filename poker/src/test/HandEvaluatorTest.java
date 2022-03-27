package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import poker.Hand;
import poker.HandEvaluator;

class HandEvaluatorTest {

	private static HandEvaluator handEvaluator;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		handEvaluator = new HandEvaluator();
	}

	@Test
	void testHandEvaluator() {
		try {
			new HandEvaluator();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testEvaluateWinnerSingleWinnerWithLoser() {
		
		var hand1 = new Hand(CardsFixtures.cardsFlush());
		var hand2 = new Hand(CardsFixtures.cardsHighcardQueen());
		
		var expectedWinner = handEvaluator.printWinner(hand1);
		var expectedLoser = handEvaluator.printLosers(new ArrayList<>(List.of(hand2)));
		
		var hands = new ArrayList<Hand>(List.of(hand1, hand2));
		
		var result = handEvaluator.evaluateWinner(hands);
		
		assertEquals(expectedWinner, result.get(0));
		assertEquals(expectedLoser, result.get(1));
		
	}

	@Test
	void testEvaluateWinnerSingleWinnerWithLoserVariant() {
		
		var hand1 = new Hand(CardsFixtures.cardsPairTens());
		var hand2 = new Hand(CardsFixtures.cardsPairTensLow());
		var hand3 = new Hand(CardsFixtures.cardsHighcardQueen());
		
		var expectedWinner = handEvaluator.printWinner(hand1);
		var expectedLoser = handEvaluator.printLosers(new ArrayList<>(List.of(hand2, hand3)));
		
		var hands = new ArrayList<Hand>(List.of(hand3, hand1, hand2));
		
		var result = handEvaluator.evaluateWinner(hands);
		
		assertEquals(expectedWinner, result.get(0));
		assertEquals(expectedLoser, result.get(1));
		
	}
	
	@Test
	void testEvaluateWinnerSingleWinnerNoLoser() {
		
		var hand = new Hand(CardsFixtures.cardsTwoPairAcesAndDeuces());
		
		var expectedWinner = handEvaluator.printWinner(hand);
		var expectedLoser = "";
		
		var hands = new ArrayList<Hand>(List.of(hand));
		
		var result = handEvaluator.evaluateWinner(hands);
		
		assertEquals(expectedWinner, result.get(0));
		assertEquals(expectedLoser, result.get(1));
		
	}
	
	@Test
	void testEvaluateWinnerSplitWithLoser() {
		
		var hand1 = new Hand(CardsFixtures.cardsFlush());
		var hand2 = new Hand(CardsFixtures.cardsFlushEqual());
		var hand3 = new Hand(CardsFixtures.cardsHighcardQueen());
		
		var expectedWinner = handEvaluator.printSplitPot(new ArrayList<>(List.of(hand1, hand2)));
		var expectedLoser = handEvaluator.printLosers(new ArrayList<>(List.of(hand3)));
		
		var hands = new ArrayList<Hand>(List.of(hand3, hand1, hand2));
		
		var result = handEvaluator.evaluateWinner(hands);
		
		assertEquals(expectedWinner, result.get(0));
		assertEquals(expectedLoser, result.get(1));
		
	}
	
	@Test
	void testEvaluateWinnerSplitNoLoser() {
		
		var hand1 = new Hand(CardsFixtures.cardsFlush());
		var hand2 = new Hand(CardsFixtures.cardsFlushEqual());
		
		var expectedWinner = handEvaluator.printSplitPot(new ArrayList<>(List.of(hand1, hand2)));
		var expectedLoser = "";
		
		var hands = new ArrayList<Hand>(List.of(hand1, hand2));
		
		var result = handEvaluator.evaluateWinner(hands);
		
		assertEquals(expectedWinner, result.get(0));
		assertEquals(expectedLoser, result.get(1));
		
	}
	
	@Test
	void testPrintWinner() {
		
		var winner = new Hand(CardsFixtures.cardsFullHouse());
		var expected = String.format(
				"Hand (%s) wins with %s %s%n",
				winner.toString(),
				winner.getHandType(winner.getCards()).getName(),
				winner.getAdditionalHandInfo()
				);
		
		assertEquals(expected, handEvaluator.printWinner(winner));
		
	}

	@Test
	void testPrintSplitPot() {
		
		var winner1 = new Hand(CardsFixtures.cardsFlush());
		var winner2 = new Hand(CardsFixtures.cardsFlushEqual());
		
		var exp1 = String.format(
				"Hand (%s) splitts pot with %s %s%n",
				winner1.toString(),
				winner1.getHandType(winner1.getCards()).getName(),
				winner1.getAdditionalHandInfo()
				);
		
		var exp2 = String.format(
				"Hand (%s) splitts pot with %s %s%n",
				winner2.toString(),
				winner2.getHandType(winner2.getCards()).getName(),
				winner2.getAdditionalHandInfo()
				);
		
		var expected = exp1 + exp2;
		
		assertEquals(expected, handEvaluator.printSplitPot(new ArrayList<>(List.of(winner1, winner2))));
		
	}

	@Test
	void testPrintLosers() {

		var loser1 = new Hand(CardsFixtures.cardsThreeOfAKindDeuces());
		var loser2 = new Hand(CardsFixtures.cardsTwoPairAcesAndDeuces());
		
		var exp1 = String.format(
				"Hand (%s) loses with %s %s%n",
				loser1.toString(),
				loser1.getHandType(loser1.getCards()).getName(),
				loser1.getAdditionalHandInfo()
				);
		
		var exp2 = String.format(
				"Hand (%s) loses with %s %s%n",
				loser2.toString(),
				loser2.getHandType(loser2.getCards()).getName(),
				loser2.getAdditionalHandInfo()
				);
		
		var expected = exp1 + exp2;
		
		assertEquals(expected, handEvaluator.printLosers(new ArrayList<>(List.of(loser1, loser2))));
		
	}

}
