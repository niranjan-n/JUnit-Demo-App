package com.hiest.JUnitDemo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

class MathUtilsTest {
	MathUtils mathUtils;
	TestInfo testInfo;
	TestReporter testReporter;

	@BeforeAll
	static void beforeInit() {
		
		System.out.println("Before initiliazation ...");
	}

	@BeforeEach
	void init(TestInfo testInfo,TestReporter testReporter) {
		this.testReporter =  testReporter;
		this.testInfo = testInfo;
		mathUtils = new MathUtils();
		testReporter.publishEntry("Running the test before each "+testInfo.getDisplayName());

	}

	@AfterEach
	void cleanUp() {
		System.out.println("cleaning up....");
	}

	@Test
	@DisplayName("Renaming testAdd Method")
	void testAdd() {
		System.out.println("Running the test "+testInfo.getDisplayName());
		int expected = 2;
		int actual = mathUtils.add(1, 1);

		// assertEquals(expected, actual);
		assertFalse(expected != actual, "Test Failed ... ");
	}

	@Test
	void testComputeRadius() {
		testReporter.publishEntry("Running the test "+testInfo.getDisplayName());
		assertEquals(314.1592653589793, mathUtils.computeCircleArea(10), "Should return right circle area");
	}

	@Test
	void testDivide() {
		assertThrows(ArithmeticException.class, () -> mathUtils.divide(1, 0), "DIvide by 0 should throw exception");
	}

	@Test
	@DisplayName("Testing Multiply Method")
	void testMultiply() {

		assertAll(() -> assertEquals(5, mathUtils.multiply(5, 1)),
				() -> assertEquals(-5, mathUtils.multiply(5, -1)),
				() -> assertEquals(0, mathUtils.multiply(1, 0)));
	}
}
