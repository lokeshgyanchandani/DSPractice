package com.ds.leetcode.first_time;

import java.util.Arrays;

public class Q16_3SumClosest {

	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length <= 2) return -1;

		Arrays.sort(nums);
		int minSum = 10000;

		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1, k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (Math.abs(sum - target) < Math.abs(minSum - target))
					minSum = sum;
				if (sum == target)
					return target;
				else if (sum > target)
					k--;
				else
					j++;
			}
		}

		return minSum;
	}

	public static void main(String[] args) {
		Q16_3SumClosest obj = new Q16_3SumClosest();

		int[] nums = new int[]{-3, -2, -5, 3, -4};
		System.out.println(obj.threeSumClosest(nums, -1));
	}
}
