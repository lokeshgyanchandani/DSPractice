package com.ds.leetcode.first_time;

import java.util.Arrays;
import java.util.Comparator;

public class Q452_MinimumArrowToBurstBalloons {

	static int findMinArrowShots(int[][] points) {
		if (points.length == 0) { throw new IllegalArgumentException(); }

		Arrays.sort(points, new Q452_IntervalComparator());

		int end = points[0][1];
		int count = 1;

		for (int[] point : points) {
			if (point[0] >= end) {
				end = point[1];
				count++;
			}
		}
		return count;
	}

	public static void main(String args[]) {
		int[][] points = new int[][] {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
		System.out.println(findMinArrowShots(points));
	}
}

class Q452_IntervalComparator implements Comparator<int[]> {

	@Override
	public int compare(int[] a, int[] b) {
		if (a[0] == b[0]) return a[1] - b[1];
		return a[0] - b[0];
	}
}
