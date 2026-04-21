package com.ds.companies.uber;

public class BoundedSquareSum {

	static int boundedSquareSum(int[] a, int[] b, int lower, int upper) {
		int count = 0;

		for (int i = 0; i < a.length; i++){
			for (int j = 0; j < b.length; j++) {
				int prodSum =  a[i] * a[i] + b[j] * b[j];
				if (lower <= prodSum && prodSum <= upper)
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] a = new int[] {3, -1, 9};
		int[] b = new int[] {100, 5, -2};
		System.out.println(boundedSquareSum(a, b, 7, 99));
	}
}
