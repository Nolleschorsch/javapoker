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

import poker.Hand;
import poker.HandData;
import poker.HandEvaluator;

class HandDataTest {
	
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
	void testHandData() {
		try {
			
			var handType = "Foo";
			var handValue = 42;
			var numericCardValues = Arrays.asList(1,2,3,4,5);
			var hand = HandFixtures.straightWheel();
			
			new HandData(handType, handValue, numericCardValues, hand);
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	void testGetHandValue() {
		
		var expected = 42;
		
		var handType = "Foo";
		var handValue = 42;
		var numericCardValues = Arrays.asList(1,2,3,4,5);
		var hand = HandFixtures.straightWheel();
		
		var handData = new HandData(handType, handValue, numericCardValues, hand);
		var actual = handData.getHandValue();
		
		assertEquals(expected, actual);
		
	}

	@Test
	void testGetNumericCardValues() {
		
		var expected = Arrays.asList(1,2,3,4,5);
		
		var handType = "Foo";
		var handValue = 42;
		var numericCardValues = Arrays.asList(1,2,3,4,5);
		var hand = HandFixtures.straightWheel();
		
		var handData = new HandData(handType, handValue, numericCardValues, hand);
		var actual = handData.getNumericCardValues();
		
		assertEquals(expected, actual);
	}

	@Test
	void testGetHand() {
		
		var expected = HandFixtures.straightWheel();
		
		var handType = "Foo";
		var handValue = 42;
		var numericCardValues = Arrays.asList(1,2,3,4,5);
		var hand = HandFixtures.straightWheel();
		
		var handData = new HandData(handType, handValue, numericCardValues, hand);
		var actual = handData.getHand();
		
		assertEquals(expected.toString(), actual.toString());
	}

	@Test
	void testGetHandType() {
		
		var expected = "Foo";
		
		var handType = "Foo";
		var handValue = 42;
		var numericCardValues = Arrays.asList(1,2,3,4,5);
		var hand = HandFixtures.straightWheel();
		
		var handData = new HandData(handType, handValue, numericCardValues, hand);
		var actual = handData.getHandType();
		
		assertEquals(expected, actual);
		
	}

	@Test
	void testCompareToBigger() {
		
//		var expected = 1;
//		
//		var handType = "Foo";
//		var handValue = 42;
//		var numericCardValues = Arrays.asList(1,2,3,4,5);
//		var hand = HandFixtures.straightWheel();
//		
//		var handData = new HandData(handType, handValue, numericCardValues, hand);
//		
//		var otherHandType = "Bar";
//		var otherHandValue = 0;
//		var otherNumericCardValues = Arrays.asList(6,7,8,9,10);
//		var otherHand = HandFixtures.threeOfAKind();
//		
//		var otherHandData = new HandData(otherHandType, otherHandValue, otherNumericCardValues, otherHand);
		
		fail("Not yet implemented");
		
	}

	@Test
	void testCompareToSmaller() {
		fail("Not yet implemented");
	}
	
	@Test
	void testCompareToEqual() {
		fail("Not yet implemented");
	}
	
	@Test
	void testCompareHighCardBigger() {
		fail("Not yet implemented");
	}
	
	@Test
	void testCompareHighCardSmaller() {
		fail("Not yet implemented");
	}
	
	@Test
	void testCompareHighCardEqual() {
		fail("Not yet implemented");
	}
	
	@Test
	void testFoo() {
		fail("Not yet implemented");
	}
	
	@Test
	void testGetHandByNumericValues() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		
		var expected = String.format("Type: Foo%nValue: 42", null);
		
		var handType = "Foo";
		var handValue = 42;
		var numericCardValues = Arrays.asList(1,2,3,4,5);
		var hand = HandFixtures.straightWheel();
		
		var handData = new HandData(handType, handValue, numericCardValues, hand);
		var actual = handData.toString();
		
		assertEquals(expected, actual);
		
	}

}
