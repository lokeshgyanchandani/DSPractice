package com.ds.leetcode.first_time;

public class Q53_MaxSubArray {
	static int maxSubArray(int[] nums) {
		int maxSum = Integer.MIN_VALUE, sum = 0;
		for (int num : nums) {
			sum = Math.max(num, sum + num);
			maxSum = Math.max(sum, maxSum);
		}
		return maxSum;
	}

	public static void main(String args[]) {
		System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
	}
}
