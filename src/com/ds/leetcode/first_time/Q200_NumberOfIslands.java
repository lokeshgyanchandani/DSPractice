package com.ds.leetcode.first_time;

public class Q200_NumberOfIslands {

	public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

		int numIslands = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
                    numIslands++;
					sink(grid, i, j);
				}
			}
		}
		return numIslands;
	}

	void sink(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
			return;

		grid[i][j] = '0';   // mark as visited
		sink(grid, i, j + 1);
		sink(grid, i, j - 1);
		sink(grid, i + 1, j);
		sink(grid, i - 1, j);
	}

	public static void main(String[] args) {

	}
}
