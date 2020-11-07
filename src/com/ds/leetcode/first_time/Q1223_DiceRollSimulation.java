package com.ds.leetcode.first_time;

public class Q1223_DiceRollSimulation {

	private static int mod = 1000000007;

	static int dieSimulator(int n, int[] rollMax) {
		if(n == 1) {
			return rollMax.length;
		}

		// dp[i][j] number of valid combination with i number of rolls and dice end with j+1 value.
		// dp[i][rollMax.length] total number of valid combinations with i number of rolls.
		long[][] dp = new long[n+1][rollMax.length + 1];
		for(int i = 0; i < rollMax.length; ++i) {
			dp[1][i] = 1;
		}

		// when there is 0 rolls there is only one combination (empty)
		dp[0][rollMax.length] = 1;
		// total number with 1 roll;
		dp[1][rollMax.length] = rollMax.length;

		long total = 0;
		long totalEndWithCurNum = 0;
		for(int i = 2; i <= n; ++i) {
			total = 0;
			for(int j = 0; j < rollMax.length; ++j) {
				totalEndWithCurNum = 0;
				// based on max allowed occurence to calculate the possible combinations end with j + 1
				for(int k = 1; k <= rollMax[j] && i >= k; ++k) {
					// dp[i-k][rollMax.length] - dp[i-k][j]  is number of combinations that i-k rolls have that does not end with j+1
					// the rest k rolls with have consistent value of j + 1
					// in this way, the new combination is still valid.
					totalEndWithCurNum += (dp[i-k][rollMax.length] - dp[i-k][j] + mod) % mod;
					totalEndWithCurNum %= mod;
				}

				total += totalEndWithCurNum;
				total %= mod;
				dp[i][j] = totalEndWithCurNum;
			}

			dp[i][rollMax.length] = total;
		}

		return (int)total;
	}

	public static void main(String args[]) {
		System.out.println(dieSimulator(3, new int[] {1, 1, 1, 2, 2, 3}));
	}
}
