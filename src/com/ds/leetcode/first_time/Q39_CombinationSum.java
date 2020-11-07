package com.ds.leetcode.first_time;

import java.util.ArrayList;
import java.util.List;

public class Q39_CombinationSum {

	static List<List<Integer>> combinationSum(int[] candidates, int target) {

		if (candidates.length == 0) { return null; }
		List<List<Integer>> results = new ArrayList<>();
		helper(candidates, target, 0, null, results);
		return results;
	}

	static void helper(int[] candidates, int target, int start, List<Integer> intermediate, List<List<Integer>> result) {
		if (intermediate == null)
			intermediate = new ArrayList<>();

		if (target < 0) { return; }
		else if (!intermediate.isEmpty() && target == 0) {
			result.add(new ArrayList<>(intermediate));
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			intermediate.add(candidates[i]);
			helper(candidates, target - candidates[i], i, intermediate, result);
			intermediate.remove(intermediate.size() - 1);
		}
	}

	public static void main(String args[]) {
		List<List<Integer>> results = combinationSum(new int[] {2,3,6,7}, 7);
		for (List<Integer> result : results)
			System.out.println(result);
	}
}
