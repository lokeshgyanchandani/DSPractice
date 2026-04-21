package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q113_PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> results = new ArrayList<>();

        helper(root, results, new ArrayList<>(), targetSum);

        return results;
    }

    private void helper(TreeNode root, List<List<Integer>> results, List<Integer> current,
                        int targetSum) {
        if (root == null) return;

        current.add(root.val);

        if (root.left == null && root.right == null && root.val == targetSum) {
            results.add(new ArrayList<>(current));
            current.remove(current.size() - 1);
            return;
        }

        helper(root.left, results, current, targetSum - root.val);
        helper(root.right, results, current, targetSum - root.val);

        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        Q113_PathSumII obj = new Q113_PathSumII();
        List<List<Integer>> results = obj.pathSum(root, 22);
        for (List<Integer> result: results)
            System.out.println(Arrays.deepToString(result.toArray()));
    }
}
