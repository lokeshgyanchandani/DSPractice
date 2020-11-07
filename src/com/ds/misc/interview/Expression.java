package interview;

import java.util.Scanner;
import java.util.Stack;

public class Expression {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String x = new String(in.nextLine());
		in.close();
		String[] arr = x.split(" ");
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			try {
				int n = Integer.valueOf(arr[i]);
				stack.push(n);
			} catch (NumberFormatException er) {

				int a = stack.pop();
				int b = stack.pop();
				String x1 = arr[i];
				switch (x1) {
				case "+":
					stack.push(a + b);
					break;
				case "-":
					stack.push(b - a);
					break;
				case "*":
					stack.push(a * b);
					break;
				case "/":
					stack.push(b / a);
					break;
				}
			}
		}
		System.out.println(stack.pop());
	}
}
