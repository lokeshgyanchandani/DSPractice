package com.ds.companies.amazon.leetcode.OA;

import java.util.Scanner;

public class MinimumSeriesWatchScore {

    public static int findMinWatchScore(int[] watchHistory, int series1, int series2) {
        int n = watchHistory.length;
        int minLength = Integer.MAX_VALUE;
        int lastSeries1 = -1, lastSeries2 = -1;

        for (int i = 0; i < n; i++) {
            if (watchHistory[i] == series1) {
                lastSeries1 = i;
            }
            if (watchHistory[i] == series2) {
                lastSeries2 = i;
            }
            if (lastSeries1 != -1 && lastSeries2 != -1) {
                minLength = Math.min(minLength, Math.abs(lastSeries1 - lastSeries2) + 1);
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array size
        int n = scanner.nextInt();
        int[] watchHistory = new int[n];

        // Input watch history
        for (int i = 0; i < n; i++) {
            watchHistory[i] = scanner.nextInt();
        }

        // Input series1 and series2
        int series1 = scanner.nextInt();
        int series2 = scanner.nextInt();

        scanner.close();

        // Find and print minimum watch score
        System.out.println(findMinWatchScore(watchHistory, series1, series2));
    }
}
