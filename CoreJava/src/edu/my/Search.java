package edu.my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Search {
	public Search() {
		super();
	}

	public static void main(String[] args) {

		// Find missing number in sorted array
		int[] sortedArray = new int[] { 3, 4, 5, 7, 9 };
		System.out.println("Missing number from array " + Arrays.toString(sortedArray) + ": "
				+ missingNumberFromArray(sortedArray));

		printMissingNumbersInSortedArray(sortedArray);
	}

	/*
	 * works when there is only one missing number and the missing number is not
	 * 0
	 */

	private static int missingNumberFromArray(int[] numbers) {
		int first = numbers[0];
		int last = numbers[numbers.length - 1];

		int actualSum = 0;
		int expectedSum = 0;

		for (int i = first; i <= last; i++)
			expectedSum = expectedSum + i;

		for (int i = 0; i < numbers.length; i++)
			actualSum = actualSum + numbers[i];

		return expectedSum - actualSum;
	}

	private static void printMissingNumbersInSortedArray(int[] numbers) {
		int seqStartNumber = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (seqStartNumber != numbers[i]) {
				int diff = numbers[i] - seqStartNumber;
				for (int j = 0; j < diff; j++)
					System.out.print(seqStartNumber++ + ", ");
				seqStartNumber++;
			} else
				seqStartNumber = numbers[i] + 1;
		}
	}
}