package interview;

public class Reverse {

	
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
		
		
		String s = "110";
		int sum =0;
		for(int i =s.length()-1;i>=0;i--)
		{
			sum= (int) (sum+((s.charAt(i)-'0') * Math.pow(2,s.length()-i-1)));
		}
		System.out.println("numbsr"+sum);
		Node result = reverseList(list);
		while(result !=null)
		{
			System.out.println(result.data);
			result = result.next;
		}
	}

	public static Node reverseList(Link list) {
		Node prev = null;
		Node temp = list.head;
		while(temp !=null)
		{
			Node next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
		}
		return prev;
	}
}
