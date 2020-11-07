package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.*;

import java.util.LinkedList;
import java.util.Queue;

public class Q1161_MaximumLevelSumBinaryTree {

	static int maxLevelSum(TreeNode root) {
		if (root == null) { return Integer.MIN_VALUE; }

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int maxSum = root.val;
		int maxLevel = 1;

		for (int level = 1; !queue.isEmpty(); level++) {
			int sum = 0;
			for (int i = 0; i < queue.size(); i++) {
				TreeNode curr = queue.poll();
				sum += curr.val;
				if (curr.left != null) { queue.offer(curr.left); }
				if (curr.right != null) { queue.offer(curr.right); }
			}
			if (sum > maxSum) {
				maxSum = sum;
				maxLevel = level;
			}
		}

		return maxLevel;
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(7);
		root.right = new TreeNode(0);
		root.left.left = new TreeNode(7);
		root.left.right = new TreeNode(-8);

		System.out.println(maxLevelSum(root));
	}
}
