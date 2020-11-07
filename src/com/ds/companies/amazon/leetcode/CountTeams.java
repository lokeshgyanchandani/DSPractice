package com.ds.companies.amazon.leetcode;

import java.util.Arrays;

public class CountTeams {

	static int countTeams(int num, int[] skills, int minAssociates, int minLevel, int maxLevel) {
		int total = 0;
		for (int skill: skills) {
			if (skill >= minLevel && skill <= maxLevel) total++;
		}

		int k = minAssociates;
		int[] dp = new int[k];
		Arrays.fill(dp, 0);
		dp[0] = 1;

		for(int i = 1;i<=total;i++) {
			for(int j = Math.min(i, k-1); j>0; j--)
				dp[j] += dp[j-1];
		}
		int res = (1 << total);

		for(int i = 0;i<k;i++) {
			res -= dp[i];
		}

		return res;
	}

	public static void main(String[] args) {
		int num = 6;
		int[] skills = new int[] {12, 4, 6, 13, 5, 10};
		int minAssociates = 3;
		int minLevel = 4;
		int maxLevel = 10;

		System.out.println(countTeams(num, skills, minAssociates, minLevel, maxLevel));
	}
}
