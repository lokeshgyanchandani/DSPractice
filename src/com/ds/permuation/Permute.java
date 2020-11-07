package miscellaneous;

import java.util.ArrayList;
import java.util.Collections;

public class Permute {
	public static void main(String[] args) {
		calculate(3, 4);

		System.out.println(calculate(3, 4));
	}

	private static String calculate(int n, int m) {
		ArrayList<String> list = new ArrayList<String>();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < n; i++) {
			builder.append(i);
		}

		list = permutation(builder.toString());
		Collections.sort(list);
		return list.get(m - 1);

	}

	private static ArrayList<String> permutation(String str) {
		ArrayList<String> set = new ArrayList<String>();
		if (str.length() == 0) {
			set.add("");
			return set;
		}

		char temp = str.charAt(0);
		String rem = str.substring(1);
		ArrayList<String> set1 = permutation(rem);

		for (String string : set1) {
			for (int i = 0; i <= string.length(); i++) {
				String newstr = add(string, temp, i);
				set.add(newstr);
			}
		}
		return set;

	}

	private static String add(String s, char c, int i) {

		String s1 = s.substring(0, i);
		String s2 = s.substring(i);
		return s1 + c + s2;
	}
}
