package interview;

public class AddNthFromEnd {

	private static void add(int pos, int data, Link list) {
		Node node = new Node(data);
		Node temp = list.head;
		Node temp2 = list.head;
		int i = 0;
		while (i < pos && temp != null) {
			temp = temp.next;
			i++;
		}
		if (i == pos) {
			while (temp != null) {
				temp2 = temp2.next;
				temp = temp.next;
			}
			Node temp3 = temp2.next;
			temp2.next = node;
			node.next = temp3;
		} else {
			System.out.println("error");
		}
	}

	public static void main(String[] args) {
		Link list = new Link();
		list.addLast(new Node(10));
		list.addLast(new Node(20));
		list.addLast(new Node(30));
		list.addLast(new Node(40));
		list.addLast(new Node(50));
		list.addLast(new Node(60));
		list.addLast(new Node(70));
		list.addLast(new Node(80));
		add(6, 14, list);
		list.print();
	}

}
