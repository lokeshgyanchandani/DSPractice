package com.ds.leetcode.first_time;

import java.util.Stack;

public class Q84_LargestRectangleHistogram {

	private static int largestRectangleAreaStack(int[] heights) {
		int n = heights.length;
		int maxArea = 0;

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i <= n; i++) {
			int h = i == n ? 0 : heights[i];
			while (!stack.isEmpty() && h < heights[stack.peek()]) {
				int curHeight = heights[stack.pop()];
				int prevIndex = stack.isEmpty() ? -1 : stack.peek();
				int area = curHeight * (i - prevIndex - 1);
				maxArea = Math.max(maxArea, area);
			}
			stack.push(i);
		}
		return maxArea;
	}

	public int largestRectangleAreaFasterDP(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
		int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
		lessFromRight[height.length - 1] = height.length;
		lessFromLeft[0] = -1;

		for (int i = 1; i < height.length; i++) {
			int p = i - 1;

			while (p >= 0 && height[p] >= height[i]) {
				p = lessFromLeft[p];
			}
			lessFromLeft[i] = p;
		}

		for (int i = height.length - 2; i >= 0; i--) {
			int p = i + 1;

			while (p < height.length && height[p] >= height[i]) {
				p = lessFromRight[p];
			}
			lessFromRight[i] = p;
		}

		int maxArea = 0;
		for (int i = 0; i < height.length; i++) {
			maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
		}

		return maxArea;
	}

	public static void main(String args[]) {

	}
}
