package edu.my;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pangram {

	public static void main(String[] args) {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT.
		 * Your class should be named Solution.
		 */
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		scan.close();

		// Remove space including tab
		input = input.replaceAll("\\s", "");

		//Convert upper case to lower case
		input = input.toLowerCase();
		
		// Eliminate duplicates by copying to set
		Set<Character> alphabetsSet = new HashSet<Character>();
		for (char c : input.toCharArray()) {
			alphabetsSet.add(c);
		}

		// Check if it only contains characters using regular expression
		//TODO
		
		if (alphabetsSet.size() == 26)
			System.out.println("pangram");
		else
			System.out.println("not pangram");
		return;
	}
}