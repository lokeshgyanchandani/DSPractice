package com.ds.leetcode.first_time;

public class Q695_MaxAreaOfIsland {

    public static int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        boolean[][] visited = new boolean[rows][columns];
        int maxSize = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(grid, visited, i, j);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        return maxSize;
    }

    private static int dfs(int[][] grid, boolean[][] visited, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length
                || grid[row][column] != 1 || visited[row][column])
            return 0;

        visited[row][column] = true;
        int size = 1;

        size += dfs(grid, visited, row - 1, column);
        size += dfs(grid, visited, row + 1, column);
        size += dfs(grid, visited, row, column - 1);
        size += dfs(grid, visited, row, column + 1);

        return size;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        System.out.println(maxAreaOfIsland(grid));
    }
}
