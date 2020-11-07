package com.ds.companies.microsoft.leetcode;

public class NetworkRank {
	public static int solution(int[] A, int[] B, int N) {
		if (A.length != B.length)
			return 0;

		int[] numEdges = new int[N + 1];

		for (int i = 0; i < A.length; i++) {
			numEdges[A[i]] += 1;
			numEdges[B[i]] += 1;
		}
		int max = 0;

		for(int i = 0; i < A.length; i++){
			max = Math.max(max, numEdges[A[i]] + numEdges[B[i]] - 1);
		}

		return max;
	}

	public static void main(String[] args) {
		int[] A = {1, 2, 3, 3};
		int[] B = {2, 3, 1, 4};
		int N = 4;

		System.out.println("expected " + 4 + " actual " + solution(A, B, N));
	}
}
