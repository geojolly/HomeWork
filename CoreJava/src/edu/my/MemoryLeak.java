/**
 * 
 */
package edu.my;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import edu.my.KeylessEntry.Key;

/**
 * @author Sudha Chinnappa
 * @Created Jul 13, 2016
 * 
 *          http://eclipsesource.com/blogs/2013/01/21/10-tips-for-using-the-
 *          eclipse-memory-analyzer/
 */
public class MemoryLeak {

	public static void main(String[] args) {

		Map<Key, String> m = new HashMap<Key, String>();
		while (true)
			for (int i = 0; i < 10000; i++)
				if (!m.containsKey(new Key(i)))
					m.put(new Key(i), "Number:" + i);

		/*Stack<Integer> s = new Stack<>(10000);
		for (int i = 0; i < 10000; i++) {
			s.push(i);
		}

		while (!s.isEmpty()) {
			s.pop();
		}

		while (true) {
			// do something
		}*/

	}

}

class Stack<E> implements Iterable<E> {

	private int N;
	private E[] array;

	@SuppressWarnings("unchecked")
	public Stack(int capacity) {
		array = (E[]) new Object[capacity];
	}

	@Override
	public Iterator<E> iterator() {
		return new StackIterator();
	}

	private class StackIterator implements Iterator<E> {

		private int i = N - 1;

		@Override
		public boolean hasNext() {
			return i >= 0;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return array[i--];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();

		}

	}

	public void push(E item) {
		if (isFull()) {
			throw new RuntimeException("Stack overflow");
		}
		array[N++] = item;
	}

	public E pop() {
		if (isEmpty())
			throw new RuntimeException("Stack underflow");
		E item = array[--N];
		return item;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public int size() {
		return N;
	}

	public boolean isFull() {
		return N == array.length;
	}

	public E peek() {
		if (isEmpty())
			throw new RuntimeException("Stack underflow");
		return array[N - 1];
	}

}

class KeylessEntry {

	static class Key {
		Integer id;

		Key(Integer id) {
			this.id = id;
		}

		@Override
		public int hashCode() {
			return id.hashCode();
		}
	}
}