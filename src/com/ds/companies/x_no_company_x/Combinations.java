package com.ds.companies.x_no_company_x;

import java.util.ArrayList;

public class Combinations {

	public static void main(String[] args) {
		int[] arr = { 1,2,3 };
		findCombinations(arr, new ArrayList<Integer>(), 0, 3);
//
//		int[] r = plusOne(arr);
//		for (int f : r)
//			System.err.println(f);
	}

	private static void findCombinations(int[] arr, ArrayList<Integer> temp, int index, int size) {
		//if (temp.size() == size) {
		System.out.println(temp);
		//}
		for (int i = index; i < arr.length; i++) {
			if (temp.contains(arr[i]))
				continue;
			temp.add(arr[i]);
			findCombinations(arr, temp, i+1, 3);
			temp.remove(temp.size() - 1);
		}
	}

	public static int[] plusOne(int[] digits) {
		int carry = 1;
		int k = digits.length - 1;
		int len = k;
		while (len >= 0) {
			int sum = digits[len] + carry;
			if (sum >= 10)
				carry = 1;
			else
				carry = 0;
			digits[len]= sum%10;
			len--;
		}
		if (len < 0 && carry > 0) {
			int a[] = new int[k + 2];
			a[0] = carry;
			System.out.println(k);
			for (int i = 0; i <= k; i++) {
				int x = digits[i];
				a[i + 1] = x;
			}
			return a;
		}
		return digits;
	}
}
