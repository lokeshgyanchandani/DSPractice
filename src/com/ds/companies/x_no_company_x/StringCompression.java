package com.ds.companies.x_no_company_x;

public class StringCompression {

	public static void main(String[] args) {
		System.out.println(compress("aabcccccaaa"));
		System.out.println(compress("aaaabbb"));
		System.out.println(compress("aaaaa"));
		System.out.println(compress("aaabbbccc"));
		System.out.println(compress("abc"));
		System.out.println(compress("a"));
		System.out.println(compress(""));

	}

	public static String compress(String str) {
	    if (str.isEmpty()) {
	        return "";
	    }

	    char[] chars = str.toCharArray();
	    StringBuilder builder = new StringBuilder();

	    int count = 1;
	    char prev = chars[0];
	    for (int i = 1; i < chars.length; i++) {
	        char current = chars[i];
	        if (current == prev) {
	            count++;
	        } else {
	            builder.append(prev).append(count);
	            count = 1;
	        }
	        prev = current;
	    }
	    return builder.append(prev).append(count).toString();
	}
}
