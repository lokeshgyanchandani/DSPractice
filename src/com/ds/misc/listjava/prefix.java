package listjava;

import java.util.Stack;

public class prefix {

	public static void main(String[] args) {
		String x = "3+12*3-4/7";
		char[] c = x.toCharArray();
		
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Character> s2 = new Stack<Character>();

		for (int i = 0; i < c.length; i++) {
			//System.out.println(i);
			
			
			if (c[i] >= '0' && c[i] <= '9') {
				//System.out.println(c[i]);
				StringBuffer b = new StringBuffer();
				while (i < c.length && c[i] >= '0' && c[i] <= '9') {
					b.append(c[i++]);
				}
				i=i-1;
				int k = Integer.parseInt(b.toString());
				s1.push(k);
				
				
			} 
			else 
			{
				System.out.println(c[i]);
				s2.push(c[i]);
			}
		}

		while (!s1.isEmpty()) {
			System.out.println(s1.pop());
		}
		while (!s2.isEmpty()) {
			System.out.println(s2.pop());
		}
	}
}
