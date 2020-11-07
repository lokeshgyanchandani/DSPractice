package interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Elimination {

	public static void main(String[] args) {
//		 Scanner in  = new Scanner(System.in);
//		    int n = in.nextInt();
//		    int m = in.nextInt();
//		    calculate(n,m);
		calculate(5,2);
	}

	private static void calculate(int n, int m) {
		Cnode head = new Cnode(1);
		Cnode prev = head;
		for(int i=2;i<=n;i++)
		{
			Cnode temp = new Cnode(i);
			prev.next = temp;
			prev = temp;
		}
		prev.next = head;
		System.out.println("print list: ");
		printlist(head);
	
		int delcount =0;
		Cnode temp = head;
		System.out.println("head is : " + temp.data);
		while(delcount < n-m+1)
		{
			for(int j =1;j<m-1;j++)
			{
				temp = temp.next;
			}
			System.out.println("deleted" + temp.next.data);
			temp.next= temp.next.next;
			temp = temp.next;
			delcount++;
		}
		List<Integer> x = new ArrayList<>();
		int current = temp.data;
		x.add(temp.data);
		temp=temp.next;
		
		while(temp.data!=current)
		{
			x.add(temp.data);
			temp = temp.next;
		}
		Collections.sort(x);
		for(int i:x)	
		{
			System.out.println(i);
		}
		
	}

	public static void printlist(Cnode head) {
		int headVal = head.data;
		System.out.println(head.data + "=>");
		Cnode temp = head.next;
		while(temp.data != headVal) {
			System.out.print(temp.data + "=>");
			temp = temp.next;
		}
	}
}

class Cnode
{
	public int data;
	public Cnode next;
	
	public Cnode(int data)
	{
		this.data = data;
		this.next = null;
	}
}

