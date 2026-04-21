package com.ds.leetcode.first_time;

import com.ds.leetcode.Util.TreeNode;

import java.util.Stack;

public class Q536_Construct_Binary_Tree_from_String {

    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        for (int i = 0, j = i; i < s.length(); i++, j = i) {
            char c = s.charAt(i);
            if (c == ')') stack.pop();
            else if (c >= '0' && c <= '9' || c == '-') {
                while (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
                TreeNode root = new TreeNode(Integer.valueOf(s.substring(j, i + 1)));
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left == null) parent.left = root;
                    else parent.right = root;
                }
                stack.push(root);
            }
        }

        return stack.isEmpty() ? null : stack.pop();
    }
}
