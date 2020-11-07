package com.ds.leetcode.first_time;

import java.util.Stack;

public class Q503_NextGreaterElementII {

	private static int[] nextGreaterElements(int[] nums) {
		if (nums == null || nums.length == 0)
			return new int[]{};

		int length = nums.length;
		int[] res = new int[length];
		Stack<Integer> stack = new Stack<>();

		for (int index = length * 2 - 1; index >= 0; index--) {
			while (!stack.isEmpty() && nums[index % length] >= stack.peek())
				stack.pop();
			res[index % length] = stack.isEmpty() ? -1 : stack.peek();
			stack.push(nums[index % length]);
		}

		return res;
	}

	private static int[] nextGreaterElementsFaster(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];

		Stack<Integer> stack = new Stack<>();
		for (int i = n - 1; i >= 0; i--) {
			stack.push(i);
		}

		for (int i = n - 1; i >= 0; i--) {
			result[i] = -1;
			while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
				stack.pop();
			}
			if (!stack.isEmpty()){
				result[i] = nums[stack.peek()];
			}
			stack.add(i);
		}

		return result;
	}

	public static void main(String args[]) {

	}
}
