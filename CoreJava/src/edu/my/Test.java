package edu.my;

import java.util.*;

public class Test {
	/*
	 * 
	 * @input Set of words to find anagrams, e.g.
	 * “from”,”on”,”give”,”pool”,”loop”,”polo”,”form”,”no”,”let”
	 * 
	 * @return Set of anagram groups discovered, e.g.
	 * [“form”,”from”],[“no”,”on”],[“loop”,”polo”,”pool”]
	 */
	static Set<Set<String>> solve(Set<String> input) {

		String[] array = input.toArray(new String[input.size()]);
		Set<Set<String>> masterAnagramSet = new HashSet<Set<String>>();

		// set("ab", "ac", "ba", "ca", "cd")
		for (int i = 0; i < array.length; i++) {

			// Check if the string is already in the masterAnagramSet then do
			// not continue

			Set<String> anagramSet = new HashSet<String>();
			// anagramSet.add(array[i]);
			boolean matchFound = false;
			if (array[i] != null && !array[i].isEmpty()) {
				// Hold on to the element and parse through the rest of the set
				for (int j = 1; j < array.length - 1; j++) {
					// check if the strings are null or empty
					if (array[i] != null && !array[i].isEmpty()) {
						// check if length is same
						if (array[i].length() == array[j].length()) {
							// if length is same then change the case
							String str1 = array[i].toUpperCase();
							String str2 = array[j].toUpperCase();

							// Sort the Strings
							char[] chars = array[i].toCharArray();
							Arrays.sort(chars);
							str1 = new String(chars);

							chars = array[j].toCharArray();
							Arrays.sort(chars);
							str2 = new String(chars);

							// check if the strings are equal.
							if (str1.equals(str2)) {
								// do this only once
								if (!matchFound) {
									// System.Out.Println(anagramSet);
									anagramSet.add(array[i]);
									matchFound = true;
								}
								anagramSet.add(array[j]);
							}
						}
					}
				}
			}
			if (matchFound)
				masterAnagramSet.add(anagramSet);
		}
		return masterAnagramSet;
	}

	// DO NOT MODIFY BELOW THIS LINE

	public static void main(String[] args) {

		List<TestCase> cases = getTestCases();
		for (TestCase c : cases) {
			if (c == null) {
				continue;
			}
			String prefix = String.format("%-25s| ", "'" + c.name + "'");
			try {
				runCase(c);
				System.out.println(prefix + "Success");
			} catch (AssertionError e) {
				System.out.println(prefix + "Failed: " + e.getMessage());
				System.out.println("Input: " + c.input);
				System.out.print("Stacktrace: ");
				e.printStackTrace(System.out);
				return;
			}
		}
	}

	static void runCase(TestCase c) throws AssertionError {
		try {
			Set<Set<String>> output = solve(c.input);
			if (c.exceptionClass != null) {
				throw new AssertionError(String.format(
						"Expected exception '%s' but not thrown, '%s' was returned instead", c.exceptionClass, output));
			}
			if (!compareAnswer(c.output, output)) {
				throw new AssertionError(String.format("Wrong answer: expected '%s', actual '%s'", c.output, output));
			}
		} catch (Exception e) {
			if (c.exceptionClass == null || !c.exceptionClass.equals(e.getClass())) {
				throw new AssertionError(String.format("Unexpected exception: %s", e), e);
			}
		}
	}

	static boolean compareAnswer(Set<Set<String>> expected, Set<Set<String>> actual) {
		return Objects.equals(expected, actual);
	}

	@SuppressWarnings("unchecked")
	static List<TestCase> getTestCases() {
		return list(new TestCase() {
			{
				name = "Happy path";
				input = set("ab", "ac", "ba", "ca", "cd");
				output = set(set("ab", "ba"), set("ac", "ca"));
			}
		},

				// More cases
				new TestCase() {
					{
						name = "Many anagrams";
						input = set("abc", "acb", "bac", "bca", "cab", "cba", "q");
						output = set(set("abc", "acb", "bac", "bca", "cab", "cba"));
					}
				}, new TestCase() {
					{
						name = "No anagrams";
						input = set("ab", "ac", "bc");
						output = set();
					}
				}, new TestCase() {
					{
						name = "Long string";
						input = set("abcdefghijklmnopqrstuvwxyz", "bacdefghijklmnopqrstuvwxyz");
						output = set(set("abcdefghijklmnopqrstuvwxyz", "bacdefghijklmnopqrstuvwxyz"));
					}
				},

				// Edge cases
				new TestCase() {
					{
						name = "No items";
						input = set();
						output = set();
					}
				}, new TestCase() {
					{
						name = "Empty string";
						input = set("ab", "ba", "");
						output = set(set("ab", "ba"));
					}
				}, new TestCase() {
					{
						name = "Not a letter";
						input = set("1#@", "@1#", "!&", "&!", "^%#");
						output = set(set("1#@", "@1#"), set("!&", "&!"));
					}
				}, new TestCase() {
					{
						name = "Not a character";
						input = set("\t\n\r\u1003", "\r\n\t\u1003", "\r\n");
						output = set(set("\t\n\r\u1003", "\r\n\t\u1003"));
					}
				},

				// Bad input
				new TestCase() {
					{
						name = "Null input";
						input = null;
						exceptionClass = IllegalArgumentException.class;
					}
				}, new TestCase() {
					{
						name = "Null element";
						input = set("ab", "ba", null);
						exceptionClass = IllegalArgumentException.class;
					}
				},

				null // So we can always use commas after test case definition
		);
	}

	@SafeVarargs
	@SuppressWarnings("varargs")
	static <T> List<T> list(T... items) {
		return Arrays.asList(items);
	}

	@SafeVarargs
	@SuppressWarnings("varargs")
	static <T> Set<T> set(T... items) {
		return new LinkedHashSet<>(list(items));
	}

	static class TestCase {
		String name;
		Set<String> input;
		Set<Set<String>> output;
		Class<?> exceptionClass;
	}
}
