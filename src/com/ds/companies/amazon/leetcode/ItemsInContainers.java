package com.ds.companies.amazon.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ItemsInContainers {

	private static List<Integer> numberOfItems(String str, int[] startIndices, int[] endIndices) {

		// 1. Get total number for item.
		// 2. Iterating str in forward and reverse, make tree map. Key of tree map is index.
		// Value of tree map is number item.
		TreeMap<Integer, Integer> forward = new TreeMap<>();
		TreeMap<Integer, Integer> reverse = new TreeMap<>();

		int total;
		int count;
		count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '*') {
				count++;
			} else if (str.charAt(i) == '|') {
				forward.put(i, count);
			}
		}
		total = count;

		count = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == '*') {
				count++;
			} else if (str.charAt(i) == '|') {
				reverse.put(i, count);
			}
		}

		// 3. output = total number - ceiling(forward) - floor(reverse)
		List<Integer> output = new ArrayList<>();
		for (int i = 0; i < startIndices.length; i++) {
			Integer forwardCeilKey = forward.ceilingKey(startIndices[i] - 1);
			Integer reverseFloorKey = reverse.floorKey(endIndices[i] - 1);
			if (forwardCeilKey == null || reverseFloorKey == null) {
				output.add(0);
			} else {
				output.add(total - forward.get(forwardCeilKey) - reverse.get(reverseFloorKey));
			}
		}

		return output;
	}

	public static void main(String[] args) {
		List<Integer> solution = numberOfItems("|**|*|*", new int[]{1, 1}, new int[]{5, 6});
		System.out.println(solution);
	}
}
