package com.junit5;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;


//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {
	MathUtils mathUtils;
	TestInfo info;
	TestReporter reporter;
	
	@BeforeAll
	static void beforeAllInit() {
		//System.out.println("This needs to be run before all...");
	}
	
	@BeforeEach
	void init(TestInfo info, TestReporter reporter) {
		this.info = info;
		this.reporter = reporter;
		mathUtils = new MathUtils();
		reporter.publishEntry(info.getDisplayName()+" test is in testing");
	}
	
	@AfterEach
	void cleanup() {
		//System.out.println("Cleaning up...");
	}

	@Test
	@DisplayName("Testing Add method...")
	void testAdd() {
		//MathUtils mathUtils = new MathUtils();
		int expected = 2;
		int actual = mathUtils.add(1, 1);
		assertEquals(expected, actual, "This method is to add 2 numbers.");
	}
	
	
	@Test
	void test() {
		//MathUtils mathUtils = new MathUtils();
		double actual = mathUtils.computeCirleArea(10);
		assertEquals(314.1592653589793, actual, "method should return area of circle.");
	}
	
	@Test
	@Order(value = 0)
	void testDivide() {
		
		//MathUtils mathUtils = new MathUtils();
		int expected = 2;
		assertThrows(ArithmeticException.class, ()-> mathUtils.division(1, 0), "Divide by zero should throw");
		//assertEquals(expected, actual, "method should return division of 2 numbers.");
	}
	
	@Test
	@DisplayName("Test development method shoudn't run...")
	@Disabled
	void testDisable() {
		fail("This test is disabled");
	}
	
	
	@Test
	@DisplayName("AssertAll Example")
	void multiplyMethodTest() {
		assertAll(
					()-> assertEquals(2, mathUtils.multiply(2, 1)),
					()-> assertEquals(4, mathUtils.multiply(2, 2)),
					()-> assertEquals(-8, mathUtils.multiply(2, -4)),
					()-> assertEquals(0, mathUtils.multiply(0, 1))
				);
	}
	
	
	@Nested
	@DisplayName("Nested class - Testing add method")
	class TestingAddMethod{
		
		@Test
		@DisplayName("Testing with + numbers")
		void testAddPosetive() {
			assertEquals(4, mathUtils.add(2, 2));
		}
		
		@Test
		@DisplayName("Testing with - numbers")
		void testAddNegative() {
			assertEquals(4, mathUtils.add(6, -2));
		}
		
		@Test
		@DisplayName("Testing with Zero")
		void testAddZero() {
			assertEquals(-2, mathUtils.add(0, -2));
		}
	}
	
	// for repeating test multiple times.
	@RepeatedTest(5)
	@Tag("Repeat")
	void testingRepeated(RepetitionInfo info) {
		//we can get the current repetation with the help  of info object
		double actual = mathUtils.computeCirleArea(10);
		assertEquals(314.1592653589793, actual, "method should return area of circle.");
	}
	
}
