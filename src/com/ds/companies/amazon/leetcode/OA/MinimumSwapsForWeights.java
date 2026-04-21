package com.ds.companies.amazon.leetcode.OA;

public class MinimumSwapsForWeights {
    public static int minSwaps(int[] arr) {
        int smallest = Integer.MAX_VALUE, largest = Integer.MIN_VALUE;
        int smallestIdx = 0, largestIdx = 0;
        int N = arr.length;

        for (int i = 0; i < N; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
                smallestIdx = i;
            }
            if (arr[i] >= largest) {
                largest = arr[i];
                largestIdx = i;
            }
        }

        if (smallestIdx > largestIdx) {
            largestIdx += 1;
        }

        return smallestIdx + (N - 1 - largestIdx);
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 2, 4};
        System.out.println(minSwaps(arr)); // Example usage
    }
}
