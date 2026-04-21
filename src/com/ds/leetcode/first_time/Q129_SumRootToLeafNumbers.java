package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.TreeNode;

public class Q129_SumRootToLeafNumbers {

	static int sumNumbers(TreeNode root) {
		if (root == null) return 0;

		return sum(root, 0);
	}

	static int sum(TreeNode root, int currentSum) {
		if (root == null) return 0;

		if (root.left == null && root.right == null) {
			return currentSum * 10 + root.val;
		}
		return sum(root.left, currentSum * 10 + root.val) + sum(root.right, currentSum + root.val);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(9);
		root.right = new TreeNode(0);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(1);

		System.out.println(sumNumbers(root));
	}
}
