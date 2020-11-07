package com.ds.companies.x_no_company_x;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class MaxDiffArray {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> x = new ArrayList<>();

		while (scan.hasNextInt()) {
			x.add(scan.nextInt());
		}
HashMap<String,String> t  = new HashMap<>();


		int size = x.size();
		int[] arr = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = x.get(i);
		}
		MaxDiffArray maxdif = new MaxDiffArray();
		System.out.println(maxdif.getDifference(arr, size));

//	        Scanner scanner = new Scanner(System.in);
//	        int n = scanner.nextInt();
//	        scanner.nextLine();
//	        List<String> nums = Arrays.asList(scanner.nextLine().split(" "));
	}

	private int getDifference(int[] arr, int size) {
		int min = arr[0];
		int MaxDiff = arr[1] - arr[0];
		for (int i = 1; i < size; i++) {
			if (arr[i] < min)
				min = arr[i];
			else
				MaxDiff = Math.max(MaxDiff, arr[i] - min);
		}
		return MaxDiff;

	}

}
