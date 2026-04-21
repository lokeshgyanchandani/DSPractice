package com.ds.leetcode.first_time;

public class Q1249_MinimumRemoveToMakeValidParenthesis {

	private static String minRemoveToMakeValid(String s) {
		if (s == null || s.isEmpty()) return s;

		int closeAllowed = 0;
		int maxClose = 0;
		for (int i = 0; i < s.length(); i++)  if (s.charAt(i) == ')') maxClose++;

		StringBuilder sb = new StringBuilder();

		for (char c: s.toCharArray()) {
			if (c == '(') {
				if (closeAllowed == maxClose) continue;
				closeAllowed++;
			} else if (c == ')') {
				maxClose--;
				if (closeAllowed == 0) continue;
				closeAllowed--;
			}

			sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		System.out.println(minRemoveToMakeValid("(a(b(c)d)"));
	}
}
