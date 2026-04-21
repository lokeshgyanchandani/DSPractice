package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.TreeNode;

public class Q104_MaxDepthBinaryTree {

	public int maxDepth(TreeNode root) {
		if (root == null) return 0;

		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);

		return Math.max(leftDepth, rightDepth) + 1;
	}

	public static void main(String[] args) {

	}
}
