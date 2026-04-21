package com.ds.leetcode.first_time;

import java.util.Stack;

public class Q20_ValidParenthesis {

	private static boolean isValid(String s) {
		if (s == null || s.isEmpty()) return true;

		Stack<Character> stack = new Stack<>();
		for (char c: s.toCharArray()) {
			if (c == '(' || c == '[' || c == '{')
				stack.push(c);
			else if (c == ')' || c == ']' || c == '}') {
				if (stack.isEmpty()) return false;
				if (c == ')' && stack.peek() != '(') return false;
				if (c == ']' && stack.peek() != '[') return false;
				if (c == '}' && stack.peek() != '{') return false;
				stack.pop();
			}
		}

		return stack.isEmpty();
	}

	private static boolean isValidSmart(String s) {
		Stack<Character> stack = new Stack<>();
		for (char c : s.toCharArray()) {
			if (c == '(')
				stack.push(')');
			else if (c == '{')
				stack.push('}');
			else if (c == '[')
				stack.push(']');
			else if (stack.isEmpty() || stack.pop() != c)
				return false;
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String input = "{[]}";
		System.out.println(isValid(input));
	}
}
