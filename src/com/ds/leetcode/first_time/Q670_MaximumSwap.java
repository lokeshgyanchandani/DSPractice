package com.ds.leetcode.first_time;

public class Q670_MaximumSwap {

	public int maximumSwap(int num) {
		char[] digits = Integer.toString(num).toCharArray();

		int[] buckets = new int[10];
		for (int i = 0; i < digits.length; i++) {
			buckets[digits[i] - '0'] = i;
		}

		for (int i = 0; i < digits.length; i++) {
			for (int j = 9; j > digits[i] - '0'; j--) {
				if (buckets[j] > i) {
					char temp = digits[i];
					digits[i] = digits[buckets[j]];
					digits[buckets[j]] = temp;
					return Integer.valueOf(new String(digits));
				}
			}
		}

		return num;
	}

	public static void main(String[] args) {
		Q670_MaximumSwap obj = new Q670_MaximumSwap();
		System.out.println(obj.maximumSwap(2736));
	}
}
