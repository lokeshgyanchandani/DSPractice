package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.TreeNode;

public class Q543_DiameterBinaryTree {

	static int max = 0;

	static int diameterOfBinaryTree(TreeNode root) {
		return maxDepth(root);
	}

	static int maxDepth(TreeNode root) {
		if (root == null) return 0;

		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);

		max = Math.max(max, leftDepth + rightDepth);

		return Math.max(leftDepth, rightDepth) + 1;
	}

	public static void main(String[] args) {

	}
}
