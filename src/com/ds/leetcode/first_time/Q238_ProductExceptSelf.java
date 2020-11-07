package com.ds.leetcode.first_time;

import java.util.Arrays;

public class Q238_ProductExceptSelf {

	static int[] productExceptSelf(int[] nums) {
		if (nums == null || nums.length == 0) { return new int[] {-1}; }

		int[] res = new int[nums.length];
		Arrays.fill(res, 1);
		int left = 1, right = 1;

		for (int i = 0; i < nums.length; i++) {
			res[i] *= left;
			left *= nums[i];
		}
		for (int i = nums.length - 1; i >= 0; i--) {
			res[i] *= right;
			right *= nums[i];
		}

		return res;
	}

	public static void main(String args[]) {
		System.out.println(Arrays.toString(productExceptSelf(new int[] {1, 2, 3, 4})));
	}
}
