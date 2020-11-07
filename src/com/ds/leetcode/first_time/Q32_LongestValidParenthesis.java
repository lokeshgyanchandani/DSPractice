package com.ds.leetcode.first_time;

import java.util.Stack;

public class Q32_LongestValidParenthesis {

	static int longestValidParenthesis(String s) {
		if (s == null || s.length() <= 1) return 0;

		Stack<Integer> stack = new Stack<>();
		int max=0;
		int left = -1;
		for(int j=0;j<s.length();j++){
			if(s.charAt(j)=='(') stack.push(j);
			else {
				if (stack.isEmpty()) left=j;
				else{
					stack.pop();
					if(stack.isEmpty()) max=Math.max(max,j-left);
					else max=Math.max(max,j-stack.peek());
				}
			}
		}
		return max;
	}

	public static void main(String args[]) {
		System.out.println(longestValidParenthesis(")()())"));
	}
}
