package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.TreeNode;

public class Q298_BinaryTreeLongestConsecutiveSequence {

    public int longestConsecutive(TreeNode root) {
        if (root == null)
            return 0;

        int[] maxLen = new int[]{1};
        helper(root, 1, maxLen);
        return maxLen[0];
    }

    public void helper(TreeNode root, int len, int[] maxLen) {
        if (root == null)
            return;

        if (root.left != null) {
            if (root.val + 1 == root.left.val)
                helper(root.left, len + 1, maxLen);
            else
                helper(root.left, 1, maxLen);
        }

        if (root.right != null) {
            if (root.val + 1 == root.right.val)
                helper(root.right, len + 1, maxLen);
            else
                helper(root.right, 1, maxLen);
        }

        maxLen[0] = Math.max(len, maxLen[0]);
    }

    public int longestConsecutive2(TreeNode root) {
        int[] max = {0};
        helper2(root, max);
        return max[0];
    }

    private int helper2(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        int curMax = 1;
        int left = helper2(root.left, max);
        int right = helper2(root.right, max);
        if (root.left != null && root.val == root.left.val - 1) {
            curMax = Math.max(left + 1, curMax);
        }
        if (root.right != null && root.val == root.right.val - 1) {

            curMax = Math.max(right + 1, curMax);
        }
        max[0] = Math.max(max[0], curMax);
        return curMax;
    }

    public static void main(String[] args) {

    }
}
