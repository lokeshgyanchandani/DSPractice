package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.*;

import java.util.Deque;
import java.util.LinkedList;

public class Q654_MaximumBinaryTree {
	static TreeNode constructMaximumBinaryTree(int[] nums) {
		if (nums.length == 0)
			return null;

		return helper(nums, 0, nums.length - 1);
	}

	static TreeNode helper(int[] nums, int start, int end) {
		if (start > end) { return null; }

		int indexMax = start;
		for (int i  = start + 1; i <= end; i++) {
			if (nums[i] > nums[indexMax]) { indexMax = i; }
		}
		TreeNode root = new TreeNode(nums[indexMax]);
		root.left = helper(nums, start, indexMax - 1);
		root.right = helper(nums, indexMax + 1, end);
		return root;
	}

	static TreeNode constructMaximumBinaryTreeOptimized(int[] nums) {
		if (nums.length == 0) { return null; }

		Deque<TreeNode> stack = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			TreeNode curr = new TreeNode(nums[i]);
			while(!stack.isEmpty() && stack.peek().val < nums[i]) {
				curr.left = stack.pop();
			}
			if(!stack.isEmpty()) {
				stack.peek().right = curr;
			}
			stack.push(curr);
		}

		return stack.isEmpty() ? null : stack.removeLast();
	}

	public static void main(String args[]) {
		int[] nums = new int[] {3, 2, 1, 6, 0, 5};
		TreeUtil.printTreeInOrder(constructMaximumBinaryTreeOptimized(nums));
	}
}
