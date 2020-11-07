package com.ds.companies.amazon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class UniqueDeviceNames {

	public static void uniqueDevices(String[] devices) {
		String arr[] = {"switch", "tv", "switch", "tv", "switch", "tv"};
		Map<String, Integer> hm = new HashMap<>();
		String ans[] = new String[arr.length];

		for (int i = 0; i < arr.length; i++) {
			String wd = arr[i];
			if (hm.containsKey(wd)) {
				int val = hm.get(wd);
				ans[i] = wd + val;
				hm.replace(wd, val + 1);
			} else {
				hm.put(wd, 1);
				ans[i] = wd;
			}
		}

		for (String str : ans)
			System.out.println(str);
	}

	public static void main(String[] args) {

	}
}
