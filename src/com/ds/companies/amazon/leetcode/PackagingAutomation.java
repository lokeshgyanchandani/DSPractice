package com.ds.companies.amazon.leetcode;

import java.util.Arrays;

public class PackagingAutomation {

	static int maxItems(int numGroups, int[] arr) {
		if(arr.length == 0)
			return 0;
		if(arr.length == 1)
			return 1;
		if(arr.length == 2)
			return 1+ Math.min(arr[0], arr[1]);
		Arrays.sort(arr);
		arr[0] = 1;
		for (int i = 2; i < arr.length; i++) {
			if(arr[i] - arr[i-1] > 1)
				arr[i] = arr[i-1] + 1;

		}
		return arr[arr.length -1];

	}
}
