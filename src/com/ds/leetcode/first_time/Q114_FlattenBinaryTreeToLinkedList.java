package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.TreeNode;
import com.ds.leetcode.Util.TreeUtil;

public class Q114_FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        helper(root, null);
    }

    public TreeNode helper(TreeNode root, TreeNode prev) {
        if (root == null)
            return prev;
        prev = helper(root.right, prev);
        prev = helper(root.left, prev);
        root.right = prev;
        root.left = null;
        prev = root;
        return prev;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        Q114_FlattenBinaryTreeToLinkedList obj = new Q114_FlattenBinaryTreeToLinkedList();
        obj.flatten(root);

        TreeUtil.printTreeInOrder(root);
    }
}
