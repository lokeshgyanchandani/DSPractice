package interview;

public class Merge {

	public static void main(String[] args) {
		Link list1 = new Link();
		list1.addLast(new Node(10));
		list1.addLast(new Node(30));
		list1.addLast(new Node(50));
		
		Link list = new Link();
		list.addLast(new Node(10));
		list.addLast(new Node(20));
		list.addLast(new Node(30));
		list.addLast(new Node(40));
		list.addLast(new Node(50));
		list.addLast(new Node(60));
		list.addLast(new Node(70));
		list.addLast(new Node(80));
		merge(list.head,list1.head);
	}

	private static void merge(Node l1, Node l2) {
		Node dummy = new Node(0);
		dummy.next = null;
		Node tail = dummy;
		while(l1 != null && l2 !=null)
		{
			if(l1.data <= l2.data)
			{
				dummy.next = l1;
				l1 = l1.next;
				dummy = dummy.next;
			}
			else if(l1.data > l2.data)
			{
				dummy.next = l2;
				l2 = l2.next;
				dummy = dummy.next;
			}
		}
		if(l1==null)
		{
			dummy.next = l2;
		}
		else
		{
			dummy.next = l1;
		}
		 Node x = tail.next;
		while(x != null)
		{
			System.out.println(x.data);
			x = x.next;
		}
	}
}
