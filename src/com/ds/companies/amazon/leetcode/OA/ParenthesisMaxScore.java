package com.ds.companies.amazon.leetcode.OA;

public class ParenthesisMaxScore {

    public static int maxScore(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            if (arr[i] == '(' && arr[j] == ')') {
                return (j - i);
            }
            if (arr[i] != '(') {
                i++;
            }
            if (arr[j] != ')') {
                j--;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(maxScore("()()")); // Output: 3
        System.out.println(maxScore("(()"));  // Output: 2
    }
}
