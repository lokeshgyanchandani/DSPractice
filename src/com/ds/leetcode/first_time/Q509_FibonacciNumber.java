package com.ds.leetcode.first_time;

public class Q509_FibonacciNumber {

	static int fib(int N) {
		int a = 0, b = 1, c;
		while (N-- > 0) {
			c = a + b;
			a = b;
			b = c;
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.println(fib(3));
	}
}
