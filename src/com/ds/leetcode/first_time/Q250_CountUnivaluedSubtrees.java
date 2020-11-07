package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.*;

class TreeInfo {
	int count;
}

public class Q250_CountUnivaluedSubtrees {

	static int countUnivalSubtrees(TreeNode root) {
		if (root == null)
			return 0;

		TreeInfo info = new TreeInfo();
		helper(root, info);
		return info.count;
	}

	static boolean helper(TreeNode root, TreeInfo info) {
		if (root == null) { return true; }

		boolean isLeftUnivalued = helper(root.left, info);
		boolean isRightUnivalued = helper(root.right, info);

		if (!isLeftUnivalued || !isRightUnivalued) { return false; }
		if (root.left != null && root.val != root.left.val) { return false; }
		if (root.right != null && root.val != root.right.val) { return false; }
		info.count++;
		return true;
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(5);

		System.out.println(countUnivalSubtrees(root));
	}
}
