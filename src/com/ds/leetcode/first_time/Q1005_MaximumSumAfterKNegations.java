package com.ds.leetcode.first_time;

import java.util.PriorityQueue;

public class Q1005_MaximumSumAfterKNegations {

	// There is an optimized version, check that too
	static int largestSumAfterKNegations(int[] A, int K) {
		if (A == null || A.length == 0) { return -1; }

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int x: A) {
			pq.add(x);
		}
		while( K--  > 0) {
			pq.add(-pq.poll());
		}

		int sum  = 0;
		for(int num : A){
			sum += pq.poll();
		}
		return sum;
	}

	public static void main(String args[]) {
		System.out.println(largestSumAfterKNegations(new int[] {3,-1,0,2}, 3));
	}
}
