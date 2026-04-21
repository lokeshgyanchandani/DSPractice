package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q1110_DeleteNodesAndReturnForest {

	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		List<TreeNode> res = new ArrayList<>();

		Set<Integer> deleteSet = new HashSet<>();
		for (int del: to_delete) deleteSet.add(del);

		if (!deleteSet.contains(root.val)) res.add(root);

		helper(root, res, deleteSet);

		return res;
	}

	private TreeNode helper(TreeNode root, List<TreeNode> res, Set<Integer> deleteSet) {
		if (root == null) {
			return null;
		}

		root.left = helper(root.left, res, deleteSet);
		root.right = helper(root.right, res, deleteSet);

		if (deleteSet.contains(root.val)) {
			if (root.left != null) res.add(root.left);
			if (root.right != null) res.add(root.right);
			return null;
		}
		return root;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		Q1110_DeleteNodesAndReturnForest obj = new Q1110_DeleteNodesAndReturnForest();
		List<TreeNode> res = obj.delNodes(root, new int[]{3, 5});
		System.out.println("end");
	}
}
