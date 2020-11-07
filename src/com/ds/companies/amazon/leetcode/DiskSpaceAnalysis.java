package com.ds.companies.amazon.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class DiskSpaceAnalysis {

	static int analyse(int numComputer, int[] hardDisks, int length) {
		int ans = -1;
		Deque<Integer> q = new ArrayDeque<>();
		for (int right = 0; right < hardDisks.length; right++) {
			while (!q.isEmpty() && q.peekFirst() <= right - length) {
				q.removeFirst();
			}
			int current = hardDisks[right];
			while (q.size() > 0 && current < hardDisks[q.peekLast()]) {
				q.removeLast();
			}
			q.addLast(right);
			if (right >= length - 1) {
				ans = Math.max(ans, hardDisks[q.peekFirst()]);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(analyse(3, new int[]{8, 2, 4}, 2));//2
		System.out.println(analyse(6, new int[]{8, 2, 4, 3, 7, 6}, 2));//6
		System.out.println(analyse(6, new int[]{8, 2, 4, 3, 7, 6}, 3));//3
		System.out.println(analyse(7, new int[]{2, 4, 3, 7, 8, 6, 5}, 4));//5
		System.out.println(analyse(13, new int[]{2, 4, 3, 7, 8, 6, 5, 16, 19, 33, 32, 34, 35}, 5)
		);//19
	}
}
