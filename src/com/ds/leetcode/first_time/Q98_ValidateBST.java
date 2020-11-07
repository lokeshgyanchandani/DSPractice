package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.TreeNode;

import java.util.Stack;

public class Q98_ValidateBST {

	static boolean isValidBST(TreeNode root) {
		if (root == null) { return true; }

		Stack<TreeNode> stack = new Stack<>();
		TreeNode prev = null;

		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (prev != null && prev.val >= root.val) { return false; }
			prev = root;
			root = root.right;
		}

		return true;
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(6);

		System.out.println(isValidBST(root));
	}
}
