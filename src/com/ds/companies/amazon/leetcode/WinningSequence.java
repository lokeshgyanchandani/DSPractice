package com.ds.companies.amazon.leetcode;

import java.util.Arrays;

public class WinningSequence {

	public static void printArr(int hi, int lo, int num) {
		if (num > (hi - lo) * 2 + 1) {
			return;
		}
		int index = getIndex(lo, hi, num); // find the index of upperBound
		int arr[] = new int[num];
		int temp = hi;
		for (int i = index; i < num; i++) {  // print decresing
			arr[i] = temp--;
		}
		temp = hi - 1;
		for (int i = index - 1; i >= 0; i--) { //  print increasing
			arr[i] = temp--;
		}
		System.out.println(Arrays.toString(arr));
	}

	public static int getIndex(int lo, int hi, int num) {
		if (num <= hi - lo + 2) {
			return 1;
		} else {
			return num - (hi - lo + 1);
		}
	}
}
