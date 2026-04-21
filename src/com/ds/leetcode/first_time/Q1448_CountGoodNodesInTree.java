package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.TreeNode;

public class Q1448_CountGoodNodesInTree {

	public static int goodNodes(TreeNode root) {
		if (root == null)
			return 0;

		return helper(root.left, root.val) + helper(root.right, root.val) + 1;
	}

	private static int helper(TreeNode root, int pValue) {
		if (root == null)
			return 0;

		int leftGoodNodes = helper(root.left, root.val);
		int rightGoodNodes = helper(root.right, root.val);

		return leftGoodNodes + rightGoodNodes + ((root.val >= pValue) ? 1 : 0);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(9);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);

		System.out.println(goodNodes(root));
	}
}
