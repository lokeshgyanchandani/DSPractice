package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q102_BinaryTreeLevelOrder {

	static List<List<Integer>> levelOrderBFS(TreeNode root) {
		if (root == null) return null;

		List<List<Integer>> result = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> intermediate = new ArrayList<>();
			while (size > 0) {
				TreeNode current = queue.poll();
				intermediate.add(current.val);
				if (current.left != null)
					queue.offer(current.left);
				if (current.right != null)
					queue.offer(current.right);
				size--;
			}
			result.add(intermediate);
		}

		return result;
	}

	static List<List<Integer>> levelOrderDFS(TreeNode root) {
		if (root == null) return null;

		List<List<Integer>> result = new ArrayList<>();
		helper(root, result, 0);
		return result;
	}

	private static void helper(TreeNode root, List<List<Integer>> result, int height) {
		if (root == null) return;
		if (height >= result.size())
			result.add(new ArrayList<>());
		result.get(height).add(root.val);
		helper(root.left, result, height + 1);
		helper(root.right, result, height + 1);
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		for (List<Integer> row : levelOrderDFS(root))
			System.out.println(row);
	}
}
