package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.*;

public class Q108_SortedArrayToBST {
	private static TreeNode sortedArrayToBSTHelper(int[] nums, int start, int end) {
		if (start > end)
			return null;
		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBSTHelper(nums, start, mid - 1);
		root.right = sortedArrayToBSTHelper(nums, mid + 1, end);
		return root;
	}

	private static TreeNode sortedArrayToBST(int[] nums) {
		if (nums.length == 0)
			return null;
		return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
	}

	public static void main(String args[]) {
		TreeUtil.printTreeInOrder(sortedArrayToBST(new int[] {-10,-3,0,5,9}));
	}
}
