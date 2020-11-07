package interview;

public class SortLinklist {

	public static void main(String[] args) {
		Link list = new Link();
		list.addLast(new Node(90));
		list.addLast(new Node(20));
		list.addLast(new Node(15));
		list.addLast(new Node(40));
		list.addLast(new Node(87));
		list.addLast(new Node(60));
		list.addLast(new Node(54));
		list.addLast(new Node(80));
		//list.print();
		Node result = mergelist(list.head);
		while (result != null) {
			System.out.println(result.data);
			result = result.next;
		}
	}

	private static Node mergelist(Node list) {

		if (list == null || list.next == null)
			return list;
		
		Node slow= list;
		Node fast = list.next.next;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		Node x = mergelist(slow.next);
		slow.next = null;
		return merge(mergelist(list), x);

	}

	private static Node merge(Node h1, Node h2) {
		Node hn = new Node(Integer.MIN_VALUE);
		Node c = hn;
		while (h1 != null && h2 != null) {
			if (h1.data < h2.data) {
				c.next = h1;
				h1 = h1.next;
			} else {
				c.next = h2;
				h2 = h2.next;
			}
			c = c.next;
		}
		if (h1 != null)
			c.next = h1;
		if (h2 != null)
			c.next = h2;
		return hn.next;
	}
}
