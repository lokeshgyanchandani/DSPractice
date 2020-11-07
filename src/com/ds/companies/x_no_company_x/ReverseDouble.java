package com.ds.companies.x_no_company_x;

class DoubleNode {
	int val;
	DoubleNode prev;
	DoubleNode next;
	DoubleNode head;

	public DoubleNode(int val) {
		this.val = val;
		this.next = null;
		this.prev = null;
		if (head == null)
			head = this;
	}

	public DoubleNode reverse() {
		DoubleNode prev = null;
		DoubleNode current = head;
		while (current != null) {
			DoubleNode next = current.next;
			current.next = prev;
			current.prev = next;
			prev = current;
			current = next;
		}
		return prev;
	}

	public void display() {
		DoubleNode current = head;
		while (current != null) {
			System.out.println(current.val + " ");
			current = current.next;
		}
	}
}

public class ReverseDouble {

	public static void main(String[] args) {

		DoubleNode node1 = new DoubleNode(1);
		DoubleNode node2 = new DoubleNode(2);
		DoubleNode node3 = new DoubleNode(3);
		DoubleNode node4 = new DoubleNode(4);
		node1.next = node2;
		node2.prev = node1;
		node2.next = node3;
		node3.prev = node2;
		node3.next = node4;
		node4.prev = node3;
		node1.display();
		DoubleNode x = node1.reverse();
		x.display();
	}

}
