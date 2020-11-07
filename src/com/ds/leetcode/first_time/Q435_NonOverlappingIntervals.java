package com.ds.leetcode.first_time;

import java.util.Arrays;
import java.util.Comparator;

public class Q435_NonOverlappingIntervals {

	static int eraseOverlapIntervals(int[][] intervals) {
		if (intervals.length == 0) { throw new IllegalArgumentException(); }

		Arrays.sort(intervals, new Q435_IntervalComparator());

		int end = intervals[0][1];
		int count = 1;

		for (int[] interval : intervals) {
			if (interval[0] >= end) {
				end = interval[1];
				count++;
			}
		}

		return intervals.length - count;
	}

	public static void main(String args[]) {
		int[][] intervals = new int[][] {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
		System.out.println(eraseOverlapIntervals(intervals));
	}
}

class Q435_IntervalComparator implements Comparator<int[]> {

	@Override
	public int compare(int[] a, int[] b) {
		if (a[0] == b[0]) return a[1] - b[1];
		return a[0] - b[0];
	}
}
