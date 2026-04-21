package com.ds.companies.amazon.leetcode;

import java.util.HashMap;

public class SplitStringIntoPrimeNumbers {

	private static boolean isPrime(int input) {
		if (input == 1 || input == 0) return false;
		for (int i = 2; i <= input / 2; i++)
			if (input % i == 0) return false;
		return true;
	}

	private static int solve2(String num, HashMap<String, Integer> cache) {
		if (num.isEmpty()) return 1;
		if (cache.containsKey(num)) return cache.get(num);
		int sum = 0;
		for (int i = 0; i < num.length(); i++) {
			String prefix = num.substring(0, i), suffix = num.substring(i, num.length());
			if (prefix.isEmpty()) continue;
			Integer val = Integer.parseInt(prefix);
			if (isPrime(val)) {
				sum += solve2(suffix, cache) + 1;
			}
		}
		cache.put(num, sum);
		return cache.get(num);
	}

	public static void main(String[] args) {

	}
}
