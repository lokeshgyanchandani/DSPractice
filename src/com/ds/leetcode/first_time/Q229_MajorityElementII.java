package com.ds.leetcode.first_time;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q229_MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();

        int nTimes = nums.length / 3;
        for (int num: nums) {
            if (!count.containsKey(num) || (count.containsKey(num) && count.get(num) != -1)) {
                int newCount = count.getOrDefault(num, 0) + 1;
                if (newCount > nTimes) {
                    result.add(num);
                    count.put(num, -1);
                } else
                    count.put(num, newCount);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 1, 1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 3};
        Q229_MajorityElementII obj = new Q229_MajorityElementII();
        System.out.println(obj.majorityElement(nums));
    }
}
