package com.ds.leetcode.first_time;

public class Q680_ValidPalindromeII {

	private static boolean validPalindrome(String s) {
		if (s == null || s.isEmpty()) return true;

		return helper(s, 0, s.length() - 1, false);
	}

	private static boolean helper(String s, int start, int end, boolean hasDeleted) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				if (hasDeleted) return false;
				else return helper(s, start + 1, end, true) || helper(s, start, end - 1, true);
			}
			start++;
			end--;
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(validPalindrome("ebcbbececabbacecbbcbe"));
	}
}
