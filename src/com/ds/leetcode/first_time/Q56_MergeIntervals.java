package com.ds.leetcode.first_time;

import java.util.*;

public class Q56_MergeIntervals {

	static int[][] merge(int[][] intervals) {
		if (intervals.length == 0) { throw new IllegalArgumentException(); }

		List<int[]> results = new ArrayList<>();

		Arrays.sort(intervals, new Q56_IntervalComparator());

		int start = intervals[0][0];
		int end = intervals[0][1];

		for (int[] interval : intervals) {
			if (interval[0] <= end) {
				end = Math.max(end, interval[1]);
			} else {
				results.add(new int[]{start, end});
				start = interval[0];
				end = interval[1];
			}
		}

		results.add(new int[]{start, end});

		return results.toArray(new int[results.size()][]);
	}

	public static void main(String args[]) {
		int[][] intervals = new int[][] {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
		System.out.println(Arrays.deepToString(merge(intervals)));
	}
}

class Q56_IntervalComparator implements Comparator<int[]> {

	@Override
	public int compare(int[] a, int[] b) {
		if (a[0] == b[0]) return b[1] - a[1];
		return a[0] - b[0];
	}
}
