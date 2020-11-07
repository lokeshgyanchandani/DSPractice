package com.ds.leetcode.first_time;

public class Q91_DecodeWays {
	static int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		char[] chars = s.toCharArray();
		int[] dp = new int[chars.length];
		dp[0] = (chars[0] == '0' ? 0 : 1);
		for (int index = 1; index < chars.length; index++) {
			char curr = chars[index];
			char prev = chars[index - 1];
			if (curr >= '1' && curr <= '9')
				dp[index] = dp[index - 1];
			if ((prev == '1' && curr >= '0' && curr <= '9') ||
					(prev == '2' && curr >= '0' && curr <= '6'))
				dp[index]+= index >= 2 ? dp[index - 2] : 1;
		}
		return dp[chars.length - 1];
	}

	public static void main(String args[]) {
		System.out.println(numDecodings("226"));
	}
}
