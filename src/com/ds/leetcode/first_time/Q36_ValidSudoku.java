package com.ds.leetcode.first_time;

import java.util.HashSet;
import java.util.Set;

public class Q36_ValidSudoku {

	boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i ++) {
			Set<Character> rows = new HashSet<>();
			Set<Character> columns = new HashSet<>();
			Set<Character> cubes = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !rows.add(board[i][j])) return false;
				if (board[j][i] != '.' && !columns.add(board[j][i])) return false;
				int cubeRow = 3 * (i / 3) + j / 3;
				int cubeColumn = 3 * (i % 3) + j % 3;
				if (board[cubeRow][cubeColumn] != '.' && !cubes.add(board[cubeRow][cubeColumn]))
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {

	}
}
