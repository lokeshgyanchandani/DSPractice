package interview;


public class DeleteSpecificLinkListNode {

	public static void main(String[] args) {
		Link list = new Link();

		list.addLast(new Node(20));
		list.addLast(new Node(20));
		list.addLast(new Node(30));
		list.addLast(new Node(20));
		list.addLast(new Node(20));
		list.addLast(new Node(60));
		list.addLast(new Node(70));
		list.addLast(new Node(20));
		list.addLast(new Node(20));
		// list.print();

		deleteList(list, 20);
		Node result = list.head;
		while (result != null) {
			System.out.println(result.data);
			result = result.next;
		}

	}

	private static void deleteList(Link list, int target) {
		Node prev = null;
		Node cur = list.head;
		while (cur != null) {
			if (cur.data == target) {
				if (prev == null) {
					cur = cur.next;
					list.head = cur;
				} else {
					Node next = cur.next;
					prev.next = next;
					cur = next;
				}
			} else {
				prev = cur;
				cur = cur.next;
			}

		}

	}

}
