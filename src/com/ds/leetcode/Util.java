package com.ds.leetcode;

public class Util {
	public static class ListNode {
		public int val;
		public ListNode next;
		public ListNode(int val) {  this.val = val; }
	}

	public static class TreeNode {
		public int val;
		public TreeNode left, right;
		public TreeNode(int val) { this.val = val; }
	}

	public static class TreeUtil {
		public static void printTreeInOrder(TreeNode root) {
			if (root == null)
				return;
			printTreeInOrder(root.left);
			System.out.print(root.val + " -> ");
			printTreeInOrder(root.right);
		}
	}
}
