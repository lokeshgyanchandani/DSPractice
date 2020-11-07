package com.ds.leetcode.first_time;

public class Q767_ReorganizeString {

	static String reorganizeString(String S) {
		if (S == null || S.length() <= 1) return S;

		int[] hash = new int[26];
		for (int i = 0; i < S.length(); i++) {
			hash[S.charAt(i) - 'a']++;
		}
		int max = 0, letter = 0;
		for (int i = 0; i < hash.length; i++) {
			if (hash[i] > max) {
				max = hash[i];
				letter = i;
			}
		}
		if (max > (S.length() + 1) / 2) {
			return "";
		}
		char[] res = new char[S.length()];
		int idx = 0;
		while (hash[letter] > 0) {
			res[idx] = (char) (letter + 'a');
			idx += 2;
			hash[letter]--;
		}
		for (int i = 0; i < hash.length; i++) {
			while (hash[i] > 0) {
				if (idx >= res.length) {
					idx = 1;
				}
				res[idx] = (char) (i + 'a');
				idx += 2;
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
