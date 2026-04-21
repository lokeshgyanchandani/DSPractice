package com.ds.companies.amazon.leetcode.OA;

public class StringAppeal {

    public long appealSum(int[] arr) {
        int[] last = new int[26];
        long res = 0;
        for (int i = 0; i < arr.length; ++i) {
            last[arr[i]] = i + 1;
            for (int j: last)
                res += j;
        }
        return res;
    }
}
