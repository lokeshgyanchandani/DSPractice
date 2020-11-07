package com.ds.leetcode.first_time;

public class Q713_SubarrayProductLessThanK {

	static int numSubarrayProductLessThanK(int[] nums, int k) {
		if (k <= 1) return 0;

		int left = 0, right = 0, prod = 1, count = 0;
		while (right < nums.length) {
			prod *= nums[right];
			while (prod >= k) {
				prod /= nums[left];
				left++;
			}
			count += right - left + 1;
			right++;
		}

		return count;
	}

	public static void main(String args[]) {
		System.out.println(numSubarrayProductLessThanK(new int[] {10, 5, 2, 6}, 100));
	}
}
