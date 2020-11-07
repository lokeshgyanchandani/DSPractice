package miscellaneous;

class Node {
	int val;
	Node next;

	public Node(int x) {
		this.val = x;
		this.next = null;
	}
}

public class ReverseList {

	
	public Node reverse(Node head)
	{
		if(head == null)
			return null;
		Node prev = null;
		Node current = head;
		while(current != null)
		{
			Node next = current.next;
			current.next= prev;
			prev = current;
			current = next;
		}
		return prev;
	}
	
	public void print(Node head)
	{
		Node start = head;
		while(start!=null)
		{
			System.out.println(start.val);
			start = start.next;
		}
	}
	
	public static void main(String[] args) {
		Node x = new Node(1);
		x.next =new Node(2);
		x.next.next =new Node(3);
		x.next.next.next =new Node(4);
		x.next.next.next.next =new Node(5);
		ReverseList list = new ReverseList();
		list.print(x);
		Node a  =list.reverse(x);
		list.print(a);
	}
	
}
