package com.ds.companies.brex;

public class GoodTuples {

	private static int goodTuples(int[] a) {
		if (a == null || a.length <= 2) return 0;

		int count = 0;

		int first = a[0];
		int second = a[1];
		int third = a[2];

		int i = 2;
		while (i < a.length) {
			if (checkEqual(first, second)) {
				if (!checkEqual(second, third)) count++;
			} else if (checkEqual(first, third) || checkEqual(second, third)) count++;
			first = second;
			second = third;
			if (++i < a.length)
				third = a[i];
		}

		return count;
	}

	private static boolean checkEqual(int a, int b) {
		return a == b;
	}

	public static void main(String args[]) {
		int[] a = new int[] {1, 1, 1, 2, 1, 3, 4};
		System.out.println(goodTuples(a));
	}
}
