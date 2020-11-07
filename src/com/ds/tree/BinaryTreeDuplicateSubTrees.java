package com.ds.tree;

import java.util.*;

class Node {
    Node left, right;
    char data;

    Node(char val) {
        this.data = val;
        left = right = null;
    }
}

public class BinaryTreeDuplicateSubTrees {

    private static final String MARKER = "$";
    private static HashSet<String> stringSet = new HashSet<>();

    public static void main(String args[]) {
        Node root = new Node('A');
        root.left = new Node('B');
        root.left.left = new Node('D');
        root.left.right = new Node('E');
        root.right = new Node('C');
        root.right.right = new Node('B');
        root.right.right.left = new Node('D');
        root.right.right.right = new Node('E');
        root.right.right.right.left = new Node('F');

        String found = isDuplicateSubtree(root);
        if (found.equals(""))
            System.out.println("Found");
        else
            System.out.println("Not found");
    }

    private static String isDuplicateSubtree(Node root) {
        if (root == null)
            return MARKER;

        String lStr = isDuplicateSubtree(root.left);
        if (lStr.equals(""))
            return "";
        String rStr = isDuplicateSubtree(root.right);
        if (rStr.equals(""))
            return "";
        String s = root.data + lStr + rStr;
        if (s.length() > 3 && stringSet.contains(s))
            return "";
        stringSet.add(s);
        return s;
    }
}
