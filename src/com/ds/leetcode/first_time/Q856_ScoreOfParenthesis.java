package com.ds.leetcode.first_time;

import java.util.Stack;

public class Q856_ScoreOfParenthesis {

	static int scoreOfParenthesis(String S) {
		if (S == null || S.isEmpty()) return 0;

		Stack<String> stack = new Stack<>();
		for (char c : S.toCharArray()) {
			if (c == '(') stack.push(String.valueOf(c));
			else if (c == ')') {
				String top = stack.pop();
				if (top.equals("(")) {
					stack.push(String.valueOf(1));
				} else if (isInt(top)) {
					int sum = Integer.parseInt(top);
					while (isInt(stack.peek())) {
						String newTop = stack.pop();
						sum += Integer.parseInt(newTop);
					}
					stack.pop();
					stack.push(String.valueOf(2 * sum));
				}
			}
		}
		int total = 0;
		while (!stack.isEmpty())
			total += Integer.parseInt(stack.pop());
		return total;
	}

	private static boolean isInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	public static void main(String args[]) {
		System.out.println(scoreOfParenthesis("(()(()))"));
	}
}
