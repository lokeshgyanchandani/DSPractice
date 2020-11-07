package com.ds.companies.amazon.leetcode;

public class BetaTesting {

	static int minDifficulty(int[] jobDifficulty, int D) {
		final int N = jobDifficulty.length;
		if(N < D) return -1;
		int[][] dp = new int[D][N];

		dp[0][0] = jobDifficulty[0];
		for(int j = 1; j < N; ++j){
			dp[0][j] = Math.max(jobDifficulty[j], dp[0][j - 1]);
		}

		for(int d = 1; d < D; ++d){
			for(int len = d; len < N; ++len){
				int localMax = jobDifficulty[len];
				dp[d][len] = Integer.MAX_VALUE;
				for(int schedule = len; schedule >= d; --schedule){
					localMax = Math.max(localMax, jobDifficulty[schedule]);
					dp[d][len] = Math.min(dp[d][len], dp[d - 1][schedule - 1] + localMax);
				}
			}
		}

		return dp[D - 1][N - 1];
	}

	public static void main(String[] args) {

	}
}
