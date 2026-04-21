package com.ds.string;

import java.util.ArrayList;

public class Nthpermutation {

	public static void main(String[] args) {
		int a = 123;
        String x = String.valueOf(a);
		System.out.println(x);
		Integer a1 = a;
		System.out.println(a1);
		StringBuilder s = new StringBuilder();

		while (a > 0) {
			s.append(a % 10);
			a = a / 10;
		}

		System.out.println(s);

		findPermutation(4, 15);
	}

	private static void findPermutation(int n, int m) {

		if (n == 0)
			return;

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(i);
		}

		for (int i = 1; i <= n; i++) {
			int fact = factorial(n - i);
			System.out.println(fact);
			int index = m / fact;
			// System.out.print(list.get(index) + " ");
			list.remove(index);
			m = m - index * fact;
		}
	}

	public static int factorial(int n) {
		int fact = 1;
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}

}
