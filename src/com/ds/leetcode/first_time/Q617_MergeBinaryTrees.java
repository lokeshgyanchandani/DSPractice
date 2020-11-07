package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.*;

public class Q617_MergeBinaryTrees {
	static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null)
			return t2;
		else if (t2 == null)
			return t1;
		TreeNode root = new TreeNode(t1.val + t2.val);
		root.left = mergeTrees(t1.left, t2.left);
		root.right = mergeTrees(t1.right, t2.right);
		return root;
	}

	public static void main(String args[]) {
		TreeNode root1 = new TreeNode(1);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(2);
		root1.left.left = new TreeNode(5);

		TreeNode root2 = new TreeNode(2);
		root2.left = new TreeNode(1);
		root2.right = new TreeNode(3);
		root2.left.right = new TreeNode(4);
		root2.right.right = new TreeNode(7);

		TreeUtil.printTreeInOrder(mergeTrees(root1, root2));
	}
}
