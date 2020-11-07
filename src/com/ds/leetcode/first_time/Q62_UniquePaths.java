package com.ds.leetcode.first_time;

public class Q62_UniquePaths {
	static int uniquePaths2D(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0)
					dp[i][j] = 1;
				else
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

	static int uniquePaths1D(int m, int n) {
		if (m == 0 || n == 0)
			return 0;
		if (m == 1 || n == 1)
			return 1;
		int[] arr = new int[m];
		for (int i = 0; i < m; i++)
			arr[i] = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				arr[j] += arr[j - 1];
			}
		}
		return arr[m - 1];
	}

	public static void main(String args[]) {
		System.out.println(uniquePaths1D(7, 3));
	}
}
