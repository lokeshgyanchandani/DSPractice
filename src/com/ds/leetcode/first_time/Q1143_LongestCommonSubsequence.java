package com.ds.leetcode.first_time;

public class Q1143_LongestCommonSubsequence {

	// Method3()- DP solution(Bottom up approach)
	// time complexity - O(m*n)
	// space complexity - O(m*n)
	static int longestCommonSubsequence2D(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		int memo[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					memo[i][j] = 0;
				else if (text1.charAt(i - 1) == text2.charAt(j - 1))
					memo[i][j] = memo[i - 1][j - 1] + 1;
				else
					memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
			}
		}
		return memo[m][n];
	}

	static int longestCommonSubsequence1D(String text1, String text2) {
		int m = text1.length();
		int n = text2.length();
		if (m < n) {
			return longestCommonSubsequence1D(text2, text1);
		}
		int memo[] = new int[n + 1];

		for (int i = 1; i <= m; i++) {
			int prev = 0;
			for (int j = 1; j <= n; j++) {
				int temp = memo[j];
				if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					memo[j] = prev + 1;
				} else {
					memo[j] = Math.max(memo[j], memo[j - 1]);
				}
				prev = temp;
			}

		}
		return memo[n];
	}

	public static void main(String args[]) {

	}
}
