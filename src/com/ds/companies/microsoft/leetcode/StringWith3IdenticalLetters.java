package com.ds.companies.microsoft.leetcode;

public class StringWith3IdenticalLetters {
	public static int solution(String str) {
		int length = str.length();
		int result = 0;
		for (int i = 0; i < length; i++) {
			int batch = 1;
			while (i < length - 1 && str.charAt(i) == str.charAt(i+1)) {
				batch++;
				i++;
			}
			result += batch / 3;
		}
		return result;
	}

	public static void main(String args[]) {
		String input = "baabab";
		System.out.println(solution(input));
	}
}
