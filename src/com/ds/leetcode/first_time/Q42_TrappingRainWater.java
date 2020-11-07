package com.ds.leetcode.first_time;

public class Q42_TrappingRainWater {

	static int trap(int[] height) {
		if (height.length < 3) return 0;
		int leftMax = height[0];
		int rightMax = height[height.length - 1];
		int water = 0, left = 1, right = height.length - 2;

		while (left <= right) {
			leftMax = Math.max(leftMax, height[left]);
			rightMax = Math.max(rightMax, height[right]);

			if (leftMax < rightMax) {
				water += leftMax - height[left++];
			} else {
				water += rightMax - height[right--];
			}
		}

		return water;
	}

	public static void main(String args[]) {
		System.out.println(trap(new int[] {2, 1, 3}));
	}
}
