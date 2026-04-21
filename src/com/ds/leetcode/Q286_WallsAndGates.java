package com.ds.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Q286_WallsAndGates {

    public static final int[] d = {0, 1, 0, -1, 0};

    public static void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) return;
        int m = rooms.length, n = rooms[0].length;

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                if (rooms[i][j] == 0) {
                    queue.offer(i * n + j); // Put gates in the queue
                }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int i = x / n, j = x % n;
            for (int k = 0; k < 4; ++k) {
                int p = i + d[k], q = j + d[k + 1]; // empty room
                if (0 <= p && p < m && 0 <= q && q < n && rooms[p][q] == Integer.MAX_VALUE) {
                    rooms[p][q] = rooms[i][j] + 1;
                    queue.offer(p * n + q);
                }
            }
        }
    }

    /*public static void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        int cols = rooms[0].length;

        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (rooms[row][col] == 0) {
                    dfs(rooms, row, col, visited, 0);
                    visited = new boolean[rows][cols];
                }
            }
        }
    }*/

    /*private static void dfs(int[][] rooms, int row, int col, boolean[][] visited, int depth) {
        if (row < 0 || row >= rooms.length || col < 0 || col >= rooms[0].length
                || rooms[row][col] == -1 || visited[row][col])
            return;

        visited[row][col] = true;

        dfs(rooms, row - 1, col, visited, depth + 1);
        dfs(rooms, row + 1, col, visited, depth + 1);
        dfs(rooms, row, col - 1, visited, depth + 1);
        dfs(rooms, row, col + 1, visited, depth + 1);

        if (rooms[row][col] == 0) return;

        if (row == 0 && col == 11)
            System.out.println("Test");
        rooms[row][col] = Math.min(rooms[row][col], depth);
    }*/

    public static void main(String[] args) {
        int[][] rooms = {
                {2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}
        };

        /*int[][] rooms = {
                {0,2147483647,-1,2147483647,2147483647,-1,-1,0,0,-1,2147483647,2147483647,0,-1,2147483647,2147483647,2147483647,2147483647,0,2147483647,0,-1,-1,-1,-1,2147483647,-1,-1,2147483647,2147483647,-1,-1,0,0,-1,0,0,0,2147483647,0,2147483647,-1,-1,0,-1,0,0,0,2147483647},
                {2147483647,0,-1,2147483647,0,-1,-1,-1,-1,0,0,2147483647,2147483647,-1,-1,2147483647,-1,-1,2147483647,2147483647,-1,0,-1,2147483647,0,2147483647,-1,2147483647,0,2147483647,0,2147483647,-1,2147483647,0,2147483647,-1,2147483647,0,2147483647,2147483647,0,-1,2147483647,-1,-1,-1,0,2147483647}
        };*/

        wallsAndGates(rooms);
        for (int[] room : rooms) {
            for (int col = 0; col < rooms[0].length; col++) {
                System.out.println(room[col]);
            }
        }
    }
}
