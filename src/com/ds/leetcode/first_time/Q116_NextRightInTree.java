package com.ds.leetcode.first_time;

public class Q116_NextRightInTree {

	static class TreeNode {
		public int val;
		public TreeNode left, right, next;
		public TreeNode(int val) { this.val = val; }
	}

	static TreeNode connect(TreeNode root) {
		if (root == null) return null;

		TreeNode pre = root;
		while (pre != null && pre.left != null) {
			TreeNode current = pre;
			while (current != null) {
				current.left.next = current.right;
				current.right.next = (current.next != null) ? current.next.left : null;
				current = current.next;
			}
			pre = pre.left;
		}
		return root;
	}

	public static void main(String[] args) {

	}
}
