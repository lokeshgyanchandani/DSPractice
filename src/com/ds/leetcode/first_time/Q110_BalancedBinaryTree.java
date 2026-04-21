package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.*;

public class Q110_BalancedBinaryTree {
	private static final int UNBALANCED = -99;

	private static boolean isBalanced(TreeNode root) {
		return root == null || getHeight(root) != UNBALANCED;
	}

	private static int getHeight(TreeNode root) {
		if (root == null)
			return -1;
		int lHeight = getHeight(root.left);
		int rHeight = getHeight(root.right);
		if (lHeight == UNBALANCED || rHeight == UNBALANCED || Math.abs(lHeight - rHeight) > 1)
			return UNBALANCED;
		return Math.max(lHeight, rHeight) + 1;
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		System.out.println(isBalanced(root));
	}
}
