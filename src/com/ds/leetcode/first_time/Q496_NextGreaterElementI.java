package com.ds.leetcode.first_time;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Q496_NextGreaterElementI {

	private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		if (nums1.length > nums2.length)
			return null;

		Map<Integer, Integer> resMap = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		for (int index = nums2.length - 1; index >= 0; index--) {
			while (!stack.isEmpty() && nums2[index] >= stack.peek())
				stack.pop();
			resMap.put(nums2[index], stack.isEmpty() ? - 1 : stack.peek());
			stack.push(nums2[index]);
		}

		int[] res = new int[nums1.length];
		for (int index = 0; index < nums1.length; index++) {
			res[index] = resMap.get(nums1[index]);
		}
		return res;
	}

	public static void main(String args[]) {
		int[] nums1 = new int[] {4, 1, 2};
		int[] nums2 = new int[] {1, 3, 4, 2};
		System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
	}
}
