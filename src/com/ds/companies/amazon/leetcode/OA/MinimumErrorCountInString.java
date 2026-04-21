package com.ds.companies.amazon.leetcode.OA;

import java.util.Arrays;

public class MinimumErrorCountInString {

    public int solve(String s, int x, int y) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }

        long[][] dp = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == '0' || s.charAt(i - 1) == '!') {
                for (int j = 0; j <= i; j++) {
                    if (dp[i - 1][j] < Long.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + j * y);
                    }
                }
            }
            if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '!') {
                for (int j = 1; j <= i; j++) {
                    if (dp[i - 1][j - 1] < Long.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + x * (i - j));
                    }
                }
            }
        }

        long min = Long.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            min = Math.min(min, dp[n][i]);
        }

        return (int) min;
    }

    public static void main(String[] args) {
        MinimumErrorCountInString solver = new MinimumErrorCountInString();
        String errorString = "101!1";
        int x = 2;
        int y = 3;
        System.out.println(solver.solve(errorString, x, y)); // Expected Output: 9
    }
}
