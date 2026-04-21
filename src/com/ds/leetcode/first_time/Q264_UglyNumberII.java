package com.ds.leetcode.first_time;

public class Q264_UglyNumberII {

    public int nthUglyNumber(int n) {
        int[] result = new int[n];
        result[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;
        int nexti2 = 2, nexti3 = 3, nexti5 = 5;

        for (int i = 1; i < n; i++) {
            int min = Math.min(nexti2, Math.min(nexti3, nexti5));
            result[i] = min;
            if (min == nexti2)
                nexti2 = 2 * result[++i2];
            if (min == nexti3)
                nexti3 = 3 * result[++i3];
            if (min == nexti5)
                nexti5 = 5 * result[++i5];
        }

        return result[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Q264_UglyNumberII().nthUglyNumber(10));
    }
}
