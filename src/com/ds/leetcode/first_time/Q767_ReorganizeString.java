package com.ds.leetcode.first_time;

public class Q767_ReorganizeString {

	static String reorganizeString(String s) {
		if (s == null || s.length() <= 1) return s;

		// Count freq
		int[] hash = new int[26];
		for (int i = 0; i < s.length(); i++)
			hash[s.charAt(i) - 'a']++;

		// Find max
		int max = 0, letter = 0;
		for (int i = 0; i < hash.length; i++) {
			if (hash[i] > max) {
				max = hash[i];
				letter = i;
			}
		}

		// Check if max is too big, string not possible in that case
		if (max > (s.length() + 1) / 2)
			return "";

		char[] res = new char[s.length()];

		// Fill with max character alternatively
		int index = 0;
		while (hash[letter] > 0) {
			res[index] = (char)('a' + letter);
			hash[letter]--;
			index += 2;
		}

		for (int i = 0; i < hash.length; i++) {
			while (hash[i] > 0) {
				if (index >= res.length) index = 1;
				res[index] = (char)(i + 'a');
				index += 2;
				hash[i]--;
			}
		}

		return String.valueOf(res);
	}

	public static void main(String args[]) {
		System.out.println(reorganizeString("vvvlo"));
		char c = '2';
		System.out.println(c);
	}
}
