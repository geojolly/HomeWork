/**
 * 
 */
package edu.my;

import java.io.*;
import java.util.*;

/**
 * @author Sudha Chinnappa
 * @Created Jul 8, 2016
 */
public class HackerRank {
	public static void main(String[] args) throws IOException {
		input.init(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n = input.nextInt();
		int[] ds = new int[1 << (2 * n)];
		Arrays.fill(ds, 99999999);
		int init = 0;
		for (int i = 0; i < n; i++) {
			int x = input.nextInt();
			init += (x - 1) << (2 * i);
		}
		ds[init] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(init);
		while (!q.isEmpty()) {
			int at = q.poll();
			int[] tops = new int[4];
			Arrays.fill(tops, n + 1);
			for (int i = n - 1; i >= 0; i--) {
				int cur = (at >> (2 * i)) & 3;
				tops[cur] = i;
			}
			for (int i = 0; i < 4; i++)
				for (int j = 0; j < 4; j++) {
					if (tops[j] > tops[i]) {
						int next = at - i * (1 << 2 * (tops[i])) + j * (1 << 2 * (tops[i]));
						if (ds[next] > 1 + ds[at]) {
							ds[next] = 1 + ds[at];
							q.add(next);
						}
					}
				}
		}
		out.println(ds[0]);

		out.close();
	}

	public static class input {
		static BufferedReader reader;
		static StringTokenizer tokenizer;

		static void init(InputStream input) {
			reader = new BufferedReader(new InputStreamReader(input));
			tokenizer = new StringTokenizer("");
		}

		static String next() throws IOException {
			while (!tokenizer.hasMoreTokens())
				tokenizer = new StringTokenizer(reader.readLine());
			return tokenizer.nextToken();
		}

		static int nextInt() throws IOException {
			return Integer.parseInt(next());
		}

		static double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}

		static long nextLong() throws IOException {
			return Long.parseLong(next());
		}
	}
}
