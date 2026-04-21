package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.TreeNode;

public class Q111_MinDepthBinaryTree {

	public int minDepth(TreeNode root) {
		if (root == null) return 0;

		int leftDepth = minDepth(root.left);
		int rightDepth = minDepth(root.right);

		return Math.min(leftDepth, rightDepth) + 1;
	}

	public static void main(String[] args) {

	}
}
