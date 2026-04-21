package com.ds.companies.amazon.leetcode.OA;

import java.util.HashMap;
import java.util.Map;

public class MaximumAudience {

    public static void main(String[] args) {
        int ans = 0;
        String str = "++-++";
        int[] arr = {1, 2, 2, 3, 4};
        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (str.charAt(i) == '+') {
                mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
                ans = Math.max(ans, mp.size());
            } else {
                mp.remove(arr[i]);
                ans = Math.max(ans, mp.size());
            }
        }

        System.out.println(ans);
    }
}
