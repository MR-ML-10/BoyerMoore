import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for the BoyerMoore string searching algorithm. This class contains
 * a series of unit tests that verify the functionality of the BoyerMoore
 * algorithm through a variety of test cases, including different texts and
 * patterns, to ensure its reliability and efficiency in finding substrings
 * within strings.
 *
 * @author Abdulrahman Al Rajhi
 * @file: BoyerMooreTest.java
 * @assignment: Final Team Project
 * @course: CSC 345 Spring 2024
 * @date: 04/14/2024
 * @version: 1.0
 */
class BoyerMooreTest {
	/**
	 * Setup method that runs before each test execution. It outputs a start message
	 * to the console indicating the beginning of a test.
	 */
	@BeforeEach
	void setup() {
		System.out.println("\n======================== Test Start ========================");
	}

	/**
	 * Tear down method that runs after each test execution. It outputs an end
	 * message to the console indicating the end of a test.
	 */
	@AfterEach
	void tearDown() {
		System.out.println("\n======================== Test End  ========================");
	}

	/**
	 * Utility method to print the text and pattern of the BoyerMoore instance.
	 * 
	 * @param bm The BoyerMoore instance containing the text and pattern.
	 */
	private void print(BoyerMoore bm) {
		System.out.println("Text: " + bm.getText());
		System.out.println("Pattern: " + bm.getPattern() + '\n');
	}

	/**
	 * Test to verify that the pattern "tooth" is found within a long string.
	 */
	@Test
	void test1() {
		BoyerMoore bm = new BoyerMoore("TRUSTHARDTOOTHAMAZING", "tooth");
		print(bm);
		assertTrue(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "TRUTH" is found within a long string.
	 */
	@Test
	void test2() {
		BoyerMoore bm = new BoyerMoore("WE HOLD THESE TRUTHS TO BE SELF-EVIDENT", "TRUTH");
		print(bm);
		assertTrue(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "TEST" is found within a long string.
	 */
	@Test
	void test3() {
		BoyerMoore bm = new BoyerMoore("THIS IS SOME TEST", "TEST");
		print(bm);
		assertTrue(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "be" is found within a long string.
	 */
	@Test
	void test4() {
		BoyerMoore bm = new BoyerMoore("You must be the change you wish to see in the world. -Mahatma Gandhi", "be");
		print(bm);
		assertTrue(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "without" is found within a long string.
	 */
	@Test
	void test5() {
		BoyerMoore bm = new BoyerMoore(
				"Spread love everywhere you go. Let no one ever come to you without leaving happier. -Mother Teresa",
				"without");
		print(bm);
		assertTrue(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "light" is found within a long string.
	 */
	@Test
	void test6() {
		BoyerMoore bm = new BoyerMoore(
				"Darkness cannot drive out darkness: only light can do that. Hate cannot drive out hate: only love can do that. -Martin Luther King Jr.",
				"light");
		print(bm);
		assertTrue(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "fear" is found within a long string.
	 */
	@Test
	void test7() {
		BoyerMoore bm = new BoyerMoore("The only thing we have to fear is fear itself. -Franklin D. Roosevelt", "fear");
		print(bm);
		assertTrue(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "Teresa" is found within a long string.
	 */
	@Test
	void test8() {
		BoyerMoore bm = new BoyerMoore(
				"Spread love everywhere you go. Let no one ever come to you without leaving happier. -Mother Teresa",
				"Teresa");
		print(bm);
		assertTrue(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "better" is found within a long string.
	 */
	@Test
	void test9() {
		BoyerMoore bm = new BoyerMoore("Well done is better than well said. -Benjamin Franklin", "better");
		print(bm);
		assertTrue(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "beautiful" is found within a long string.
	 */
	@Test
	void test10() {
		BoyerMoore bm = new BoyerMoore(
				"The best and most beautiful things in the world cannot be seen or even touched - they must be felt with the heart. -Helen Keller",
				"beautiful");
		print(bm);
		assertTrue(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "darkest" is found within a long string.
	 */
	@Test
	void test11() {
		BoyerMoore bm = new BoyerMoore(
				"It is during our darkest moments that we must focus to see the light. -Aristotle", "darkest");
		print(bm);
		assertTrue(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "trail" is found within a long string.
	 */
	@Test
	void test12() {
		BoyerMoore bm = new BoyerMoore(
				"Do not go where the path may lead, go instead where there is no path and leave a trail. -Ralph Waldo Emerson",
				"trail");
		print(bm);
		assertTrue(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "yourself" is found within a long string.
	 */
	@Test
	void test13() {
		BoyerMoore bm = new BoyerMoore("Be yourself; everyone else is already taken. -Oscar Wilde", "yourself");
		print(bm);
		assertTrue(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "a" is found within a long string.
	 */
	@Test
	void test14() {
		BoyerMoore bm = new BoyerMoore("a", "a");
		print(bm);
		assertTrue(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "z" is found within a long string.
	 */
	@Test
	void test15() {
		BoyerMoore bm = new BoyerMoore("abc", "z");
		print(bm);
		assertFalse(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "aa" is found within a long string.
	 */
	@Test
	void test16() {
		BoyerMoore bm = new BoyerMoore("aaaaa", "aa");
		print(bm);
		assertTrue(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "" is found within a long string.
	 */
	@Test
	void test17() {
		BoyerMoore bm = new BoyerMoore("empty", "");
		print(bm);
		assertFalse(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "notempty" is found within a long string.
	 */
	@Test
	void test18() {
		BoyerMoore bm = new BoyerMoore("", "notempty");
		print(bm);
		assertFalse(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "cat" is found within a long string.
	 */
	@Test
	void test19() {
		BoyerMoore bm = new BoyerMoore("The quick brown fox jumps over the lazy dog", "cat");
		print(bm);
		assertFalse(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "G" is found within a long string.
	 */
	@Test
	void test20() {
		BoyerMoore bm = new BoyerMoore("FFFFFFFFFFFFFFF", "G");
		print(bm);
		assertFalse(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "End" is found within a long string.
	 */
	@Test
	void test21() {
		BoyerMoore bm = new BoyerMoore("PatternAtTheEndEnd", "End");
		print(bm);
		assertTrue(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "instance" is found within a long string.
	 */
	@Test
	void test22() {
		BoyerMoore bm = new BoyerMoore("Multiple instances found in this instance", "instance");
		print(bm);
		assertTrue(bm.findPattern());
	}

	/**
	 * Test to verify that the pattern "10" is found within a long string.
	 */
	@Test
	void test23() {
		BoyerMoore bm = new BoyerMoore("123456789", "10");
		print(bm);
		assertFalse(bm.findPattern());
	}
}
