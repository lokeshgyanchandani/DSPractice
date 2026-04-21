package com.ds.leetcode.first_time;

import java.util.ArrayList;
import java.util.List;

public class Q14_LongestCommonPrefix {

	public static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) return "";

		String pre = strs[0];
		int i = 1;
		while(i < strs.length) {
			while(strs[i].indexOf(pre) != 0)
				pre = pre.substring(0,pre.length()-1);
			i++;
		}
		return pre;
	}

	public static void main(String[] args) {
		List<String> input = new ArrayList<String>() {{
			add("flower");
			add("flow");
			add("flight");
		}};

		//System.out.println(longestCommonPrefix(input.toArray(new String[input.size()])));
		System.out.println("abc".indexOf("def"));
	}
}
