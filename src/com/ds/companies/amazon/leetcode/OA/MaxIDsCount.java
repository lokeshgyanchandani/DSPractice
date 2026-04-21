package com.ds.companies.amazon.leetcode.OA;

import java.util.*;

public class MaxIDsCount {

    public static List<Integer> maxIdsUpToPoint(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxCount = 0;
        List<Integer> result = new ArrayList<>();

        for (int num : arr) {
            if (num > 0) {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
                maxCount = Math.max(maxCount, countMap.get(num));
            } else {
                int key = -num;
                countMap.put(key, countMap.get(key) - 1);
                if (countMap.get(key) + 1 == maxCount) {
                    maxCount = Collections.max(countMap.values(), Comparator.naturalOrder());
                }
            }

            result.add(maxCount);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 1, 2, -1, -1, 2, -1, 2, -1, -2, -2, -2, -2};
        System.out.println(maxIdsUpToPoint(arr));
    }
}
