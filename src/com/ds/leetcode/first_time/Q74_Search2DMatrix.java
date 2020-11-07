package com.ds.leetcode.first_time;

public class Q74_Search2DMatrix {

	static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) return false;
		int cI = 0, cJ = matrix[0].length - 1;
		while (cI < matrix.length && cJ >= 0) {
			if (matrix[cI][cJ] == target)
				return true;
			else if (matrix[cI][cJ] < target)
				cI++;
			else
				cJ--;
		}
		return false;
	}

	static boolean searchMatrixFaster(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		int start = 0, rows = matrix.length, cols = matrix[0].length;
		int end = rows * cols - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (matrix[mid / cols][mid % cols] == target) {
				return true;
			}
			if (matrix[mid / cols][mid % cols] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return false;
	}

	public static void main(String args[]) {
		int[][] matrix = {
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}
		};
		System.out.println(searchMatrix(matrix, 13));
	}
}
