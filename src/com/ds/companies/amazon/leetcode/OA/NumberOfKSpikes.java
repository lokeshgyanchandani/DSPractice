package com.ds.companies.amazon.leetcode.OA;

import java.util.TreeSet;

public class NumberOfKSpikes {

    /**
     * Time complexity: O(N^2)
     * Auxiliary space: O(1)
     *
     */
    public static int countKSpikes(int[] prices, int k) {
        int n = prices.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int leftCount = 0, rightCount = 0;

            // Count elements less than prices[i] on the left
            for (int j = 0; j < i; j++) {
                if (prices[j] < prices[i]) {
                    leftCount++;
                }
            }

            // Count elements less than prices[i] on the right
            for (int j = i + 1; j < n; j++) {
                if (prices[j] < prices[i]) {
                    rightCount++;
                }
            }

            // Check if both conditions satisfy
            if (leftCount >= k && rightCount >= k) {
                count++;
            }
        }

        return count;
    }

    /**
     * Time Complexity: O(N * logN)
     * Auxiliary space: O(N), where N is the size of the array.
     *
     */
    public static int countKSpikesEfficient(int[] prices, int k) {
        int n = prices.length;

        // Declare ordered sets
        TreeSet<Integer> st1 = new TreeSet<>();
        TreeSet<Integer> st2 = new TreeSet<>();

        // Initialize a variable for storing our number of
        // K-spikes
        int countOfKSpikes = 0;

        // Declaring prefix and suffix arrays where
        // prefix[i] denotes the number of elements
        // that are smaller than price[i] in
        // [0......i-1] and suffix[i] denotes the
        // number of elements that are smaller than
        // price[i] in [i+1 ...... N).
        int[] prefix = new int[n + 1];
        int[] suffix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            // Calculate the number of elements that
            // are smaller than price[i] using
            // lower() function
            prefix[i] = st1.headSet(prices[i]).size();

            // Insert current price[i] to contribute in
            // the next iteration
            st1.add(prices[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            // Calculate the number of elements that
            // are smaller than price[i] using
            // lower() function
            suffix[i] = st2.headSet(prices[i]).size();

            // Insert current price[i] to contribute
            // in the next iteration
            st2.add(prices[i]);
        }

        for (int i = 0; i < n; i++) {
            // If prefix and suffix are at least K, then
            // the current element is a K-spike
            if (prefix[i] >= k && suffix[i] >= k) {
                countOfKSpikes++;
            }
        }

        return countOfKSpikes;
    }

    public static void main(String[] args) {
        int[] prices1 = {1, 3, 2, 5, 4};
        int k1 = 2;
        System.out.println(countKSpikesEfficient(prices1, k1)); // Output: 2

        int[] prices2 = {1, 2, 8, 3, 7, 5, 4};
        int k2 = 2;
        System.out.println(countKSpikes(prices2, k2)); // Output: 2

        int[] prices3 = {1, 2, 8, 3, 7, 4, 6, 5};
        int k3 = 3;
        System.out.println(countKSpikes(prices3, k3)); // Output: 1
    }
}
