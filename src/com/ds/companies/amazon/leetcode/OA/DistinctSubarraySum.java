package com.ds.companies.amazon.leetcode.OA;

import java.util.HashMap;

public class DistinctSubarraySum {

    public static int sumOfDistinctCounts(int[] arr) {
        int n = arr.length;
        int result = 0;

        // Frequency map to store count of elements in the current window
        HashMap<Integer, Integer> freqMap;

        // Left pointer for the sliding window
        //int left = 0;

        for (int left = 0; left < n; left++) {
            // Traverse through each element in the array
            freqMap = new HashMap<>();
            for (int right = 0; left <= right && right < n; right++) {
                // Add the current element to the frequency map
                freqMap.put(arr[right], freqMap.getOrDefault(arr[right], 0) + 1);

                // While there are duplicate elements in the current window, shrink from the left
                while (freqMap.get(arr[right]) > 1) {
                    freqMap.put(arr[left], freqMap.get(arr[left]) - 1);
                    left++;
                }

                // The number of subarrays that end at 'right' and start from any index from 'left' to 'right'
                // Each subarray has distinct elements
                result += (right - left + 1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        System.out.println("Sum of distinct counts in all subarrays: " + sumOfDistinctCounts(arr));
    }
}
