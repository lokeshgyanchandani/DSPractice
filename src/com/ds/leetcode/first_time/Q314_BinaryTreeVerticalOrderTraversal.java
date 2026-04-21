package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.TreeNode;
/*import javafx.util.Pair;*/

import java.util.*;

public class Q314_BinaryTreeVerticalOrderTraversal {

	/*public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> output = new ArrayList<>();
		if (root == null) {
			return output;
		}

		Map<Integer, ArrayList> columnTable = new HashMap<>();
		// Pair of node and its column offset
		Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
		int column = 0;
		queue.offer(new Pair<>(root, column));

		int minColumn = 0, maxColumn = 0;

		while (!queue.isEmpty()) {
			Pair<TreeNode, Integer> p = queue.poll();
			root = p.getKey();
			column = p.getValue();

			columnTable.putIfAbsent(column, new ArrayList<Integer>());
			columnTable.get(column).add(root.val);
			minColumn = Math.min(minColumn, column);
			maxColumn = Math.max(maxColumn, column);

			if (root.left != null) queue.offer(new Pair<>(root.left, column - 1));
			if (root.right != null) queue.offer(new Pair<>(root.right, column + 1));
		}

		for(int i = minColumn; i < maxColumn + 1; ++i) {
			output.add(columnTable.get(i));
		}

		return output;
	}*/

	public static void main(String[] args) {
		/*TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(0);
		root.left.right.left = new TreeNode(5);

		root.right = new TreeNode(8);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(7);
		root.right.left.right = new TreeNode(2);

		Q314_BinaryTreeVerticalOrderTraversal obj = new Q314_BinaryTreeVerticalOrderTraversal();
		List<List<Integer>> results = obj.verticalOrder(root);

		for (List<Integer> result: results) {
			System.out.println(result);
		}*/
	}
}
