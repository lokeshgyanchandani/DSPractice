package com.ds.leetcode.first_time;

public class Q_UnknownBracketExpansion {

	/*String expandExpression(String input) {
		if (input == null || input.isEmpty()) return input;

		StringBuffer result = new StringBuffer();
		int bracketsOpen = 0;
		for (int index = 0; index < input.length(); index++) {
			StringBuffer intermediate = new StringBuffer();
			if (input.charAt(index) >= 'a' && input.charAt(index) <= 'z') {
				char ch = input.charAt(index);
				int count = Integer.parseInt(input.charAt(++index) + "");
				while (count-- > 0)
					intermediate.append(input.charAt(ch));
			} else if (input.charAt(index) == '(') {
				if (bracketsOpen == 0) {
					result.append(intermediate.toString());
					intermediate = new StringBuffer();
				}
				bracketsOpen++;
			} else if (input.charAt(index) == ')') {
				bracketsOpen--;
				int count = Integer.parseInt(input.charAt(++index) + "");
				if (bracketsOpen == 0) {
					while (count-- > 0)
						result.append(intermediate.toString());
				} else {
					while (count-- > 0) {

						result.append(intermediate.toString());
					}
				}
			}
		}
	}
*/
	public static void main(String args[]) {

	}
}
