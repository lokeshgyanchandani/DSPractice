package com.ds.leetcode.first_time;

public class Q529_Minesweeper {

    public char[][] updateBoard1(char[][] board, int[] click) {
        // once a mine is revealed, we can terminate immediately
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        }

        reveal(board, click[0], click[1]);
        return board;
    }

    private void reveal(char[][] board, int i, int j) {
        // edge cases
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != 'E')
            return;

        board[i][j] = '0';
        int[][] neighbors = {{i-1, j-1}, {i-1, j}, {i-1, j+1},
                {i, j-1}, {i, j+1},
                {i+1, j-1}, {i+1, j}, {i+1, j+1}};
        // check all neighbors for number of mines
        for (int[] neighbor : neighbors) {
            if (neighbor[0] < 0 || neighbor[1] < 0 || neighbor[0] >= board.length || neighbor[1] >= board[0].length)
                continue;
            if (board[neighbor[0]][neighbor[1]] == 'M')
                board[i][j] ++;
        }

        if (board[i][j] != '0')
            return;

        // all neighbors are empty, recursively reveal them
        board[i][j] = 'B';
        for (int[] neighbor : neighbors)
            reveal(board, neighbor[0], neighbor[1]);
    }

    int[][] dirs = new int[][] {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1},
            {1, 1},
            {-1, -1},
            {1, -1},
            {-1, 1}
    };

    public char[][] updateBoard2(char[][] board, int[] click) {
        int i = click[0], j = click[1];

        if (board[i][j] == 'M') {
            board[i][j] = 'X';
            return board;
        }

        helper(board, i, j);

        return board;
    }

    private void helper(char[][] board, int i, int j) {
        int count = 0;

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) continue;

            if (board[x][y] == 'M') count++;
        }

        board[i][j] = (count > 0) ? (char)(count + '0') : 'B';

        if (board[i][j] == 'B') {
            for(int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];

                if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') continue;

                helper(board, x, y);
            }
        }
    }
}
