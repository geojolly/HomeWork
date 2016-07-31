package edu.my;

import java.util.Stack;

public class LinkedLists {

	public static void main(String[] args) {
		Node first = new Node(10);
		Node second = new Node(20);
		Node third = new Node(30);
		first.next = second;
		second.next = third;

		ReversePrint(first);
		
		System.out.println(first);
		first = Delete(first, 0);
		System.out.println(first);
		
		
	}

	static Node Delete(Node head, int position) {
		
		if(position == 0)
			return head = head.next;
		
		// Complete this method
		Node prevNode = head;
		Node nextNode = head.next;
		int traverse = 1;
		while (prevNode != null) {
			if (traverse == position) {
				prevNode.next = nextNode.next;
				return head;
			}

			traverse++;
			prevNode = nextNode;
			nextNode = prevNode.next;
		}

		return head;
	}
	
	static void ReversePrint(Node head) {
		Stack<Integer> stack = new Stack<Integer>();
		
		while(head!=null){
			stack.add(head.data);
			head = head.next;
		}
		
		for(int i=0;i<stack.size()   ;i++){
			System.out.println(stack.pop());
		}
	}
}

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}

	public String toString() {
		return this.data + " --> " + (this.next == null ? null : this.next.toString());
	}
}
