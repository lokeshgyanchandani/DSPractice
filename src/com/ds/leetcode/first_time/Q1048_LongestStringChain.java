package com.ds.leetcode.first_time;

import java.util.HashMap;
import java.util.Map;

public class Q1048_LongestStringChain {

	public int longestStrChain(String[] words) {
		if (words == null || words.length == 0) return 0;

		int result = 0;
		Map<String, Integer> map = new HashMap<>();

		for (String word: words) {
			StringBuilder sb = new StringBuilder(word);
			int best = 0;
			for (int i = 0; i < word.length(); i++) {
				char c = sb.charAt(i);
				String current = sb.deleteCharAt(i).toString();
				best = Math.max(best, map.getOrDefault(current, 0) + 1);
				sb.insert(i, c);
			}
			map.put(word, best);
			result = Math.max(result, best);
		}

		return result;
	}

	public static void main(String[] args) {
		Q1048_LongestStringChain obj = new Q1048_LongestStringChain();

		String[] words = new String[] {"a","b","ba","bca","bda","bdca"};
		System.out.println(obj.longestStrChain(words));
	}
}
