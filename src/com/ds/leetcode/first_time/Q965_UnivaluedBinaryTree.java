package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.*;

public class Q965_UnivaluedBinaryTree {

	static boolean isUnivalTree(TreeNode root) {
		if (root == null)
			return true;

		if (root.left != null && root.left.val != root.val) { return false; }
		if (root.right != null && root.right.val != root.val) { return false; }
		return isUnivalTree(root.left) && isUnivalTree(root.right);
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(1);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(1);
		root.right.right = new TreeNode(1);

		System.out.println(isUnivalTree(root));
	}
}
