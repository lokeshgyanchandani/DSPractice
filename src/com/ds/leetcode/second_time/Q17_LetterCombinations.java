package com.ds.leetcode.second_time;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q17_LetterCombinations {

	private static Map<Integer, String> map;

	public static List<String> letterCombinations(String digits) {
		initializeMap();

		List<String> res = new ArrayList<>();
		helper(digits, res, "");

		return res;
	}

	private static void helper(String digits, List<String> res, String temp) {
		if (digits.equals("")) {
			res.add(temp);
			return;
		}

		int digit = Integer.parseInt("" + digits.charAt(0));
		for (char c: map.get(digit).toCharArray()) {
			helper(digits.substring(1), res, temp + c);
		}
	}

	private static void initializeMap() {
		map = new HashMap<>();

		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
	}

	public static void main(String[] args) {
		String digits = "23";
		System.out.println(letterCombinations(digits));
	}
}
