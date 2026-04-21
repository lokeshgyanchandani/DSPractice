package com.ds.companies.brex;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class SortMatrixDiagonal {

	private static int[][] diagonalSort(int[][] A) {
		int m = A.length, n = A[0].length;
		HashMap<Integer, PriorityQueue<Integer>> d = new HashMap<>();
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				d.putIfAbsent(i + j, new PriorityQueue<>());
				d.get(i + j).add(A[i][j]);
			}
		}
		for (int i = 0; i < m; ++i)
			for (int j = 0; j < n; ++j)
				A[i][j] = d.get(i + j).poll();
		return A;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] {
				{1, 3, 9, 4},
				{9, 5, 7, 7},
				{3, 6, 9, 7},
				{1, 2, 2, 2}
		};
		System.out.println(Arrays.deepToString(diagonalSort(matrix)));
	}
}
