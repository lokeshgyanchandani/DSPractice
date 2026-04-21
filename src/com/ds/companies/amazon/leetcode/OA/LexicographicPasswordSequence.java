package com.ds.companies.amazon.leetcode.OA;

import java.util.Scanner;

public class LexicographicPasswordSequence {

    static final int MOD = 1000000007;

    public static int countGreaterSubsequences(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][m] = 1;  // Base case: any subsequence is greater if t is exhausted
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];  // Exclude s[i]
                if (s.charAt(i) > t.charAt(j)) {
                    dp[i][j] = (dp[i][j] + dp[i + 1][j + 1]) % MOD;  // Include s[i]
                }
            }
        }

        return dp[0][0] - 1;  // Subtract 1 to exclude the empty subsequence
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();
        scanner.close();

        System.out.println(countGreaterSubsequences(s, t));
    }
}
