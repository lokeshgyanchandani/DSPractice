package com.ds.leetcode.first_time;

import java.util.Random;

class Solution {

	int[] nums;
	Random rnd;

	public Solution(int[] nums) {
		this.nums = nums;
		this.rnd = new Random();
	}

	public int pick(int target) {
		int result = -1;
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != target)
				continue;
			if (rnd.nextInt(++count) == 0)
				result = i;
		}

		return result;
	}
}

public class Q398_RandomPickIndex {

	public static void main(String[] args) {
		int[] nums = new int[] {1, 2, 3, 3, 3};
		Solution obj = new Solution(nums);
		System.out.println(obj.pick(3));
	}
}
