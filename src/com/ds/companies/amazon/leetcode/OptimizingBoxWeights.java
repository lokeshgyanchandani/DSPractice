package com.ds.companies.amazon.leetcode;

import java.util.*;

public class OptimizingBoxWeights {

	static List<Integer> minimalHeaviestSetA(List<Integer> arr) {
		if (arr == null || arr.size() <= 1)
			return arr;

		Collections.sort(arr, Collections.reverseOrder());
		int length = arr.size();

		int currentWeightA = arr.get(0), currentWeightB = arr.get(length - 1);
		int left = 1, right = length - 2;
		List<Integer> results = new ArrayList<>();
		results.add(arr.get(0));

		if (length == 2 && currentWeightA == currentWeightB) {
			return arr;
		}

		while (left < right) {
			while (currentWeightB + arr.get(right) < currentWeightA && left < right) {
				currentWeightB += arr.get(right--);
			}

			if (left < right) {
				currentWeightA += arr.get(left);
				results.add(arr.get(left++));
			}
		}
		if (left == right) {
			if (currentWeightB + arr.get(left) > currentWeightA) {
				results.add(arr.get(left));
			}
		}

		Collections.sort(results);
		return results;
	}

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<>(Arrays.asList(5, 3, 2, 4, 1, 2));
		System.out.println(minimalHeaviestSetA(input));
	}
}
