package interview;

public class MtoNhelper {

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
			reverseSpecific(1, 2, list);
			// pairwiseSwap(list);
			// while (result != null) {
			// System.out.println(result.data);
			// result = result.next;
			// }
		}

		private static void reverseSpecific(int m, int n, Link list) {
			Node dummy = new Node(0);
			dummy.next = list.head;
			Node mthNode = null;
			Node first = dummy;
			Node last = dummy;
			while(--m > 0)
			{
				first = first.next;
			}
			mthNode = first.next;
			while(n-- >=0)
			{
				last = last.next;
			}
			
			Node newhead = mthNode;
			Node prev = null;
			while(newhead!=last)
			{
				Node next = newhead.next;
				newhead.next = prev;
				prev = newhead;
				newhead = next;
			}
			 first.next= prev;
			 mthNode.next = last;
			 
			 Node start = dummy.next;
			while(start !=null)
			{
				System.out.println(start.data);
				start = start.next;
			}
			
		}
	}

