package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import poker.Hand;
import poker.HandEvaluator;

class HandEvaluatorTest {

	private static HandEvaluator handEvaluator;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		handEvaluator = new HandEvaluator();
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
			new HandEvaluator();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testEvaluateWinnerSingleWinnerWithLoser() {
		
		var hand1 = HandFixtures.flush();
		var hand2 = HandFixtures.highcardQueen();
		
		var expectedWinner = handEvaluator.printWinner(hand1);
		var expectedLoser = handEvaluator.printLosers(new ArrayList<Hand>(List.of(hand2)));
		
		var hands = new ArrayList<Hand>(List.of(hand1, hand2));
		
		var result = handEvaluator.evaluateWinner(hands);
		
		assertEquals(expectedWinner, result.get(0));
		assertEquals(expectedLoser, result.get(1));
		
		
	}

	@Test
	void testEvaluateWinnerSingleWinnerWithLoserVariant() {
		
		var hand1 = HandFixtures.pairTens();
		var hand2 = HandFixtures.pairTensLow();
		var hand3 = HandFixtures.highcardQueen();
		
		var expectedWinner = handEvaluator.printWinner(hand1);
		var expectedLoser = handEvaluator.printLosers(new ArrayList<Hand>(List.of(hand2, hand3)));
		
		var hands = new ArrayList<Hand>(List.of(hand3, hand1, hand2));
		
		var result = handEvaluator.evaluateWinner(hands);
		
		assertEquals(expectedWinner, result.get(0));
		assertEquals(expectedLoser, result.get(1));
		
		
	}
	
	@Test
	void testEvaluateWinnerSingleWinnerNoLoser() {
		
		var hand = HandFixtures.twoPair();
		
		var expectedWinner = handEvaluator.printWinner(hand);
		var expectedLoser = "";
		
		var hands = new ArrayList<Hand>(List.of(hand));
		
		var result = handEvaluator.evaluateWinner(hands);
		
		assertEquals(expectedWinner, result.get(0));
		assertEquals(expectedLoser, result.get(1));
		
		
	}
	
	@Test
	void testEvaluateWinnerSplitWithLoser() {
		
		var hand1 = HandFixtures.flush();
		var hand2 = HandFixtures.flush2();
		var hand3 = HandFixtures.highcardQueen();
		
		var expectedWinner = handEvaluator.printSplitPot(new ArrayList<Hand>(List.of(hand1, hand2)));
		var expectedLoser = handEvaluator.printLosers(new ArrayList<Hand>(List.of(hand3)));
		
		var hands = new ArrayList<Hand>(List.of(hand3, hand1, hand2));
		
		var result = handEvaluator.evaluateWinner(hands);
		
		assertEquals(expectedWinner, result.get(0));
		assertEquals(expectedLoser, result.get(1));
		
		
	}
	
	@Test
	void testEvaluateWinnerSplitNoLoser() {
		
		var hand1 = HandFixtures.flush();
		var hand2 = HandFixtures.flush2();
		
		var expectedWinner = handEvaluator.printSplitPot(new ArrayList<Hand>(List.of(hand1, hand2)));
		var expectedLoser = "";
		
		var hands = new ArrayList<Hand>(List.of(hand1, hand2));
		
		var result = handEvaluator.evaluateWinner(hands);
		
		assertEquals(expectedWinner, result.get(0));
		assertEquals(expectedLoser, result.get(1));
		
		
	}
	
	@Test
	void testPrintWinner() {
		
		var winner = HandFixtures.fullHouse();
		var expected = String.format("Hand %s wins with %s%n", winner.toString(), winner.getHandType(winner));
		
		assertEquals(expected, handEvaluator.printWinner(winner));
		
	}

	@Test
	void testPrintSplitPot() {
		
		var winner1 = HandFixtures.flush();
		var winner2 = HandFixtures.flush2();
		
		var exp1 = String.format("Hand %s splitts pot with %s%n", winner1.toString(), winner1.getHandType(winner1));
		var exp2 = String.format("Hand %s splitts pot with %s%n", winner2.toString(), winner2.getHandType(winner2));
		
		var expected = exp1 + exp2;
		
		assertEquals(expected, handEvaluator.printSplitPot(new ArrayList<Hand>(List.of(winner1, winner2))));
		
	}

	@Test
	void testPrintLosers() {

		var loser1 = HandFixtures.threeOfAKind();
		var loser2 = HandFixtures.twoPair();
		
		var exp1 = String.format("Hand %s loses with %s%n", loser1.toString(), loser1.getHandType(loser1));
		var exp2 = String.format("Hand %s loses with %s%n", loser2.toString(), loser2.getHandType(loser2));
		
		var expected = exp1 + exp2;
		
		assertEquals(expected, handEvaluator.printLosers(new ArrayList<Hand>(List.of(loser1, loser2))));
		
	}

}
