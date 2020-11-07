package interview;

public class Evenoddlink {

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
		separate(list.head);
	}

	private static void separate(Node head) {
		Node temp = head;
		boolean f = true;
		Node oddHead = null;
		Node odd = oddHead;
		Node evenHead = null;
		Node even = evenHead;

		while (temp != null) {
			if (f) {
				if (oddHead == null) {
					oddHead = temp;
					odd = temp;
				} else {
					odd.next = temp;
					odd = temp;
				}
				f = !f;
			} else {
				if (evenHead == null) {
					even = temp;
					evenHead = temp;
				} else {
					even.next = temp;
					even = temp;
				}
				f = !f;
			}

			temp = temp.next;
		}
		odd.next = null;
		even.next=null;			
		while (oddHead != null) {
			System.out.print(oddHead.data + " ");
			oddHead = oddHead.next;
		}
		System.out.println();
		while (evenHead != null) {
			System.out.print(evenHead.data + " ");
			evenHead = evenHead.next;
		}
	}
}