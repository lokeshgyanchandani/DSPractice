package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.*;

public class Q106_BinaryTreeFromInorderAndPostorder {

	static TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0 || postorder.length == 0) return null;
		if (inorder.length != postorder.length) throw new RuntimeException("Invalid inputs");

		return helper(inorder, postorder, 0, inorder.length - 1);
	}

	static TreeNode helper(int[] inorder, int[] postorder, int inorderStart, int inorderEnd) {
		if (inorderStart > inorderEnd)
			return null;
		int mid = -1;
		outer: for (int postorderIndex = postorder.length - 1; postorderIndex >= 0; postorderIndex--) {
			for (int index = inorderStart; index <= inorderEnd; index++) {
				if (inorder[index] == postorder[postorderIndex]) {
					mid = index;
					break outer;
				}
			}
		}
		TreeNode root = new TreeNode(inorder[mid]);
		root.left = helper(inorder, postorder, inorderStart, mid - 1);
		root.right = helper(inorder, postorder, mid + 1, inorderEnd);
		return root;
	}

	public static void main(String args[]) {
		int[] inorder = new int[] {9,3,15,20,7};
		int[] postorder = new int[] {9,15,7,20,3};

		TreeUtil.printTreeInOrder(buildTree(inorder, postorder));
	}
}
