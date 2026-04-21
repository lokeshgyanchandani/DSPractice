package com.ds.leetcode.first_time;

public class Q616_AddBoldTagToString {

	public String addBoldTag(String s, String[] words) {
		boolean[] bold = new boolean[s.length()];

		for (String word: words) {
			int index = s.indexOf(word);
			while (index >= 0) {
				for (int i = index; i < index + word.length(); i++)
					bold[i] = true;
				index = s.indexOf(word, index + 1);
			}
		}

		StringBuilder sb = new StringBuilder();
		boolean currentBold = false;
		for (int i = 0; i < bold.length; i++) {
			if (bold[i] && !currentBold) {
				sb.append("<b>");
				currentBold = true;
			} else if (!bold[i] && currentBold) {
				sb.append("</b>");
				currentBold = false;
			}
			sb.append(s.charAt(i));
		}

		if (currentBold)
			sb.append("</b>");

		return sb.toString();
	}

	public static void main(String[] args) {
		Q616_AddBoldTagToString obj = new Q616_AddBoldTagToString();

		String s = "aaabbcc";
		String[] words = new String[] {"aaa","aab","bc"};

		System.out.println(obj.addBoldTag(s, words));
	}
}
