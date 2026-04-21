package com.ds.leetcode.first_time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q47_PermutationsII {

    // DOES NOT WORK without SORT
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

    // SORT is NECESSARY
    List<List<Integer>> permuteUniqueSort(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultList = new ArrayList<>();
        traverse(resultList, new ArrayList<>(), nums, new boolean[nums.length]);
        return resultList;
    }

    public void traverse(List<List<Integer>> resultList, List<Integer> intermediate, int[] nums,
                         boolean[] used) {
        if (intermediate.size() == nums.length)
            resultList.add(new ArrayList<>(intermediate));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || ( i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) ) // remove duplicate
                    continue;
                intermediate.add(nums[i]);
                used[i] = true;
                traverse(resultList, intermediate, nums, used);
                used[i] = false;
                intermediate.remove(intermediate.size() - 1);
            }
        }
    }

	public static void main(String[] args) {
		List<List<Integer>> results = permuteUnique(new int[] {1, 1, 2});
		for (List<Integer> result : results)
			System.out.println(result);
	}
}
