import java.util.HashMap;
import java.util.Scanner;

/**
 * A Java implementation of the Boyer-Moore algorithm for string matching. This
 * class provides methods to run test cases using JUnit, handle custom text and
 * pattern string inputs, and execute the Boyer-Moore string matching algorithm
 * to find patterns within a specified pattern string.
 *
 * @author Abdulrahman Al Rajhi
 * @file: BoyerMoore.java
 * @assignment: Final Team Project
 * @course: CSC 345 Spring 2024
 * @date: 04/14/2024
 * @version: 1.0
 */
public class BoyerMoore {

	private String text;
	private String pattern;
	HashMap<Character, Integer> table;

	/**
	 * The main method that serves as the entry point for the Boyer-Moore algorithm
	 * application. It handles user interaction for running default test cases and
	 * custom patterns.
	 *
	 * @param args Command line arguments (not used).
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to the Boyer-Moore algorithm!\n");
		Scanner scanner = new Scanner(System.in);
		runCustomTexts(scanner);
		scanner.close();
		System.out.print("\nExiting the Boyer-Moore application. Goodbye!");
	}

	/**
	 * Constructs a new BoyerMoore instance initialized with a specific text and
	 * pattern.
	 *
	 * @param text    The text string to be searched.
	 * @param pattern The pattern string in which the search is performed.
	 */
	public BoyerMoore(String text, String pattern) {
		this.text = text;
		this.pattern = pattern;
		this.table = new HashMap<>();
	}

	/**
	 * Implements the Boyer-Moore text matching algorithm to find the specified text
	 * within the pattern.
	 *
	 * @return true if the text is found in the pattern, false otherwise.
	 */
	public boolean findPattern() {
		// getting the inputs
		text = validateInput(text);
		pattern = validateInput(pattern);

		// making sure they aren't nul;
		if (text == null || pattern == null) {
			return false;
		}

		// getting their lengths
		int textLength = this.text.length();
		int patternLength = this.pattern.length();

		int shifts = 0;
		// while shifts is less than the text - pattern lengths
		while (shifts <= (textLength - patternLength)) {

			int i = patternLength - 1;
			// Iterate through the word in reverse order starting at the rightmost
			while (i >= 0 && text.charAt(shifts + i) == pattern.charAt(i)) {
				i--;
			}
			// if i becomes -1
			if (i < 0) { // we found a match!
				System.err.println("Found a match!");
				System.out.println("Patterns occur at shift = " + shifts + "\n");
				return true;
			} else {
				// we shift the window right according to the bad table
				shifts += badCharacterTable(text.charAt(shifts + i));
			}
		}
		// Pattern not found
		System.err.println("Pattern not found!\n");
		return false;
	}

	/**
	 * Builds and uses a bad match table to calculate the shift for the next
	 * potential match, based on the last character of the mismatch.
	 *
	 * @param letter The character from the text where the mismatch occurred.
	 * @return The number of positions the search window should be shifted right.
	 */
	public int badCharacterTable(char letter) {
		char lastLetter = pattern.charAt(pattern.length() - 1);

		// Iterate through the word except the last character
		for (int i = 0; i < pattern.length() - 1; i++) {
			// getting the value formula = Value = length - index - 1 (letter doesn't exist
			// = pattern length)
			int value = pattern.length() - i - 1;
			table.put(pattern.charAt(i), value);
		}

		// Check if the last letter was already defined; if not, set its value to word's
		// length
		if (!table.containsKey(lastLetter)) {
			table.put(lastLetter, pattern.length());
		} else {
			// If already defined, just correct its position to be the actual last
			// occurrence
			table.put(lastLetter, 0);
		}

		// System.out.println(table);
		if (table.containsKey(letter)) {
			return table.get(letter);
		}
		// return word.length() if the letter doesn't exist in the table or the original
		// lenght if the word if it's size 1
		return pattern.length() > 1 ? pattern.length() - 1 : pattern.length();
	}

	/**
	 * Prompts and processes user input for custom text and pattern string, and
	 * searches for the text in the pattern.
	 *
	 * @param scanner The Scanner object used for reading input from the console.
	 */
	private static void runCustomTexts(Scanner scanner) {
		String input;
		do {
			input = promptForYesNoInput(scanner, "Do you want to run custom texts? (yes/no): ");
			if ("yes".equals(input)) {
				processCustomTextAndPattern(scanner);
			} else {
				break;
			}
		} while (true);
	}

	/**
	 * This method prompts the user with a specific message and make sure the user
	 * enters "yes" or "no".
	 *
	 * @param scanner The Scanner object used for reading input from the console.
	 * @param message A prompt message to display to the user.
	 * @return The user's trimmed input as a String.
	 */
	private static String promptForYesNoInput(Scanner scanner, String message) {
		String input;
		do {
			System.out.print(message);
			input = scanner.nextLine().trim().toLowerCase();
			if (input.equals("yes") || input.equals("no")) {
				return input;
			} else {
				System.err.println("Please enter 'yes' or 'no'.");
				System.out.println();
			}
		} while (true);
	}

	/**
	 * Utility method to prompt the user with a specific message and return the
	 * trimmed input.
	 *
	 * @param scanner The Scanner object used for reading input from the console.
	 * @param message A prompt message to display to the user.
	 * @return The user's trimmed input as a String.
	 */
	private static String promptForInput(Scanner scanner, String message) {
		String input;
		do {
			System.out.print(message);
			input = scanner.nextLine().trim();
			if (input.isEmpty()) {
				System.out.println("Input cannot be empty. Please try again.");
				System.out.println();
			}
		} while (input.isEmpty());
		return input;
	}

	/**
	 * Handles user input for custom patterns and patterns, creates a BoyerMoore
	 * object, and finds the text in the pattern.
	 *
	 * @param scanner The Scanner object used for reading input from the console.
	 */
	private static void processCustomTextAndPattern(Scanner scanner) {
		String text = promptForInput(scanner, "Please enter the text to search for: ");
		String pattern = promptForInput(scanner, "Please enter the pattern string to search for: ");
		System.out.println();

		BoyerMoore bm = new BoyerMoore(text, pattern);
		bm.run();
	}

	/**
	 * Runs the text search using the Boyer-Moore algorithm and prints the results
	 * to the console.
	 */
	public void run() {
		System.out.println("Searching for text '" + text + "' in pattern '" + pattern + "' ...\n");
		findPattern();
	}

	/**
	 * Validates and processes a string to be in a suitable format for the
	 * algorithm.
	 *
	 * @param word The string to be validated and formatted.
	 * @return The formatted string or null if input is invalid.
	 */
	private String validateInput(String word) {
		if (word == null || word.length() == 0) {
			return null; // or throw IllegalArgumentException("Input string cannot be null");
		}
		return word.toUpperCase().strip();
	}

	/**
	 * Gets the text string.
	 * 
	 * @return the text string.
	 */
	public String getText() {
		return text;
	}

	/**
	 * Gets the pattern string.
	 * 
	 * @return the pattern string.
	 */
	public String getPattern() {
		return pattern;
	}
}
