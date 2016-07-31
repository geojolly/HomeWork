package edu.my;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class GE {

	public static void solution(int N) {
		// write your code in Java SE 8
		String[] a = new String[N];

		Arrays.fill(a, "");

		int j = 2;
		while (j < N) {
			a[j] = a[j] + "Fizz";
			j = j + 3;
		}

		int k = 4;
		while (k < N) {
			a[k] = a[k] + "Buzz";
			k = k + 5;
		}

		int l = 6;
		while (l < N) {
			a[l] = a[l] + "Woof";
			l = l + 7;
		}

		for (int i = 0; i < N; i++) {
			if (a[i] == "")
				a[i] = Integer.toString(i + 1);
		}

		for (String str : a)
			System.out.println(str);
	}

	// 0 1 2 3 4 5 6 7 8 9
	public static void numberDivisibleBy357(int number) {
		for (int i = 2; i <= number; i++) {
			System.out.print(i++);
			if (i % 3 == 0 && i % 5 == 0)
				System.out.print("  fizzbuzz ");
			else
				System.out.print("  fizz ");
			i++;

			System.out.print(i++);
			System.out.print("  buzz  ");
			i++;
			System.out.print(i++);
			System.out.print("  woff  ");
			// every third number is divisible by 3
			// every fifth is divisible by 5
			// every seventh is divisible by 7

		}
	}

	public static void stackProblem(String s) {
		String[] splitStringBySpace = s.split(" ");

		Deque<String> stack = new ArrayDeque<String>();

		for (String str : splitStringBySpace) {
			if (isNumeric(str)) {
				stack.push(str);
			} else if ("DUP".equals(str)) {
				// get the first and push it back
				stack.push(stack.getFirst());

			} else if ("POP".equals(str)) {
				stack.pop();

			} else if ("+".equals(str)) {
				String first = stack.pop();
				stack.push(stack.pop() + first);

			} else if ("-".equals(str)) {

			}
		}

		for (String number : stack) {
			System.out.println(number);
		}
	}

	// Googled the below code
	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		//solution(25);

		// numberDivisibleBy357(20);
		stackProblem("13 DUP 4 POP 5 DUP + DUP + -");
	}

	// Implement Stack using linkedlist

	// traverse through the string, perform push pop operation based on the
	// condition

}
