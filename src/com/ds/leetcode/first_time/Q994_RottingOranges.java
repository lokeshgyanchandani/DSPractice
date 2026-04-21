package com.ds.leetcode.first_time;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q994_RottingOranges {

	/*private int min = Integer.MIN_VALUE;

	private int orangesRotting(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;

		boolean[][] visited = new boolean[rows][cols];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (!visited[i][j] && grid[i][j] == 2) {
					dfs(grid, i, j, visited, 0);
				}
			}
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					return -1;
				}
			}
		}

		return Math.max(min, 0);
	}

	private void dfs(int[][] grid, int row, int col, boolean[][] visited, int time) {
		if (row < 0 ||  row >= grid.length || col < 0 || col >= grid[0].length ||
				visited[row][col])
			return;

		visited[row][col] = true;

		if (grid[row][col] != 0) {
			dfs(grid, row + 1, col, visited, time + 1);
			dfs(grid, row - 1, col, visited, time + 1);
			dfs(grid, row, col + 1, visited, time + 1);
			dfs(grid, row, col - 1, visited, time + 1);
		}

		if (grid[row][col] == 1) {
			grid[row][col] = 2;
			min = Math.max(min, time);
		}
	}*/

	private static final int[] d = {0, 1, 0, -1, 0};

	public int orangesRotting(int[][] grid) {
		if (grid.length == 0) return -1;

		Deque<Integer> queue = new ArrayDeque<>();

		int rows = grid.length;
		int cols = grid[0].length;

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (grid[row][col] == 2)
					queue.offer(row * cols + col);
			}
		}

		int maxMinutes = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();

			while (size > 0) {
				int index = queue.remove();
				int cRow = index / cols;
				int cCol = index % cols;
				for (int k = 0; k < d.length - 1; k++) {
					int nRow = cRow + d[k];
					int nCol = cCol + d[k + 1];

					if (nRow >= 0 && nRow < rows && nCol >= 0 && nCol < cols && grid[nRow][nCol] == 1) {
						grid[nRow][nCol] = 2;
						queue.offer(nRow * cols + nCol);
					}
				}
				size--;
			}

			maxMinutes++;
		}

		return maxMinutes;
	}

	public static void main(String[] args) {
		Q994_RottingOranges obj = new Q994_RottingOranges();
		int[][] grid = new int[][] {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
		System.out.println(obj.orangesRotting(grid));
	}
}
