package com.ds.leetcode.first_time;

public class Q1347_Minimum_Number_Of_Steps_To_Make_Two_Strings_Anagram {

	public int minSteps(String s, String t) {
		int[] tFreq = new int[26];
		for (char c: t.toCharArray())
			tFreq[c - 'a']++;

		int[] sFreq = new int[26];
		for (char c: s.toCharArray())
			sFreq[c - 'a']++;

		int res = 0;
		for (int i = 0; i < 26; i++) {
			if (sFreq[i] > tFreq[i])
				res += sFreq[i] - tFreq[i];
		}

		return res;
	}

	public static void main(String[] args) {
		Q1347_Minimum_Number_Of_Steps_To_Make_Two_Strings_Anagram obj = new Q1347_Minimum_Number_Of_Steps_To_Make_Two_Strings_Anagram();
		System.out.println(obj.minSteps("bab", "aba"));
	}
}
