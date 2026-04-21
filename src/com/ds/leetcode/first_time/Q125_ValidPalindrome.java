package com.ds.leetcode.first_time;

public class Q125_ValidPalindrome {

	private static boolean isPalindrome(String s) {
		if (s == null || s.isEmpty()) return true;

		int low = 0, high = s.length() - 1;
		while (low < high) {
			if (!Character.isLetterOrDigit(s.charAt(low)))
				low++;
			else if (!Character.isLetterOrDigit(s.charAt(high)))
				high--;
			else {
				if (Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high)))
					return false;
				low++;
				high--;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("0P"));
	}
}
