package com.ds.leetcode.first_time;

import java.util.Arrays;

public class Q63_UniquePathsII {
    static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[][] dp = new int[rows][cols];

        dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for (int i = 1; i < rows; i++) {
            if (obstacleGrid[i][0] == 0)
                dp[i][0] = dp[i - 1][0];
        }

        for (int j = 1; j < cols; j++) {
            if (obstacleGrid[0][j] == 0)
                dp[0][j] = dp[0][j - 1];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 0)
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[rows - 1][cols - 1];
    }

    static int uniquePathsWithObstacles1D(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;

        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[] arr = new int[cols];

        arr[0] = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    arr[j] = 0;
                } else {
                    if (j > 0) {
                        arr[j] += arr[j - 1];
                    }
                }
            }
        }

        return arr[cols - 1];
    }

	public static void main(String args[]) {
        int[][] obstacleGrid = {{0,0,0}, {0,1,0}, {0,0,0}};
		System.out.println(uniquePathsWithObstacles1D(obstacleGrid));
	}
}
