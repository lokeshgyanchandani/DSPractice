package com.ds.companies.prashant;

public class Test {

	private static int calculateCombinations(int n) {
		int prev = 1;
		int total = 1;
		for (int i = 4; i <= n; i++) {
			total = prev + i - 2;
			prev = total;
		}
		return total;
	}

	private static int solution(int[] A) {
		int result = 0;
		int prevSlope = Integer.MIN_VALUE;
		int window = 1;
		for (int i = 1; i < A.length; i++) {
			int currentSlope = A[i] - A[i-1];
			if (currentSlope == prevSlope || prevSlope == Integer.MIN_VALUE) {
				window++;
			} else {
				if (window >= 3)
					result += calculateCombinations(window);
				i--;
				window = 1;
			}
			prevSlope = currentSlope;
		}
		if (window >= 3)
			result += calculateCombinations(window);
		return result;
	}

	public static void main(String args[]) {
		//System.out.println(solution(new int[] {-1, 1, 3, 3, 3, 2, 3, 2, 1, 0}));
		//System.out.println(solution(new int[] {2, 2, 2, 1, 2, 2, 2, 2, 2, 2}));
		System.out.println(solution(new int[] {1, 2, 4}));
	}
}
