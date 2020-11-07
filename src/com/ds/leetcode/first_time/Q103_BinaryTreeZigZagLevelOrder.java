package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.*;

import java.util.*;

public class Q103_BinaryTreeZigZagLevelOrder {

	static List<List<Integer>> zigZagLevelOrderBFS1(TreeNode root) {
		if (root == null) return null;

		List<List<Integer>> result = new ArrayList<>();

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int height = 0;

		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> intermediate = new ArrayList<>(size);
			while (size > 0) {
				TreeNode current = queue.poll();
				if (height % 2 != 0)
					intermediate.add(0, current.val);
				else
					intermediate.add(current.val);
				if (current.left != null) {
					queue.offer(current.left);
				if (current.right != null)
					queue.offer(current.right);
				}
				size--;
			}
			result.add(intermediate);
			height++;
		}
		return result;
	}

	static List<List<Integer>> zigZagLevelOrderBFS2(TreeNode root) {
		if (root == null) return null;

		List<List<Integer>> result = new ArrayList<>();

		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root);
		while(!s1.isEmpty()||!s2.isEmpty())
		{
			List<Integer> intermediate = new ArrayList<>();
			while(!s1.isEmpty())
			{
				TreeNode current = s1.pop();
				intermediate.add(current.val);
				if(current.left!=null) s2.push(current.left);
				if(current.right!=null) s2.push(current.right);
			}
			result.add(intermediate);
			intermediate = new ArrayList<>();
			while(!s2.isEmpty())
			{
				TreeNode current = s2.pop();
				intermediate.add(current.val);
				if(current.right!=null)s1.push(current.right);
				if(current.left!=null)s1.push(current.left);
			}
			if (!intermediate.isEmpty()) result.add(intermediate);
		}
		return result;
	}

	public static void main(String args[]) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		for (List<Integer> row : zigZagLevelOrderBFS1(root))
			System.out.println(row);
	}
}
