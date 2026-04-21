package com.ds.array;

public class ReverseString {
	static char[] reverseString(char[] s) {
		for (int i = 0; i < (s.length) / 2; i++) {
			char temp = s[i];
			s[i] = s[s.length - i - 1];
			s[s.length - i - 1] = temp;
 		}
 		return s;
	}

	public static void main(String args[]) {
		System.out.println(reverseString(new char[]{'H', 'a', 'n', 'n', 'a'}));
	}
}
