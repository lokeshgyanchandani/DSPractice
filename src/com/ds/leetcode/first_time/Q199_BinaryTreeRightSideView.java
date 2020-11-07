package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199_BinaryTreeRightSideView {

	static List<Integer> rightSideViewDFS(TreeNode root) {
		if (root == null) return null;

		List<Integer> result = new ArrayList<>();
		helper(root, 0, result);
		return result;
	}

	static void helper(TreeNode root, int height, List<Integer> result) {
		if (root == null)
			return;
		if (result.size() == height)
			result.add(height, root.val);
		helper(root.right, height + 1, result);
		helper(root.left, height + 1, result);
	}

	static List<Integer> rightSideViewBFS(TreeNode root) {
		if (root == null) return null;

		List<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			int size = queue.size();

			TreeNode current = null;
			while (size-- > 0) {
				current = queue.poll();
				if (current.left != null)
					queue.offer(current.left);
				if (current.right != null)
					queue.offer(current.right);
			}
			result.add(current.val);
		}

		return result;
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		root.right.left.left = new TreeNode(20);
		root.right.left.right = new TreeNode(18);
		root.right.right.left = new TreeNode(10);
		root.right.right.right = new TreeNode(12);

		System.out.println(rightSideViewBFS(root));
	}
}
