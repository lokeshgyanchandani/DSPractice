package com.ds.leetcode.first_time;

import java.util.ArrayList;
import java.util.HashMap;

public class Q1302_DeepestLeavesSum {

	/*HashMap<Integer, ArrayList<Integer>> depthMap = new HashMap<>();

	public int deepestLeavesSum(TreeNode root) {
		if (root == null)
			return 0;

		int maxDepth = calculateLeaves(root, 0, 0);
	}

	void calculateLeaves(TreeNode root, int depth, int maxDepth) {
		if (root == null)
			return maxDepth;

		calculateLeaves(root.left, depth, maxDepth);

		if (root.left == null && root.right == null) {
			if (depth > maxDepth)
				maxDepth = depth;
		}

		calculateLeaves(root.right, depth, maxDepth);
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.right.right = new TreeNode(8);
	}*/
}
