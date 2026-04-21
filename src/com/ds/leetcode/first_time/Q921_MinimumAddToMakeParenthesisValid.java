package com.ds.leetcode.first_time;

public class Q921_MinimumAddToMakeParenthesisValid {

	static int minAddToMakeValid(String s) {
		if (s == null || s.length() == 0) return 1;

		char[] arr = s.toCharArray();
		int result = 0, openBrackets = 0, closedBrackets = 0;
		for (char a : arr) {
			if (a == '(') {
				if (closedBrackets > openBrackets) {
					result += closedBrackets - openBrackets;
					openBrackets = 0;
					closedBrackets = 0;
				}
				openBrackets++;
			} else {
				closedBrackets++;
			}
		}
		if (closedBrackets != openBrackets)
			result += Math.abs(closedBrackets - openBrackets);

		return result;
	}

	public static void main(String args[]) {
		System.out.println(minAddToMakeValid("()"));
	}
}
