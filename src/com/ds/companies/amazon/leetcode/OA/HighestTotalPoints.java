package com.ds.companies.amazon.leetcode.OA;

import java.util.Scanner;

public class HighestTotalPoints {

    public static int countWinners(int[] initialRewards) {
        int n = initialRewards.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int winnerPoints = initialRewards[i] + n;
            int maxOtherPoints = 0;

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    maxOtherPoints = Math.max(maxOtherPoints, initialRewards[j] + (n - 1));
                }
            }

            if (winnerPoints >= maxOtherPoints) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] initialRewards = new int[] {5, 7, 9, 11};

        /*for (int i = 0; i < n; i++) {
            initialRewards[i] = scanner.nextInt();
        }*/

        System.out.println(countWinners(initialRewards));
        //scanner.close();
    }
}
