package com.ds.companies.amazon.leetcode;

import java.util.List;

class TreeNode {
	public int val;
	public List<TreeNode> children;
}

public class SubtreeWithMaximumAverage {

	double max = Integer.MIN_VALUE;
	TreeNode maxNode = null;

	public TreeNode maximumAverageSubtree(TreeNode root) {
		if (root == null) return null;
		helper(root);
		return maxNode;
	}

	private double[] helper(TreeNode root) {
		if (root == null) return new double[] {0, 0};

		double curTotal = root.val;
		double count = 1;
		for (TreeNode child : root.children) {
			double[] cur = helper(child);
			curTotal += cur[0];
			count += cur[1];
		}
		double avg = curTotal / count;
		if (count > 1 && avg > max) { //taking "at least 1 child" into account
			max = avg;
			maxNode = root;
		}
		return new double[] {curTotal, count};
	}

	public static void main(String[] args) {

	}
}
