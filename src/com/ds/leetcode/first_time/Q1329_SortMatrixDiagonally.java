package com.ds.leetcode.first_time;

import java.util.*;

public class Q1329_SortMatrixDiagonally {
	public int[][] diagonalSort(int[][] mat) {
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

		int rows = mat.length;
		int cols = mat[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int diag = i - j;
				map.putIfAbsent(diag, new PriorityQueue<>());
				map.get(diag).add(mat[i][j]);
			}
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				mat[i][j] = map.get(i - j).poll();
			}
		}

		return mat;
	}

	public static void main(String[] args) {
		//int[][] mat = new int[][]{{3,3,1,1}, {2,2,1,2}, {1,1,1,2}};
		int[][] mat = new int[][] {
				{93,49,54,89,100,90,63,28,46,67},
				{24,97,48,73,62,32,44,100,24,79},
				{81,65,45,14,79,86,45,53,68,83},
				{29,83,12,90,39,37,4,91,62,43},
				{87,19,42,54,30,31,92,24,44,43},
				{97,63,90,89,38,73,60,31,20,91},
				{93,36,83,50,27,89,27,47,80,5},
				{8,99,39,62,24,25,50,58,67,20},
				{84,42,21,55,92,48,84,6,79,11}
		};

		Q1329_SortMatrixDiagonally obj = new Q1329_SortMatrixDiagonally();
		System.out.println(Arrays.deepToString(obj.diagonalSort(mat)));
	}
}
