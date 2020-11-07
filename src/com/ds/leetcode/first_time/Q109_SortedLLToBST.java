package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.*;

public class Q109_SortedLLToBST {

	private static ListNode node;

	static TreeNode sortedListToBST(ListNode head) {
		if (head == null) { return null; }
		return helper(head,null);
	}

	static TreeNode helper(ListNode head, ListNode tail) {
		ListNode slow = head;
		ListNode fast = head;
		if (head == tail) return null;

		while (fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode root = new TreeNode(slow.val);
		root.left = helper(head,slow);
		root.right = helper(slow.next,tail);
		return root;
	}

	static TreeNode sortedListToBSTOptimized(ListNode head) {
		if (head == null) { return null; }

		int size = 0;
		ListNode runner = head;
		node = head;

		while (runner != null) {
			runner = runner.next;
			size++;
		}

		return helperOptimized(0, size - 1);
	}

	static TreeNode helperOptimized(int start, int end) {
		if (start > end)
			return null;

		int mid = start + (end - start)/2;

		TreeNode left = helperOptimized(start, mid - 1);

		TreeNode root = new TreeNode(node.val);
		root.left = left;
		node = node.next;

		root.right = helperOptimized(mid + 1, end);

		return root;
	}

	public static void main(String args[]) {
		ListNode head = new ListNode(-10);
		head.next = new ListNode(-3);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(9);

		TreeNode root = sortedListToBSTOptimized(head);
		TreeUtil.printTreeInOrder(root);
	}
}
