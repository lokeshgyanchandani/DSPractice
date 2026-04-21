package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.*;

public class Q938_RangeSumOfBST {
	static int rangeSumBST(TreeNode root, int L, int R) {
		if (root == null)
			return 0;
		int childSum = rangeSumBST(root.left, L, R) + rangeSumBST(root.right, L , R);
		if (root.val >= L && root.val <= R)
			return root.val + childSum;
		else
			return childSum;
	}

	static int rangeSumBSTOptimized(TreeNode root, int L, int R) {
		if (root == null) return 0;
		if (root.val < L) return rangeSumBSTOptimized(root.right, L, R);
		if (root.val > R) return rangeSumBSTOptimized(root.left, L, R);
		return root.val + rangeSumBSTOptimized(root.left, L, R) + rangeSumBSTOptimized(root.right, L ,R);
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.right.right = new TreeNode(18);

		System.out.println(rangeSumBSTOptimized(root, 7, 15));
	}
}
