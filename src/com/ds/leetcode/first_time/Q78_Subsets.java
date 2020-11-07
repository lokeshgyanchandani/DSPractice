package com.ds.leetcode.first_time;

import java.util.ArrayList;
import java.util.List;

public class Q78_Subsets {

	static List<List<Integer>> subsets(int[] nums) {
		if (nums.length == 0) return null;

		List<List<Integer>> results = new ArrayList<>();
		helper(nums, null, results, 0);
		return results;
	}

	static void helper(int[] nums, List<Integer> intermediate, List<List<Integer>> results, int start) {
		if (intermediate == null) {
			intermediate = new ArrayList<>();
			results.add(new ArrayList<>(intermediate));
		}

		for (int i = start; i < nums.length; i++) {
			intermediate.add(nums[i]);
			results.add(new ArrayList<>(intermediate));
			helper(nums, intermediate, results, i + 1);
			intermediate.remove(intermediate.size() - 1);
		}
	}

	public static void main(String args[]) {
		List<List<Integer>> results = subsets(new int[] {1, 2, 3});
		for (List<Integer> result : results)
			System.out.println(result);
	}
}
