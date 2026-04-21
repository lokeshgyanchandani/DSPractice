package com.ds.leetcode.first_time;

public class Q459_RepeatedSubstringPattern {

	private static boolean repeatedSubstringPattern(String s) {
		if (s == null || s.length() == 0) return true;

		int n = s.length();
		for (int len = 1; len <= n/2; len++) { // pattern must repeat at least twice, i.e. pattern length is at most n/2
			if (n % len != 0) continue; // s length must can be divided by the pattern length

			String pattern = s.substring(0, len);
			int i = len; // start index of 2nd pattern
			int j = i + len - 1; // end index of 2nd pattern
			while (j < n) {
				String subStr = s.substring(i, j + 1);
				if (!subStr.equals(pattern)) break; // failed for this pattern, try next pattern
				i += len;
				j += len;
			}

			// if it past the last substring check, i will be n
			if(i == n) return true;
		}

		return false;
	}

	public static void main(String[] args) {

	}
}
