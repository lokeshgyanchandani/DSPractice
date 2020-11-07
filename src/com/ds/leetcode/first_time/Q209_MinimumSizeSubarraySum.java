package com.ds.leetcode.first_time;

public class Q209_MinimumSizeSubarraySum {

	static int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) { return 0; }
		if (nums[0] >= s) return 1;

		int start = 0, end = 0, currSum =0, minLength = nums.length;
		while (end < nums.length) {
			currSum += nums[end++];

			while (currSum >= s) {
				minLength = Math.min(minLength, end - start);
				currSum -= nums[start++];
			}
		}
		return (minLength != nums.length ? minLength : 0);
	}

	public static void main(String args[]) {
		System.out.println(minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
	}
}
