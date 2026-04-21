package com.ds.companies.amazon.leetcode;

import java.util.*;

public class SubStringsOfSizeKWithDistinctChars {

	public List<String> findSubStrings(String str, int k) {
		if (k < 0 || str == null || str.length() == 0) {
			return new ArrayList<>();
		}

		Set<String> res = new HashSet<>();
		HashMap<Character, Integer> hm = new HashMap<>();
		int start = 0;

		for (int end = 0; end < str.length(); end++) {
			char c = str.charAt(end);
			hm.put(c, hm.getOrDefault(c, 0) + 1);
			if (end - start == k - 1) {
				if (hm.size() == k - 1) {
					res.add(str.substring(start, end + 1));
				}
				char remove = str.charAt(start++);
				hm.put(remove, hm.get(remove) - 1);
				if (hm.get(remove) == 0) {
					hm.remove(remove);
				}
			}
		}

		return new ArrayList<>(res);
	}

	public static void main(String[] args) {

	}
}
