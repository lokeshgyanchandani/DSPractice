package com.ds.leetcode.first_time;

import java.util.HashSet;
import java.util.Set;

public class Q694_NumberOfDistinctIslands {

    private static final int[][] DIRS = {
            {1, 0, 'U'},
            {-1, 0, 'D'},
            {0, 1, 'R'},
            {0, -1, 'L'}
    };

	public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<String> distinct = new HashSet<>();

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)
                    continue;

                StringBuilder island = new StringBuilder();
                dfs(grid, m, n, i, j, island);
                distinct.add(island.toString());
            }

        return distinct.size();
	}

    private void dfs(int[][] grid, int m, int n, int i, int j, StringBuilder path) {
        if (i == -1 || i == m || j == -1 || j == n || grid[i][j] == 0)
            return;

        grid[i][j] = 0; // mark visited

        for (int[] dir : DIRS) {
            path.append((char) dir[2]);
            dfs(grid, m, n, i + dir[0], j + dir[1], path);
        }
    }

	public static void main(String[] args) {

	}
}
