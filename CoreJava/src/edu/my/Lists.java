package edu.my;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lists {
	public Lists() {
		super();
	}

	public static void main(String[] args) {
		List<String> books = new ArrayList<String>();
		books.add("Beautiful Code");
		books.add("Clean Code");
		books.add("Working Effectively with Legacy Code");
		System.out.println("Original order of List: " + books);
		Collections.reverse(books);
		System.out.println("The reversed List: " + books);
		// // Now, let's try to reverse a List using recursion
		List<String> output = reverseListRecursively(books);
		System.out.println("Reversed list reversed again: " + output);
	}

	public static List<String> reverseListRecursively(List<String> list) {
		/**
		 * List myList = new ArrayList(); you can only call methods and
		 * reference members that belong to List class. If you define it as:
		 * 
		 * ArrayList myList = new ArrayList(); you'll be able to invoke
		 * ArrayList specific methods and use ArrayList specific members in
		 * addition to those inherited from List.
		 * 
		 * Nevertheless, when you call a method of a List class in the first
		 * example, which was overridden in ArrayList, then method from
		 * ArrayList will be called not the one in the List. That's called
		 * polymorphism.
		 */

		List<String> reversedList = new ArrayList<String>();

		// Base case
		if (list.size() <= 1) {
			return list;
		}

		reversedList.add(list.get(list.size() - 1));
		reversedList.addAll(reverseListRecursively(list.subList(0, list.size() - 1)));
		return reversedList;
	}
}
