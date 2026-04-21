package com.ds.leetcode.first_time;

import java.util.*;

public class Q249_GroupShiftedStrings {

	public List<List<String>> groupStrings(String[] strings) {

		Map<String, List<String>> map = new HashMap<>();
		for (String string: strings) {
			StringBuilder currentKey = new StringBuilder();
			for (int i = 1; i < string.length(); i++) {
				int diff = (string.charAt(i) - string.charAt(i - 1));
				if (diff < 0)
					diff = 26 + diff;
				currentKey.append(diff);
				currentKey.append("|");
			}
			map.putIfAbsent(currentKey.toString(), new ArrayList<>());
			map.get(currentKey.toString()).add(string);
		}

		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		String[] strings = new String[]{"abc","bcd","acef","xyz","az","ba","a","z"};
		Q249_GroupShiftedStrings obj = new Q249_GroupShiftedStrings();
		List<List<String>> res = obj.groupStrings(strings);
		for (List<String> subRes: res)
			System.out.println(Arrays.deepToString(subRes.toArray()));
	}
}
