package interview;

public class oneEdit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isOneEdit("a", ""));
	}

	private static boolean isOneEdit(String s1, String s2) {
		// int len1 = first.length();
		// int len2 = second.length();
		// // If the length difference of the stings is more than 1, return
		// false.
		// if ((len1 - len2) > 1 || (len2 - len1) > 1 ) {
		// return false;
		// }
		// int i = 0, j = 0;
		// int diff = 0;
		// while (i<len1 && j<len2) {
		// char f = first.charAt(i);
		// char s = second.charAt(j);
		// if (f != s) {
		// diff++;
		// if (len1 > len2)
		// i++;
		// if (len2 > len1)
		// j++;
		// if (len1 == len2)
		// i++; j++;
		// }
		// else{
		// i++; j++;
		// }
		// if (diff > 1) {
		// return false;
		// }
		// }
		// // If the length of the string is not same. ex. "abc" and "abde" are
		// not one edit distance.
		// if (diff == 1 && len1 != len2 && (i != len1 || j != len2)) {
		// return false;
		// }
		// return true;
		for (int i = 0; i < s1.length() && i < s2.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				return s1.substring(i + 1) == s2.substring(i + 1) // case of
																	// change
						|| s1.substring(i + 1) == s2.substring(i) // case of s1
																	// has extra
						|| s1.substring(i) == s2.substring(i + 1); // case of s2
																	// has extra
			}
		}
		return Math.abs(s1.length() - s2.length()) == 1;

	}
}
