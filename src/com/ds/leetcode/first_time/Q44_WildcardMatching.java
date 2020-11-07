package com.ds.leetcode.first_time;

public class Q44_WildcardMatching {

	static boolean isMatch(String s, String p) {
		if (s == null || p == null)
			return false;

		int sLen = s.length();
		int pLen = p.length();

		boolean[][] d = new boolean[sLen+1][pLen+1];
		d[0][0] = true;

		for (int i = 1; i <= pLen; i++)
			if (p.charAt(i-1) == '*') d[0][i] = d[0][i - 1];

		for (int i = 1; i <= sLen; i++) {
			for (int j = 1; j <= pLen; j++) {
				if (s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
					d[i][j] = d[i-1][j-1];
				else if (p.charAt(j-1) == '*')
					d[i][j] = d[i-1][j] || d[i][j-1];
			}
		}
		return d[sLen][pLen];
	}

	public static void main(String args[]) {
		System.out.println(isMatch("a", "a*"));
	}
}
