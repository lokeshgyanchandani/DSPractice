package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.*;

import java.util.Stack;

public class Q101_SymmetricTree {
	static boolean isSymmetric(TreeNode root) {
		if (root == null) return true;
		return isMirror(root.left, root.right);
	}

	static boolean isSymmetricIterative(TreeNode root) {
		if (root == null) return true;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root.left);
		stack.push(root.right);
		while (!stack.empty()) {
			TreeNode n1 = stack.pop(), n2 = stack.pop();
			if (n1 == null && n2 == null) continue;
			if (n1 == null || n2 == null || n1.val != n2.val) return false;
			stack.push(n1.left);
			stack.push(n2.right);
			stack.push(n1.right);
			stack.push(n2.left);
		}
		return true;
	}

	private static boolean isMirror(TreeNode T1, TreeNode T2) {
		if (T1 == null && T2 == null) return true;
		if (T1 != null && T2 != null)
			return T1.val == T2.val && isMirror(T1.left, T2.right) && isMirror(T1.right, T2.left);
		return false;
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.right.right = new TreeNode(3);

		System.out.println(isSymmetric(root));
	}
}
