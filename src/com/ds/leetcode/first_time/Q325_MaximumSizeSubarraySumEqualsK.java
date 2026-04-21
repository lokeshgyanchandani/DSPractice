package com.ds.leetcode.first_time;

import java.util.HashMap;
import java.util.Map;

public class Q325_MaximumSizeSubarraySumEqualsK {

    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0)   return 0;

        int sum = 0, maxLen = 0;
        Map<Integer, Integer> counter = new HashMap<>();

        counter.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // see if there is a previous array whose prefix sum is (sum - k)
            int target = sum - k;
            if (counter.containsKey(target)) {
                maxLen = Math.max(maxLen, i - counter.get(target));
            }
            // put current index into map if this is the first time we see the
            // current prefix sum value (which implies current index is leftmost)
            // keep only 1st duplicate as we want first index as left as possible
            counter.putIfAbsent(sum, i);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Q325_MaximumSizeSubarraySumEqualsK obj = new Q325_MaximumSizeSubarraySumEqualsK();
        int[] nums = new int[]{1, -1, 5, -2, 3};
        int k = 3;

        System.out.println(obj.maxSubArrayLen(nums, k));
    }
}
