package com.ds.companies.amazon.leetcode;

import java.util.HashMap;
import java.util.Map;

public class AmazonMusicPairs {

	public static int solve(int[] time) {
		Map<Integer, Integer> map = new HashMap<>();
		int cntr = 0;
		for (int t : time) {
			cntr += map.getOrDefault((60 - t % 60) % 60, 0);
			map.put(t % 60, map.getOrDefault(t % 60, 0) + 1);
		}
		return cntr;
	}

	public static void main(String[] args) {
		int[] nums1 = { 37, 23, 60 };
		int[] nums2 = { 10, 50, 90, 30 };
		int[] nums3 = { 30, 20, 150, 100, 40 };
		int[] nums4 = { 60, 60, 60 };
		System.out.println(solve(nums1));
		System.out.println(solve(nums2));
		System.out.println(solve(nums3));
		System.out.println(solve(nums4));
	}
}
