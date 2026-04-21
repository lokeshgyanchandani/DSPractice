package com.ds.companies.uber;

import java.util.HashMap;
import java.util.Map;

public class IsSubmatrixFull {

	static boolean[] isSubmatrixFull(int[][] numbers) {
		int cols = numbers[0].length;
		boolean[] result = new boolean[cols - 2];

		Map<Integer, Boolean> map = new HashMap<>();
		for (int col = 0; col < cols - 2; col++) {
			// set true for elements in the window
			for (int row = 0; row < 3; row++) {
				map.put(numbers[row][col], true);
				map.put(numbers[row][col+1], true);
				map.put(numbers[row][col+2], true);
			}
			result[col] = isEverythingTrue(map);
			// set false for prev column after window moved
			for (int row = 0; row < 3; row++) {
				map.put(numbers[row][col], false);
			}
		}

		return result;
	}

	static boolean isEverythingTrue(Map<Integer, Boolean> map) {
		for (int i = 1; i <= 9; i++) {
			if (!map.containsKey(i) || !map.get(i))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] numbers = new int[][] {
			{1, 2, 3, 2, 5, 7},
			{4, 5, 6, 1, 7, 6},
			{7, 8, 9, 4, 8, 3}
		};
		boolean[] results = isSubmatrixFull(numbers);
		for (int i =0; i < results.length; i++) {
			System.out.println(results[i]);
		}
	}
}
