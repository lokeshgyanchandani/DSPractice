package com.ds.leetcode.first_time;

public class Q11_ContainerWithMostWater {

	static int maxArea(int[] height) {
		if (height.length < 2) { return 0; }

		int start = 0, end = height.length - 1;
		int size = 0;
		while (start < end) {
			int shorter = Math.min(height[start], height[end]);
			size = Math.max(size, shorter * (end - start));
			if (height[start] < height[end])
				start++;
			else
				end--;
		}
		return size;
	}

	public static void main(String args[]) {
		System.out.println(maxArea(new int[] {1, 1, 9, 1}));
	}
}
