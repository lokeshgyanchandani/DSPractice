package com.ds.companies.x_no_company_x;

import java.util.ArrayList;
import java.util.List;

public class audible {

	public static void main(String[] args) {
		String[] arr = { "0", "1", "2", "8", "9" };
		List<String> list = new ArrayList<String>();
		helper(arr, list, 0, "", 2);
		System.out.println(list);
	}

	private static void helper(String[] arr, List<String> list, int index, String string, int size) {
		if (string.length() == size) {
			list.add(string);
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			String temp = string + arr[i];
			helper(arr, list, index+1, temp, size);
		}
	}

}
