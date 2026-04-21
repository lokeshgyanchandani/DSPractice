package com.ds.leetcode.first_time;

import java.util.Arrays;

public class Q130_SurroundedRegions {

	public void solve(char[][] board) {
		if (board.length == 0 || board[0].length == 0)
			return;

		int rows = board.length;
		int cols = board[0].length;

		for (int i = 0; i < rows; i++) {
			if (board[i][0] == 'O') dfs(board, i, 0);
			if (board[i][cols - 1] == 'O') dfs(board, i, cols - 1);
		}

		for (int j = 0; j < cols; j++) {
			if (board[0][j] == 'O') dfs(board, 0, j);
			if (board[rows - 1][j] == 'O') dfs(board, rows - 1, j);
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 'O')
					board[i][j] = 'X';
				else if (board[i][j] == '*')
					board[i][j] = 'O';
			}
		}
	}

	private void dfs(char[][] board, int x, int y) {
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] == 'X'
				|| board[x][y] == '*')
			return;

		if (board[x][y] == 'O')
			board[x][y] = '*';

		dfs(board, x + 1, y);
		dfs(board, x - 1, y);
		dfs(board, x, y + 1);
		dfs(board, x, y - 1);
	}

	public static void main(String[] args) {
		Q130_SurroundedRegions obj = new Q130_SurroundedRegions();
		char[][] board = new char[][] {
				{'X','X','X','X'},
				{'X','O','O','X'},
				{'X','X','O','X'},
				{'X','O','X','X'}
		};
		obj.solve(board);

		System.out.println(Arrays.deepToString(board));
	}
}
