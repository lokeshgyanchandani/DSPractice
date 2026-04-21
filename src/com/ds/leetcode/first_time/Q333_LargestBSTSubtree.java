package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.TreeNode;

public class Q333_LargestBSTSubtree {

    public int largestBSTSubtree(TreeNode root) {
        int[] ret = largestBST(root);
        return ret[2];
    }

    private int[] largestBST(TreeNode root) {
        if (root == null)
            return new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0};

        int[] left = largestBST(root.left);
        int[] right = largestBST(root.right);

        if (left[1] < root.val && root.val < right[0]) {
            return new int[] {
                    Math.min(left[0], root.val),
                    Math.max(root.val, right[1]),
                    left[2] + right[2] + 1
            };
        } else {
            // BST condition is not satisfied
            return new int[] {
                    Integer.MIN_VALUE,
                    Integer.MAX_VALUE,
                    Math.max(left[2], right[2])
            };
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.right.right = new TreeNode(7);

        Q333_LargestBSTSubtree obj = new Q333_LargestBSTSubtree();

        System.out.println(obj.largestBSTSubtree(root));
    }
}
