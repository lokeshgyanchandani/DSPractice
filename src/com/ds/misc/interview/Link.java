package interview;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
	}
}

public class Link {
	Node head;
	Node tail;

	public void addLast(Node node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	public void addBegin(Node node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			head = node;
		}
	}

	public void print() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}

	}

	public static void main(String args[]) {
		Link list = new Link();
		list.addLast(new Node(10));
		list.addLast(new Node(20));
		list.addBegin(new Node(30));
		list.addBegin(new Node(40));
		list.print();

	}
}
