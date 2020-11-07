package com.ds.leetcode.first_time;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q973_KClosestPointsToOrigin {

	static int[][] kClosest(int[][] points, int K) {
		if (K < 1 || points == null) { return new int[][] {}; }
		if (K > points.length) { return points; }

		PriorityQueue<int[]> maxHeap = new PriorityQueue<>(K, (a, b) ->
				(b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
		for (int[] point : points) {
			if (maxHeap.size() == K && point[0] * point[1] < maxHeap.peek()[0] * maxHeap.peek()[1]) {
				maxHeap.poll();
			}
			maxHeap.offer(point);
		}

		int[][] result = new int[K][2];
		while (K-- > 0)
			result[K] = maxHeap.poll();
		return result;
	}

	static int[][] kClosestFaster(int[][] points, int K) {
		if (K < 1 || points == null) { return new int[][]{}; }
		if (K > points.length) { return points; }

		int l = 0, r = points.length - 1;
		while (l <= r) {
			int mid = partition(points, l, r);
			if (mid == K) break;
			else if (mid < K)
				l = mid + 1;
			else
				r = mid - 1;
		}
		return Arrays.copyOfRange(points, 0, K);
	}

	private static int partition(int[][] points, int l, int r) {
		int[] pivot = points[l];
		while (l < r) {
			while (l < r && compare(points[r], pivot) >= 0) r--;
			points[l] = points[r];
			while (l < r && compare(points[l], pivot) <= 0) l++;
			points[r] = points[l];
		}
		points[l] = pivot;
		return l;
	}

	private static int compare(int[] a, int[] b) {
		return a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1];
	}

	public static void main(String args[]) {
		int[][] points = new int[][] {{3, 3}, {5, -1}, {-2, 4}};
		int[][] result = kClosestFaster(points, 4);
		System.out.println(Arrays.deepToString(result));
	}
}
