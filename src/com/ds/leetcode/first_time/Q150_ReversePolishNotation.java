package com.ds.leetcode.first_time;

import java.util.Stack;

public class Q150_ReversePolishNotation {

	private int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for (String token: tokens) {
			if (isInteger(token))
				stack.push(Integer.parseInt(token));
			else {
				int last = stack.pop();
				int secondLast = stack.pop();
				char expr = token.charAt(0);
				if (expr == '+')
					stack.push(last + secondLast);
				else if (expr == '-')
					stack.push(last - secondLast);
				else if (expr == '*')
					stack.push(last * secondLast);
				else if (expr == '/')
					stack.push(secondLast / last);
			}
		}
		return stack.pop();
	}

	private boolean isInteger(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (IllegalArgumentException ex) {
			return false;
		}
	}

	public static void main(String[] args) {
		String[] tokens = new String[] {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};

		Q150_ReversePolishNotation obj = new Q150_ReversePolishNotation();
		System.out.println(obj.evalRPN(tokens));
	}
}
