package com.ds.leetcode.first_time;

public class Q378_KthSmallestElementInMatrix {

	static int kthSmallest(int[][] matrix, int k) {
		int currRow = 0, currCol = 0, resX = -1, resY = -1;
		int i = 1, j = 1;

		if (k > matrix[0].length * matrix.length)
			return -1;

		if (k == 1)
			return matrix[0][0];

		while (k-- > 0) {
			if (matrix[currRow][j] <= matrix[i][currCol]) {
				resX = currRow;
				resY = j;
				if (j < matrix[0].length - 1) j++;
				else {
					currRow++;
					j = 0;
				}
			} else {
				resX = i;
				resY = currCol;
				if (i < matrix.length - 1) i++;
				else {
					currCol++;
					i = 0;
				}
			}
		}
		return matrix[resX][resY];
	}

	public static void main(String args[]) {
		int[][] matrix = new int[][]{ {1,  5,  9}, {10, 11, 13}, {12, 13, 15}};
		System.out.println(kthSmallest(matrix, 8));
	}
}
