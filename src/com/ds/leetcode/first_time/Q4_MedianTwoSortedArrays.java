package com.ds.leetcode.first_time;

import java.util.Arrays;

public class Q4_MedianTwoSortedArrays {

	private static long replaceArray(int[] digits, int valToReplace, int newDigit) {
		int[] max = Arrays.stream(digits).map(k -> k == valToReplace ? newDigit : k).toArray();
		StringBuilder s = new StringBuilder();
		for (int k : max) s.append(k);
		return Long.parseLong(s.toString());
	}

	private static long getMax(int num) {
		String temp = Integer.toString(num);

		int[] digits = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++)
			digits[i] = temp.charAt(i) - '0';

		int len = digits.length;

		long maxVal = num;
		int i = 0;
		while (i < len && digits[i] == 9) i++;
		if (i < len) maxVal = replaceArray(digits, digits[i], 9);

		long minVal = num;
		if (digits[0] >= 2) {
			minVal = replaceArray(digits, digits[0], 1);
		} else {
			i = 1;
			while (i < len && (digits[i] == digits[0] || digits[i] == 0)) i++;
			if (i < len) minVal = replaceArray(digits, digits[i], 0);
		}

		return maxVal - minVal;
	}

	public static void main(String[] args) {
		System.out.println(getMax(10018));
	}
}
