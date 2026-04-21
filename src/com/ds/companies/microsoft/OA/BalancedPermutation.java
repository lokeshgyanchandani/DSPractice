package com.ds.companies.microsoft.OA;

public class BalancedPermutation {

    public static String countBalancedNumbers(int[] p) {
        int n = p.length;

        // pos[x] = index where value x appears in p (1-based values)
        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pos[p[i]] = i;
        }

        StringBuilder result = new StringBuilder();
        int minPos = Integer.MAX_VALUE;
        int maxPos = Integer.MIN_VALUE;

        // Process k = 1 to n
        for (int k = 1; k <= n; k++) {
            minPos = Math.min(minPos, pos[k]);
            maxPos = Math.max(maxPos, pos[k]);

            if (maxPos - minPos + 1 == k) {
                result.append('1');
            } else {
                result.append('0');
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int[] p1 = {4, 1, 3, 2};
        System.out.println(countBalancedNumbers(p1));

        int[] p2 = {5, 3, 1, 2, 4};
        System.out.println(countBalancedNumbers(p2));

        int[] p3 = {1, 4, 2, 3};
        System.out.println(countBalancedNumbers(p3));
    }
}
