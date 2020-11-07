package com.ds.misc.listjava;

class Node<T> {
	Node<T> prev;
	Node<T> next;
	T element;

	public Node() {
	}
}

public class SinglyLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private Node<T> temp;

	public SinglyLinkedList() {
		head = null;
		tail = null;
	}

	public void addLast(T elem) {
		if (head == null) {
			head = new Node<T>();
			head.element = elem;
			tail = head;
		} else {
			temp = new Node<T>();
			temp.element = elem;
			tail.next = temp;
			temp.prev = tail;
			tail = temp;
		}

	}

	void reverse() {
		Node<T> next;
		Node<T> current = head;
		Node<T> prev = null;

		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;

	}

	void swap() {
		swap(head);
	}

	void swap(Node node) {
		Node prev = node;
		Node curr = node.next;
		head = curr;
		while (prev != null) {
			Node next = curr.next;
			if (next == null || next.next == null) {
				curr.next = prev;
				prev.next = next;
				break;
			}
			curr.next = prev;
			prev.next = next.next;

			prev = next;
			curr = next.next;

		}

	}

	void deletem(int m , int n) {
		deletem(head,m,n);
	}

	void deletem(Node node,int m ,int n)
	{
		Node curr = node;
		Node prev = node;
		int count = 0;
		while(curr!=null)
		{
			if (count==m)
			{
				count = 0;
				int count1 =0;
				while(count1<n )
				{
					if (curr!=null)
					curr=curr.next;
					count1++;
				}
				prev.next = curr;
			}
			else
			{
				prev = curr;
				curr = curr.next;
				count++;
			}

		}
	}
	void print() {
		temp = head;
		while (temp != null) {
			System.out.print(temp.element);
			temp = temp.next;
		}
		System.out.println();
	}

	void kthlast(int n) {
		Node<T> l1 = head;
		Node<T> l2 = head;
		int count = 0;
		while (l1 != null) {
			if (count == n) {
				l1 = l1.next;
				l2 = l2.next;

			} else {
				l1 = l1.next;
				count++;
			}
		}
		System.out.println("kth node== " + l2.element);

	}

	SinglyLinkedList<Integer> sum(SinglyLinkedList<Integer> l1, SinglyLinkedList<Integer> l2) {
		Node<Integer> head1 = l1.head;
		Node<Integer> head2 = l2.head;
		int carry = 0;
		// System.out.println(head1.element);
		// System.out.println(head2.element);
		SinglyLinkedList<Integer> list3 = new SinglyLinkedList<>();

		// int sum = (int)head1.element + (int)head2.element + carry;
		// System.out.println(sum);
		while (head1 != null || head2 != null || carry != 0) {

			int sum;
			sum = carry;
			if (head1 != null) {
				sum = sum + (int) head1.element;
				head1 = head1.next;
			}
			if (head2 != null) {
				sum = sum + (int) head2.element;
				head2 = head2.next;
			}
			int x = sum % 10;
			System.out.println(x);
			carry = sum / 10;
			list3.addLast(x);

		}
		return list3;
	}

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
		list1.addLast(1);
		list1.addLast(2);
		list1.addLast(3);
		list1.addLast(4);
		list1.addLast(5);
		list1.addLast(6);
		list1.addLast(7);
		list1.addLast(8);
		list1.print();
		list1.deletem(1,0);
		list1.print();
	}
}