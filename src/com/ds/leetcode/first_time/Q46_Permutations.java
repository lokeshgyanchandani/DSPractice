package com.ds.leetcode.first_time;

import java.util.ArrayList;
import java.util.List;

public class Q46_Permutations {

	static List<List<Integer>> permute(int[] nums) {
		if (nums.length == 0) return null;

		List<List<Integer>> results = new ArrayList<>();
		backtrack(results, null, nums);
		return results;
	}

	static void backtrack(List<List<Integer>> results, List<Integer> intermediate, int[] nums) {
		if (intermediate == null)
			intermediate = new ArrayList<>();

		if (intermediate.size() == nums.length) {
			results.add(new ArrayList<>(intermediate));
			return;
		}

        for (int num : nums) {
            if (intermediate.contains(num)) continue;

            intermediate.add(num);
            backtrack(results, intermediate, nums);
            intermediate.remove(intermediate.size() - 1);
        }
	}

    static List<List<Integer>> permuteFaster(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteRec(nums, 0, result);
        return result;
    }

    static void permuteRec(int[] nums, int begin, List<List<Integer>> result) {

        if (begin == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) temp.add(num);
            result.add(temp);
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            // Swap
            int temp = nums[begin];
            nums[begin] = nums[i];
            nums[i] = temp;

            permuteRec(nums, begin + 1, result);

            // Swap back
            temp = nums[begin];
            nums[begin] = nums[i];
            nums[i] = temp;
        }
    }

	public static void main(String[] args) {
		List<List<Integer>> results = permuteFaster(new int[] {1, 2, 3});
		for (List<Integer> result : results)
			System.out.println(result);
	}
}
