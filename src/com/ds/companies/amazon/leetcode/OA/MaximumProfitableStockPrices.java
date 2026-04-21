package com.ds.companies.amazon.leetcode.OA;

import java.util.Stack;

public class MaximumProfitableStockPrices {

    public static int countMaximumProfitableGroups(int[] stockPrice, int n) {
        int count = 0;

        // Iterate over all possible subarrays
        for (int l = 0; l < n; l++) {
            int maxInSubarray = stockPrice[l];
            for (int r = l; r < n; r++) {
                // Update the maximum value in the subarray
                maxInSubarray = Math.max(maxInSubarray, stockPrice[r]);

                // Check if the current subarray is "maximum profitable"
                if (stockPrice[l] == maxInSubarray || stockPrice[r] == maxInSubarray) {
                    count++;
                }
            }
        }

        return count;
    }

    public static int monotonicStack(int[] v) {
        Stack<Integer> stack = new Stack<>();
        int n = v.length, r = 0;
        int[] e = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && v[stack.peek()] < v[i]) {
                // [top..i - 1] is what we want. Note it may contain equal elements.
                r += i - stack.pop();
            }
            if (!stack.isEmpty()) {
                e[i] = (v[stack.peek()] > v[i]) ? (i - stack.peek()) : (i - stack.peek() + e[stack.peek()] - 1);
            } else {
                e[i] = i + 1;
            }
            r += e[i];
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            // [top..n - 1] is what we want
            r += n - stack.pop();
        }
        return r - n;
    }

    public static void main(String[] args) {
        int[] stockPrice = {2, 3, 2};
        int n = stockPrice.length;
        System.out.println(countMaximumProfitableGroups(stockPrice, n));
    }
}
