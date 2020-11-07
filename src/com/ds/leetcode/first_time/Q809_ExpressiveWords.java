package com.ds.leetcode.first_time;

public class Q809_ExpressiveWords {

	static int expressiveWords(String s, String[] words) {
		if (s == null || s.isEmpty() || words.length == 0) return 0;

		int result = 0;
		for (int index = 0; index < words.length; index++) {
			String word = words[index];
			int outer = 0, inner = 0, outerLen = 1, innerLen = 1;
			boolean ans = true;

			while (outer < s.length() && inner < word.length()) {
				while (outer < s.length() - 1 && s.charAt(outer) == s.charAt(outer + 1)) {
					outer++;
					outerLen++;
				}
				while (inner < word.length() - 1 && word.charAt(inner) == word.charAt(inner + 1)) {
					inner++;
					innerLen++;
				}
				if (s.charAt(outer) == word.charAt(inner) && (outerLen == innerLen || (outerLen >= 3 && outerLen >= innerLen))) {
					inner++;
					outer++;
					outerLen = 1;
					innerLen = 1;
				} else {
					ans = false;
					break;
				}
			}
			if (ans)
				result++;
		}

		return result;
	}

	public static void main(String args[]) {
		System.out.println(expressiveWords("dddiiiinnssssssoooo", new String[] {"dinnssoo","ddinso","ddiinnso","ddiinnssoo","ddiinso","dinsoo","ddiinsso","dinssoo","dinso"}));
	}
}
