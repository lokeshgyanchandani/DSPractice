package com.ds.leetcode.first_time;

import java.util.Stack;

public class Q856_ScoreOfParenthesis {

	static int scoreOfParenthesis(String s) {
		if (s == null || s.isEmpty()) return 0;

		Stack<Integer> stack = new Stack<>();
		for (char ch: s.toCharArray()) {
			if (ch == '(') stack.push(-1);
			else {
				int cur = 0;
				while (stack.peek() != -1)
					cur += stack.pop();
				stack.pop();
				stack.push(cur == 0 ? 1 : cur * 2);
			}
		}

		int sum = 0;
		while (!stack.isEmpty())
			sum += stack.pop();
		return sum;
	}

	public static void main(String args[]) {
		System.out.println(scoreOfParenthesis("(()(()))"));
	}
}
