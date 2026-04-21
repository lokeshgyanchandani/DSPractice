package com.ds.companies.amazon.leetcode.OA;

public class BitManipulation {

    public static int fun(String s) {
        int i = s.length() - 1;
        int j = 0;
        int count = 0;

        while (j < s.length()) {
            while (j < s.length() && s.charAt(j) != s.charAt(i)) {
                j++;
                count++;
            }
            j++;
            i--;
        }

        return count;
    }
}
