package com.ds.leetcode.first_time;

import java.util.HashSet;
import java.util.Set;

public class Q1361_ValidateBinaryTreeNodes {

    Set<Integer> visited;
    boolean flag = true;

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        visited = new HashSet<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1)
                indegree[leftChild[i]]++;

            if (rightChild[i] != -1)
                indegree[rightChild[i]]++;
        }

        int root = 0;
        int count = 0;

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                count++;
                if (count > 1)
                    return false;
                root = i;
            }
            if (indegree[i] > 1)
                return false;
        }
        traverse(root, leftChild, rightChild);

        return visited.size() == n && flag;
    }

    private void traverse(int root, int[] l, int[] r) {
        if (visited.contains(root)) {
            flag = false;
            return;
        }

        if (root == -1)
            return;

        visited.add(root);
        traverse(l[root], l, r);
        traverse(r[root], l, r);
    }
}
