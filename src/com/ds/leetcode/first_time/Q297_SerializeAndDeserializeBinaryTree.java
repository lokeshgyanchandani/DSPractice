package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q297_SerializeAndDeserializeBinaryTree {

    // Use pre-order traversal
    public String serialize(TreeNode root) {
        if (root == null) return "#";

        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return helper(queue);
    }

    private TreeNode helper(Queue<String> queue) {
        String s = queue.poll();

        if (s.equals("#")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(s));

        root.left = helper(queue);
        root.right = helper(queue);

        return root;
    }
}
