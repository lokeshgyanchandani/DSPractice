package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.*;

public class Q538_BSTToGreaterTree {

	static TreeNode bstToGst(TreeNode root) {
		helper(root, 0);
		return root;
	}

	private static int helper(TreeNode root, int sum) {
		if (root == null) return sum;
		root.val += helper(root.right, sum);
		return helper(root.left, root.val);
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(3);

		root.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);

		TreeUtil.printTreeInOrder(bstToGst(root));
	}
}
