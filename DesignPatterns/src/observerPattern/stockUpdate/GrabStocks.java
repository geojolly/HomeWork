package observerPattern.stockUpdate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GrabStocks {

	public static void main(String[] args) {

		Node head = null;
		head = InsertNth(head, 5, 0);
		System.out.println(head.toString());

		Node newNode2 = new Node();
		newNode2.data = 30;
		newNode2.next = null;
		
		Node newNode1 = new Node();
		newNode1.data = 20;
		newNode1.next = newNode2;

		Node newNode = new Node();
		newNode.data = 10;
		newNode.next = newNode1;

		newNode = InsertNth(newNode, 15, 3);
		System.out.println(newNode.toString());
		/*
		 * System.out.println(maxSum); StockGrabber stockGrabber = new
		 * StockGrabber();
		 * 
		 * StockObserver stockObserver1 = new StockObserver(stockGrabber);
		 * 
		 * stockGrabber.setApplPrice(120.00); stockGrabber.setIbmPrice(130.00);
		 * stockGrabber.setGoogPrice(140.00);
		 * 
		 * stockGrabber.unregisterObserver(stockObserver1); StockObserver
		 * stockObserver2 = new StockObserver(stockGrabber);
		 * 
		 * stockGrabber.setApplPrice(125.00); stockGrabber.setIbmPrice(135.00);
		 * stockGrabber.setGoogPrice(145.00);
		 */
	}

	static Node InsertNth(Node head, int data, int position) {
		// This is a "method-only" submission.
		// You only need to complete this method.
		Node newNode = new Node();
		newNode.data = data;

		if (head == null || position == 0) {
			newNode.next = head;
			return newNode;
		}

		int inc = 0;
		Node first = head;
		Node second = head.next;
		while (first.next != null) {
			inc++;
			if (inc == position)
				break;
			
			Node temp = second;
			first=second;
			second = temp.next;
		}

		first.next = newNode;
		newNode.next = second;
		
		return head;
	}
}

class Node {
	int data;
	Node next;

	public String toString() {
		return data + " --> " + (next == null ? null : next.toString());
	}
}
