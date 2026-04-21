package com.ds.leetcode.first_time;

public class Q567_PermutationInString {

	static int NUM = 26;

	static boolean checkInclusion(String s1, String s2) {
		if (s1 == null) return false;
		if (s2 == null) return false;
		if (s1.length() > s2.length()) return false;

		int[] s1Map = new int[NUM];
		int[] s2Map = new int[NUM];

		for (int i = 0; i < s1.length(); i++) {
			s1Map[s1.charAt(i) - 'a']++;
			s2Map[s2.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s2.length() - s1.length(); i++) {
			if (matches(s1Map, s2Map))
				return true;
			s2Map[s2.charAt(i + s1.length()) - 'a']++;
			s2Map[s2.charAt(i) - 'a']--;
		}
		return matches(s1Map, s2Map);
	}

	static boolean checkInclusionFaster(String s1, String s2) {
		if (s1 == null) return false;
		if (s2 == null) return false;
		if (s2.length() < s1.length()) return false;

		int[] counts = new int[NUM];
		for (char c: s1.toCharArray()) counts[c-'a']++;
		int i = 0, j = 0;
		while(j < s2.length()) {
			char c = s2.charAt(j++);
			counts[c-'a']--;
			while(counts[c-'a'] < 0) {
				char c2 = s2.charAt(i++);
				counts[c2-'a']++;
			}
			if (j-i == s1.length()) return true;
		}
		return false;
	}

	private static boolean matches(int[] s1Map, int[] s2Map) {
		for (int i = 0; i < NUM; i++) {
			if (s1Map[i] != s2Map[i])
				return false;
		}
		return true;
	}


	static boolean checkInclusionThird(String s1, String s2) {
		if (s1 == null || s1.length() == 0) { return true; }
		if (s2 == null || s2.length() == 0 || s1.length() > s2.length()) { return false; }

		int[] count = new int[128];
		for(int i = 0; i < s1.length(); i++) count[s1.charAt(i)]--;
		for(int l = 0, r = 0; r < s2.length(); r++) {
			if (++count[s2.charAt(r)] > 0)
				while(--count[s2.charAt(l++)] != 0) { /* do nothing */}
			else if ((r - l + 1) == s1.length()) return true;
		}
		return s1.length() == 0;
	}

	public static void main(String args[]) {
		System.out.println(checkInclusion("ab", "eidbaooo"));
	}
}
