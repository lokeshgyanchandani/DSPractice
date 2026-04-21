package com.ds.leetcode.first_time;

public class Q678_ValidParenthesisString {

	private static boolean checkValidString(String s) {
		if (s == null || s.isEmpty()) return true;

		int low = 0, high = 0;
		for (char ch : s.toCharArray()) {
			if (ch == '(') {
				low++;
				high++;
			} else if (ch == ')') {
				if (low > 0) low--;
				high--;
			} else {
				if (low > 0) low--;
				high++;
			}
			if (high < 0) return false;
		}
		return low == 0;
	}

	public static void main(String[] args) {

	}
}
