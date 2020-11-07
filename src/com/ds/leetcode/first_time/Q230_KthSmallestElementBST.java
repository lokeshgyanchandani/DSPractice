package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.*;

import java.util.Stack;

public class Q230_KthSmallestElementBST {

	static int KthSmallest(TreeNode root, int k) {
		if (root == null) { return Integer.MIN_VALUE; }

		Stack<TreeNode> stack = new Stack<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if (--k == 0) return root.val;
			root = root.right;
		}

		return Integer.MIN_VALUE;
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);

		System.out.println(KthSmallest(root, 4));
	}
}
