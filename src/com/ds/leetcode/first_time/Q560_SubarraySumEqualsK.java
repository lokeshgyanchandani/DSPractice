package com.ds.leetcode.first_time;

import java.util.HashMap;
import java.util.Map;

public class Q560_SubarraySumEqualsK {

	private static int subarraySumFirst(int[] nums, int k) {
		if (nums == null || nums.length == 0) return -1;

		Map<Integer, Integer> counter = new HashMap<>();
		counter.put(0, 1);

		int currSum = 0, result = 0;
		for (int num : nums) {
			currSum += num;
			result += counter.getOrDefault(currSum - k, 0);
			counter.put(currSum, counter.getOrDefault(currSum, 0) + 1);
		}

		return result;
	}

	private static int subarraySumSecond(int[] nums, int k) {
		if (nums == null || nums.length == 0) { return 0; }

		int sum = 0, count = 0;
		Map<Integer, Integer> countMap = new HashMap<>();
		countMap.put(0, 1);

		for (int num : nums) {
			sum += num;
			if (countMap.containsKey(sum - k))
				count += countMap.get(sum - k);
			countMap.put(sum, countMap.getOrDefault(sum, 0) + 1);
		}

		return count;
	}

	public static void main(String args[]) {
		System.out.println(subarraySumFirst(new int[] {1, 2, 7, -3, 3}, 7));
	}
}
