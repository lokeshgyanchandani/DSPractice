package com.ds.leetcode.first_time;

import java.util.Arrays;

public class Q300_LongestIncreasingSubsequence {

	static int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length == 0)
			return 0;

		int[] dp = new int[nums.length];
		Arrays.fill(dp, 1);
		int result = 1;

		for (int i = 1; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if(nums[i] >= nums[j]){
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
			result = Math.max(result, dp[i]);
		}
		return result;
	}

	public static void main(String args[]) {
		System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
	}
}
