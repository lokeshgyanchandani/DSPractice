package interview;

public class MtoNreverse {

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
		list.print();
		reverseSpecific(1, 4, list);
		// pairwiseSwap(list);
		// while (result != null) {
		// System.out.println(result.data);
		// result = result.next;
		// }
	}

	private static Node reverseSpecific(int m, int n, Link list) {
		Node temp = list.head;
		int k = 1;
		Node prev = null;
		Link templist = new Link();
		while (k < m) {
			prev = temp;
			temp = temp.next;
			k++;
		}
		k = k - 1;
		while (k < n) {
			templist.addLast(temp);
			temp = temp.next;
			k++;
		}
		templist.addLast(null);
		Node x = reverseList(templist);
		Node temp1 = x;
		Node end = null;
		while (temp1 != null) {
			end = temp1;
			temp1 = temp1.next;
		}
		if (prev != null) {
			prev.next = x;
		}
		else
		{
			list.head =x;
		}
		end.next = temp;
		list.print();
		return null;
	}

	public static Node reverseList(Link list) {
		Node prev = null;
		Node temp = list.head;
		while (temp != null) {
			Node next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
		}
		return prev;
	}

	public static void pairwiseSwap(Link list) {
		Node current = list.head;
		while (current != null) {
			int temp = current.data;
			current.data = current.next.data;
			current.next.data = temp;
			current = current.next.next;
		}

		Node x = list.head;
		while (x != null) {
			System.out.println(x.data);
			x = x.next;
		}
	}
}
