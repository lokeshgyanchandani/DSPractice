package com.ds.leetcode.second_time;

public class Q221_MaximalSquare {

	public static int maximalSquare(char[][] matrix) {
		int xLen = matrix.length;
		int yLen = matrix[0].length;

		int[][] dp = new int[xLen][yLen];
		int max = 0;
		for (int i = 0; i < xLen; i++) {
			for (int j = 0; j < yLen; j++) {
				if (matrix[i][j] == '1') {
					if (i == 0 || j == 0) {
						dp[i][j] = 1;
					} else {
						int min = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
						dp[i][j] = min + 1;
					}
					max = Math.max(max, dp[i][j]);
				}
			}
		}

		return max * max;
	}

	public static void main(String[] args) {
		char[][] matrix = new char[][] {
				{'1', '0', '1','0','0'},
				{'1','0','1','1','1'},
				{'1','1','1','1','1'},
				{'1','0','0','1','0'}
		};

		System.out.println(maximalSquare(matrix));
	}
}
