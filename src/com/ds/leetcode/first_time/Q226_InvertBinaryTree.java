package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.*;

import java.util.LinkedList;
import java.util.Queue;

public class Q226_InvertBinaryTree {
	static TreeNode invertTreeDFS(TreeNode root) {
		if (root == null)
			return null;
		TreeNode temp = root.left;
		root.left = invertTreeDFS(root.right);
		root.right = invertTreeDFS(temp);
		return root;
	}

	static TreeNode invertTreeIterative(TreeNode root) {
		if (root == null)
			return null;

		final Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;

			if (node.left != null)
				queue.offer(node.left);
			if (node.right != null)
				queue.offer(node.right);
		}

		return root;
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(7);
		TreeUtil.printTreeInOrder(invertTreeIterative(root));
	}
}
