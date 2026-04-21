package com.ds.companies.amazon.leetcode.OA;

import java.util.Arrays;

public class MeanRankGroups {

    public static int[] getMeanRankCount(int[] rank) {
        int n = rank.length;
        int[] result = new int[n];

        // Iterate over all possible subarrays
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += rank[j];
                int length = j - i + 1;
                if (sum % length == 0) {
                    int mean = sum / length;
                    if (mean >= 1 && mean <= n) {
                        result[mean - 1]++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] rank1 = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(getMeanRankCount(rank1))); // Output: [1, 2, 3, 2, 1]

        int[] rank2 = {4, 3, 2, 1};
        System.out.println(Arrays.toString(getMeanRankCount(rank2))); // Output: [1, 2, 2, 1]

        int[] rank3 = {4, 7, 3, 6, 5, 2, 1};
        System.out.println(Arrays.toString(getMeanRankCount(rank3))); // Output: [1, 1, 1, 4, 4, 1, 1]
    }
}
