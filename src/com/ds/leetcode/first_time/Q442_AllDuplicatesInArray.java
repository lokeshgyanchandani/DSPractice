package com.ds.leetcode.first_time;

import java.util.ArrayList;
import java.util.List;

public class Q442_AllDuplicatesInArray {

	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();

		if (nums.length == 0) return res;

		int i = 0;
		while (i < nums.length) {
			int temp = nums[i];
			if (nums[i] == -1)
				i++;
			else if (nums[temp - 1] == -1) {
				res.add(i);
				i++;
			} else {
				nums[i] = nums[temp - 1];
				nums[temp - 1] = -1;
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {4, 3, 2, 7, 8, 2, 3, 1};
		System.out.println(findDuplicates(nums));
	}
}
