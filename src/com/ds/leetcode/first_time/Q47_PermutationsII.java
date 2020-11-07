package com.ds.leetcode.first_time;

import java.util.ArrayList;
import java.util.List;

public class Q47_PermutationsII {

	static List<List<Integer>> permuteUnique(int[] nums) {
		if (nums.length == 0) { return null; }

		List<List<Integer>> results = new ArrayList<>();
		helper(nums, null, results, new boolean[nums.length]);
		return results;
	}

	static void helper(int[] nums, List<Integer> intermediate, List<List<Integer>> results, boolean[] used) {
		if (intermediate == null)
			intermediate = new ArrayList<>();

		if (intermediate.size() == nums.length) {
			results.add(new ArrayList<>(intermediate));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i]) continue;
			intermediate.add(nums[i]);
			used[i] = true;
			helper(nums, intermediate, results, used);
			used[i] = false;
			intermediate.remove(intermediate.size() - 1);
		}
	}

	public static void main(String args[]) {
		List<List<Integer>> results = permuteUnique(new int[] {1, 1, 2});
		for (List<Integer> result : results)
			System.out.println(result);
	}
}
