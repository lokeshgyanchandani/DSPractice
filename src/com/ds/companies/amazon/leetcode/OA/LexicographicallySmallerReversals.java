package com.ds.companies.amazon.leetcode.OA;

public class LexicographicallySmallerReversals {

    public static int countReversals(String s, int k) {
        int count = 0;
        int n = s.length();

        for (int i = 0; i <= n - k; i++) {
            String reversedSubstring = new StringBuilder(s.substring(i, i + k)).reverse().toString();
            String newString = s.substring(0, i) + reversedSubstring + s.substring(i + k);

            if (newString.compareTo(s) < 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "amazon";
        int k = 3;
        System.out.println("Number of reversals: " + countReversals(s, k));
    }
}
