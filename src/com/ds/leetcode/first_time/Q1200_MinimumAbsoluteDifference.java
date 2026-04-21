package com.ds.leetcode.first_time;

import java.util.*;

public class Q1200_MinimumAbsoluteDifference {

	static List<List<Integer>> minimumAbsDifference(int[] arr) {
		if (arr == null || arr.length <= 1) return null;
		Arrays.sort(arr);

		int minDiff = Integer.MAX_VALUE;
		List<List<Integer>> results = new ArrayList<>();

		for (int i = 0; i < arr.length - 1; i++) {
			int currDiff = arr[i + 1] - arr[i];
			if (currDiff < minDiff) {
				results.clear();
				results.add(Arrays.asList(arr[i], arr[i + 1]));
				minDiff = currDiff;
			} else if (currDiff == minDiff)
				results.add(Arrays.asList(arr[i], arr[i + 1]));
		}

		return results;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {3,8,-10,23,19,-4,-14,27};
		System.out.println(minimumAbsDifference(arr));
	}
}
