package miscellaneous;

import java.util.HashMap;

public class MobileKeypad {

	public static void main(String[] args) {
		String str = "3457";
		char output[] = new char[str.length()];
		comb(str, output, 0);
	}

	private static void comb(String str, char[] output, int i) {
		if (i == str.length()) {
			for (int k = 0; k < str.length(); k++)
				System.out.print(output[k]);
			System.out.println();
			return;
		} else {
			String t = map.get(str.charAt(i));
			for (int k = 0; k < t.length(); k++) {
				output[i] = t.charAt(k);
				comb(str, output, i + 1);
			}
		}
	}

	static HashMap<Character, String> map = new HashMap<Character, String>() {
		{
			put('2', "abc");
			put('3', "def");
			put('4', "ghi");
			put('5', "jkl");
			put('6', "mno");
			put('7', "pqrs");
			put('8', "tuv");
			put('9', "wxyz");
		}
	};
}
