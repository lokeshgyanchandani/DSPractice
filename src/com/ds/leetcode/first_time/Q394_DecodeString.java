package com.ds.leetcode.first_time;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Q394_DecodeString {

	public static String decodeString(String s) {
		if (s == null || s.length() == 0) return "";

		Stack<String> sStack = new Stack<>();
		Stack<Integer> nStack = new Stack<>();

		String res = "";
		int i = 0;
		while (i < s.length()) {
			char ch = s.charAt(i);
			if (Character.isDigit(ch)) {
				int num = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					num = num * 10 + (s.charAt(i) - '0');
					i++;
				}

				nStack.push(num);
			} else if (ch == '[') {
				sStack.push(res);
				res = "";
				i++;
			} else if (ch == ']') {
				StringBuilder sb = new StringBuilder(sStack.pop());
				int repeat = nStack.pop();
				for (int count = 0; count < repeat; count++) {
					sb.append(res);
				}

				res = sb.toString();
				i++;
			} else {
				res += ch;
				i++;
			}
		}

		return res;
	}

	public static String decodeStringFaster(String s) {
		Deque<Character> queue = new LinkedList<>();
		for (char c : s.toCharArray()) {
			queue.offer(c);
		}
		return helper(queue);
	}

	private static String helper(Deque<Character> queue) {
		StringBuilder sb = new StringBuilder();
		int num = 0;
		while (!queue.isEmpty()) {
			char c= queue.poll();
			if (Character.isDigit(c)) {
				num = num * 10 + c - '0';
			} else if (c == '[') {
				String sub = helper(queue);
				for (int i = 0; i < num; i++) {
					sb.append(sub);
				}
				num = 0;
			} else if (c == ']') {
				break;
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String input = "3[a]2[bc]";
		System.out.println(decodeStringFaster(input));
	}
}
