package com.ds.leetcode.first_time;

import java.util.*;

public class Q17_LetterCombinations {

	static final String[] LOOKUP_RECURSIVE = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	static final String[] LOOKUP = { "0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	static List<String> letterCombinationsRecursive(String digits) {
		if (digits == null || digits.isEmpty())
			return null;
		List<String> results = new ArrayList<>();
		helper(digits, 0, "", results);
		return results;
	}

	static void helper(String digits, int currentIndex, String intermediate, List<String> results) {
		if (intermediate.length() == digits.length()) {
			results.add(intermediate);
			return;
		}
		for (char c : LOOKUP_RECURSIVE[digits.charAt(currentIndex) - '0'].toCharArray()) {
			helper(digits, currentIndex + 1, intermediate + c, results);
		}
	}

	static List<String> letterCombinations(String digits) {
		LinkedList<String> results = new LinkedList<>();
		if (digits == null || digits.isEmpty())
			return results;
		results.add("");
		while(results.peek().length()!=digits.length()){
			String remove = results.remove();
			String map = LOOKUP[digits.charAt(remove.length())-'0'];
			for(char c: map.toCharArray()){
				results.addLast(remove+c);
			}
		}
		return results;
	}

	public static void main(String args[]) {
		System.out.println(letterCombinations("23"));
	}
}
