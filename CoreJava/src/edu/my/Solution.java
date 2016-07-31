/**
 * 
 */
package edu.my;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * @author Sudha Chinnappa
 * @Created Jul 8, 2016
 */
public class Solution {

	static int findMax(int n, String tree) {
		tree = tree.replace("#", "0");
		String[] values = tree.split(" ");
		int incrementBy = 1;
		ArrayList<ArrayList<String>> resultTree = new ArrayList<ArrayList<String>>();

		for (int i = 0; i < n / 2; i++) {
			ArrayList<String> node = new ArrayList<String>();

			if (!"#".equals(values[i])) {
				node.add(values[i]);
				node.add(values[i + incrementBy]);
				node.add(values[i + incrementBy + 1]);
			}

			incrementBy = incrementBy + 1;
			resultTree.add(node);
		}

		int leftSum = 0, rightSum = 0;
		for (ArrayList<String> node : resultTree) {
			leftSum = leftSum + Integer.parseInt(node.get(1));
			rightSum = rightSum + Integer.parseInt(node.get(2));
		}
		return 0;

	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		// final String fileName = System.getenv("OUTPUT_PATH");
		// BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		int res;
		int _n;
		_n = Integer.parseInt(in.nextLine().trim());

		String _tree;
		try {
			_tree = in.nextLine();
		} catch (Exception e) {
			_tree = null;
		}

		res = findMax(_n, _tree);
		/*
		 * bw.write(String.valueOf(res)); bw.newLine();
		 * 
		 * bw.close();
		 */
	}
}
