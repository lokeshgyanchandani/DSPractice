package com.ds.leetcode.first_time;

import java.util.ArrayList;
import java.util.List;

public class Q438_FindAllAnagramsInString {

	public List<Integer> findAnagrams(String source, String target) {

		List<Integer> result = new ArrayList<>();

		int[] charCounts = new int[26];
		for (char c: target.toCharArray())
			charCounts[c - 'a']++;

		int left = 0, right = 0;
		int count = target.length();

		while (right < source.length()) {
			char currentChar = source.charAt(right);

			charCounts[currentChar - 'a']--;
			if (charCounts[currentChar - 'a'] >= 0)
				count--;

			if (count == 0)
				result.add(left);

			if (right - left + 1 == target.length()) {
				charCounts[source.charAt(left) - 'a']++;
				if (charCounts[source.charAt(left) - 'a'] > 0)
					count++;
				left++;
			}

			right++;
		}

		return result;
	}

	public static void main(String[] args) {
		Q438_FindAllAnagramsInString obj = new Q438_FindAllAnagramsInString();
		System.out.println(obj.findAnagrams("cbaebabacd", "abc"));
	}
}
