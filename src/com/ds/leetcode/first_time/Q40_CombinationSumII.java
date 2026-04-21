package com.ds.leetcode.first_time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40_CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        backtrack(result, new ArrayList<>(), target, candidates, 0);

        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> temp, int target,
                           int[] candidates, int startIndex) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        } else if (target < 0)
            return;

        for (int i = startIndex; i < candidates.length; i++) {
            if (i > startIndex && candidates[i] == candidates[i - 1]) continue; // avoid duplicates
            temp.add(candidates[i]);
            backtrack(result, temp, target - candidates[i], candidates, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Q40_CombinationSumII obj = new Q40_CombinationSumII();
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> results = obj.combinationSum2(candidates, 8);
        System.out.println(Arrays.deepToString(results.toArray()));
    }
}
