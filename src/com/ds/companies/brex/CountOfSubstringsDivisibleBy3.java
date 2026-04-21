package com.ds.companies.brex;

public class CountOfSubstringsDivisibleBy3 {

	private static int fun(String input) {
		int[][] dp = new int[input.length()][input.length()];

		for (int i = 0; i < input.length(); i++)
			if ((input.charAt(i) - '0') % 3 == 0)
				dp[i][i] = 1;

		for (int start = 0; start < input.length(); start++) {
			for (int end = start + 1; end < input.length(); end++) {
				if ((input.charAt(end) - '0') % 3 == 0)
					dp[start][end] = dp[start][end - 1] + 1;
				else if (Integer.parseInt(input.substring(start, end + 1)) % 3 == 0)
					dp[start][end] = 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		fun("4536");
	}
}
