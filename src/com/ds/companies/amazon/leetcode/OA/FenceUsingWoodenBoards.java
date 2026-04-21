package com.ds.companies.amazon.leetcode.OA;

import java.util.Arrays;
import java.util.Scanner;

public class FenceUsingWoodenBoards {

    // Function to determine the maximum height of the boards we can achieve
    private static int maxHeight(int[] A, int N, int K) {
        // Binary search for the maximum possible height
        int left = 1;  // Minimum possible height
        int right = Arrays.stream(A).max().getAsInt();  // Maximum possible height is the maximum in A

        int maxHeight = 0;

        // Perform binary search on the height
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Count the total number of blocks of height 'mid'
            int blocks = 0;
            for (int height : A) {
                blocks += height / mid;
            }

            // If the number of blocks is enough, we can try for a larger height
            if (blocks >= K) {
                maxHeight = mid;  // Update the maximum possible height
                left = mid + 1;   // Try for a larger height
            } else {
                right = mid - 1;  // Try for a smaller height
            }
        }

        return maxHeight;  // Return the result
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input values
        int N = sc.nextInt();  // Number of boards
        int K = sc.nextInt();  // Number of required blocks

        int[] A = new int[N];  // Heights of the boards

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        // We need to find the maximum height possible for the K blocks
        int result = maxHeight(A, N, K);

        // Output the result
        System.out.println(result);
    }
}
