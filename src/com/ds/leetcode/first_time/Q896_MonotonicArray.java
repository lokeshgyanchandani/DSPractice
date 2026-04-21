package com.ds.leetcode.first_time;

public class Q896_MonotonicArray {

	static boolean isMonotonic(int[] A) {
		if (A.length <= 1) return true;

		boolean inc = true, dec = true;
		for (int i = 0; i < A.length - 1; i++) {
			if (A[i] < A[i + 1]) dec = false;
			if (A[i] > A[i + 1]) inc = false;
		}
		return inc || dec;
	}

	static boolean isMonotonicSingleVariable(int[] nums) {
		if (nums.length < 2) return true;

		int direction = 0;  // 0 means unknown, 1 means increasing, -1 means decreasing

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i-1]) {  // increasing
				if (direction == 0) direction = 1;
				else if (direction == -1) return false;
			} else if (nums[i] < nums[i-1]) {  // decreasing
				if (direction == 0) direction = -1;
				else if (direction == 1) return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {1, 1, 1};
		System.out.println(isMonotonic(arr));
	}
}
