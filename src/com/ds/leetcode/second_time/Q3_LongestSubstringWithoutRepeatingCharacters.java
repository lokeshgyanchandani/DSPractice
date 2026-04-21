package com.ds.leetcode.second_time;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q3_LongestSubstringWithoutRepeatingCharacters {
	static int lengthOfLongestSubstring(String s) {
		int maxLen = 0;
		Set<Character> window = new HashSet<>();
		int left = 0, right = 0;
		while (right < s.length()) {
			while (window.contains(s.charAt(right)))
				window.remove(s.charAt(left++));
			window.add(s.charAt(right++));
			maxLen = Math.max(maxLen, right - left);
		}
		return maxLen;
	}

	static int lengthOfLongestSubstringFaster(String s) {
		if (s.length() == 0) return 0;
		Map<Character, Integer> map = new HashMap<>();
		int max=0;
		for (int i=0, j=0; i<s.length(); ++i){
			if (map.containsKey(s.charAt(i))){
				j = Math.max(j,map.get(s.charAt(i))+1);
			}
			map.put(s.charAt(i),i);
			max = Math.max(max,i-j+1);
		}
		return max;
	}

	public static void main(String args[]) {
		System.out.println(lengthOfLongestSubstringFaster("pwowkew"));
	}
}
