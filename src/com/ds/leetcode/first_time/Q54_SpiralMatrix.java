package com.ds.leetcode.first_time;

import java.util.ArrayList;
import java.util.List;

public class Q54_SpiralMatrix {

	static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> results = new ArrayList<>();
		if (matrix == null || matrix.length == 0) return results;

		int startRow = 0, endRow = matrix.length - 1;
		int startColumn = 0, endColumn = matrix[0].length - 1;
		int dir = 0;

		while (startRow <= endRow && startColumn <= endColumn) {
			switch (dir) {
				// RIGHT
				case 0: {
					for (int col = startColumn; col <= endColumn; col++)
						results.add(matrix[startRow][col]);
					startRow++;
					break;
				}
				// DOWN
				case 1: {
					for (int row = startRow; row <= endRow; row++)
						results.add(matrix[row][endColumn]);
					endColumn--;
					break;
				}
				// LEFT
				case 2: {
					for (int col = endColumn; col >= startColumn; col--)
						results.add(matrix[endRow][col]);
					endRow--;
					break;
				}
				// UP
				case 3: {
					for (int row = endRow; row >= startRow; row--)
						results.add(matrix[row][startColumn]);
					startColumn++;
					break;
				}
			}
			dir = (dir + 1) % 4;
		}

		return results;
	}

	public static void main(String[] args) {

	}
}
