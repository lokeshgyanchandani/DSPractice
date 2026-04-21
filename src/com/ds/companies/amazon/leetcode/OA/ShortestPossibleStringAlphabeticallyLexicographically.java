package com.ds.companies.amazon.leetcode.OA;

import java.util.Stack;

public class ShortestPossibleStringAlphabeticallyLexicographically {

    public String solution(String S) {
        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop(); // Remove the pair
            } else {
                stack.push(c);
            }
        }

        // Convert stack to string
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        // Sort lexicographically
        char[] arr = result.toString().toCharArray();
        java.util.Arrays.sort(arr);

        return new String(arr);
    }

    public static void main(String[] args) {
        ShortestPossibleStringAlphabeticallyLexicographically sol = new ShortestPossibleStringAlphabeticallyLexicographically();
        System.out.println(sol.solution("CBCAAXA")); // Output: BAX
        System.out.println(sol.solution("ZYXZYZY")); // Output: XYZ
        System.out.println(sol.solution("ABCBACDDAA")); // Output: ""
        System.out.println(sol.solution("AKFKFMOGKFB")); // Output: AFKMOGB
    }
}
