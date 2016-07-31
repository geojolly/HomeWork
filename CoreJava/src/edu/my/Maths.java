package edu.my;

public class Maths {
	public Maths() {
		super();
	}

	public static void main(String[] args) {
		String str = "cat";
		printFactorialOfString("", str);
		printFibonacciSeriesIterative(10);
	}

	private static void printFactorialOfString(String perm, String word) {
		if (word.isEmpty())
			System.out.print(perm + " ");

		for (int i = 0; i < word.length(); i++)
			printFactorialOfString(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1, word.length()));
	}

	private static void printFibonacciSeriesIterative(int number) {
		int first = 0;
		int second = 1;
		int sum = 0;
		System.out.println();
		for (int i = 0; i < number; i++) {
			sum = first + second;
			System.out.print(sum + " ");
			first = second;
			second = sum;
		}
	}
}