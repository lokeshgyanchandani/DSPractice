package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.TreeNode;

import java.util.*;

public class Q863_DistanceKInBinaryTree {

    private void buildParentMap(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        if (root == null)
            return;

        if (root.left != null)
            parentMap.put(root.left, root);
        if (root.right != null)
            parentMap.put(root.right, root);

        buildParentMap(root.left, parentMap);
        buildParentMap(root.right, parentMap);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        buildParentMap(root, parentMap);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);

        Set<TreeNode> visited = new HashSet<>(); //keep track of visited nodes
        visited.add(target);

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            if (level == k)
                break;

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                TreeNode left = current.left;
                if (left != null && !visited.contains(left)) {
                    visited.add(left);
                    queue.offer(left);
                }

                TreeNode right = current.right;
                if (right != null && !visited.contains(right)) {
                    visited.add(right);
                    queue.offer(right);
                }

                TreeNode parent = parentMap.get(current);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.offer(parent);
                }
            }

            level++; //we check levelwise and each level covers 1 unit distance
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }

        return result;
    }
}
