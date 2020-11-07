package com.ds.leetcode.first_time;

public class Q70_ClimbingStairs {
	static int climbStairs(int n) {
		if (n <= 0) return 0;
		else if (n == 1) return 1;
		else if (n == 2) return 2;

		int first = 1, second = 2, third = 0;
		for (int curr = 3; curr <= n; curr++) {
			third = first + second;
			first = second;
			second = third;
		}
		return third;
	}

	public static void main(String args[]) {
		System.out.println(climbStairs(5));
	}
}
