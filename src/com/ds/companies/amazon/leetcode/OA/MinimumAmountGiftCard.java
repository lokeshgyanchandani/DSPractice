package com.ds.companies.amazon.leetcode.OA;

import java.util.HashMap;

public class MinimumAmountGiftCard {

    public static int findMinimumAmount(int[] price) {
        int n = price.length;
        int minCost = Integer.MAX_VALUE;

        // HashMap to store the last occurrence of each price
        HashMap<Integer, Integer> lastOccurrence = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (lastOccurrence.containsKey(price[i])) {
                // If the current price was seen before, calculate the subsegment cost
                int previousIndex = lastOccurrence.get(price[i]);
                int cost = 0;

                // Sum the prices for the subsegment
                for (int j = previousIndex; j <= i; j++) {
                    cost += price[j];
                }

                // Update the minimum cost
                minCost = Math.min(minCost, cost);
            }

            // Update the last occurrence of the current price
            lastOccurrence.put(price[i], i);
        }

        return minCost == Integer.MAX_VALUE ? -1 : minCost;
    }

    public static void main(String[] args) {
        int[] price1 = {1, 2, 3, 1, 2, 1};
        System.out.println(findMinimumAmount(price1)); // Output: 4

        int[] price2 = {1, 2, 1, 2};
        System.out.println(findMinimumAmount(price2)); // Output: 4

        int[] price3 = {1, 100, 1, 7, 7};
        System.out.println(findMinimumAmount(price3)); // Output: 14
    }
}
