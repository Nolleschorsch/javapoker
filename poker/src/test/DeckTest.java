package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import poker.*;

class DeckTest {

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
	void testDeck() {
		try {
			new Deck();
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testGenerateDeck() {
		
		var suits = CardSuit.values();
		var values = CardValue.values();
		var valuesSize = values.length;
		
		var deck = new Deck();
		var generatedDeck = deck.generateDeck();
		var sizeDeck = deck.getDeck().size();
		
		var suitIndex = 0;
		var valueIndex = 0;
		
		for (var i=0; i<sizeDeck; i++) {
			
			var suit = suits[suitIndex];
			var value = values[valueIndex];
			
			
			var card = new Card(suit, value);
			var generatedCard = generatedDeck.get(i);
			
			assertEquals(card.toString(), generatedCard.toString());
			
			// jump to next suit, reset valueIndex
			if (valueIndex == valuesSize-1) {
				suitIndex++;
				valueIndex = 0;
			} else {
				valueIndex++;
			}
		}
		
	}
	
	@Test
	void testGetDeck() {
		
		var deck = new Deck();
		var expectedSize = 52;
		var actualSize = deck.getDeck().size();
		
		assertEquals(expectedSize, actualSize);
		
	}

	@Test
	void testShuffle() {
		
		var random1 = new Random(42);
		var random2 = new Random(42);
		
		var deck = new Deck(random1);
		// create two decks
		var cards1 = deck.getDeck();
		var cards2 = deck.generateDeck();
		var size = cards2.size();
		
		// shuffle them both with identical random seed
		deck.shuffle();
		Collections.shuffle(cards2, random2);
		
		for(var i=0; i<size; i++) {
			assertEquals(cards1.get(i).toString(), cards2.get(i).toString());
		}
		
	}
	
	@Test
	void testDeal() {
		
		var deck = new Deck();
		var cards = deck.getDeck();
		var deckSize = cards.size();
		var otherCards = deck.generateDeck();
		
		// deal all cards in deck, checks for equality and remaining size
		for (var i=0; i<deckSize; i++) {
			var dealtCard = deck.deal();
			var otherCard = otherCards.get(i);
			assertEquals(dealtCard.toString(), otherCard.toString());
			assertEquals(cards.size(), otherCards.size() - (i + 1));
		}
		
	}
	
	@Test
	void testShuffleUpAndDeal() {
		
		var random1 = new Random(42);
		var random2 = new Random(42);
		
		var deck = new Deck(random1);
		// create two decks
		var cards1 = deck.getDeck();
		var cards2 = deck.generateDeck();
		var size = cards2.size();
		
		// shuffle them both with identical random seed and deal five cards to each player
		var hands = deck.shuffleUpAndDeal(2); // two players
		
		Collections.shuffle(cards2, random2);
		var genHand1Cards = new ArrayList<Card>(List.of(
				cards2.get(0), cards2.get(1), cards2.get(2), cards2.get(3), cards2.get(4)
				));
		var genHand2Cards = new ArrayList<Card>(List.of(
				cards2.get(5), cards2.get(6), cards2.get(7), cards2.get(8), cards2.get(9)
				));
		
		var genHand1 = new Hand(genHand1Cards);
		var genHand2 = new Hand(genHand2Cards);
		
		var genHands = new ArrayList<Hand>(List.of(genHand1, genHand2));
		
		for (var i=0; i<genHands.size(); i++) {
			var hand = hands.get(i);
			var genHand = genHands.get(i); 
			assertEquals(hand.toString(), genHand.toString());
		}

	}

}
