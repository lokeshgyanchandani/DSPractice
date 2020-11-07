package com.ds.leetcode.first_time;

public class Q845_LongestMountain {

	static int longestMountain(int[] A) {
		if (A == null || A.length < 3) { return 0; }

		int max = 0;
		int i = 1;

		while (i < A.length) {
			while (i < A.length && A[i - 1] == A[i])
				i++;

			int up = 0;
			while (i < A.length && A[i] > A[i - 1]) {
				up++;
				i++;
			}

			int down = 0;
			while (i < A.length && A[i] < A[i - 1]) {
				down++;
				i++;
			}

			if (up > 0 && down > 0)
				max = Math.max(max, up + down + 1);
		}

		return max;
	}

	public static void main(String args[]) {
		System.out.println(longestMountain(new int[] {2, 2, 2}));
	}
}
