package com.ds.leetcode.first_time;

import java.util.ArrayList;
import java.util.List;

public class Q658_FindKClosestElements {

    // Approach:
    // Using binary search and a sliding window, find the midpoint where,
    // the integers between midpoint and midpoint + k is the k closest integers to x.
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // The sliding window is between 'mid' and 'mid' + k.
        int left = 0, right = arr.length - k;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // With midpoint on the left, we use x - arr[midpoint], while arr[midpoint + k] - x because it is on the right.
            // This is important!
            // Rather than using Math.abs(), we need the direction keep the x within the sliding window.
            // If the window is too far left, we shift the window to the right.
            if (x - arr[mid] > arr[mid + k] - x)
                left = mid + 1;
            else {
                // If the window is too far right, we shift the window to the left.
                right = mid;
            }
        }

        // Input all the k closest integers into the result
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++)
            res.add(arr[i]);
        return res;
    }

    public static void main(String[] args) {

    }
}
