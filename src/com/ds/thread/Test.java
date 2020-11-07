package multithreading;

import java.util.Stack;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Test {

public boolean isValid(String s) {
       char[] arr = s.toCharArray();
       int m =0;
       int n = arr.length-1;
       while(m<n)
       {
    	   char  a = arr[m];
    	   arr[m] = arr[n];
    	   arr[n] =a;
    	   m++;
    	   n--;
       }
       System.out.println(arr);
       return true;
    }

	public static void main(String args[]) {
		Test t = new Test();
		System.out.println(t.isValid("ashss"));
	}
}
