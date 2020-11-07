package listjava;

import java.util.ArrayList;
import java.util.HashMap;

public class mobilekeypad {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		list = combinations("3457");
		for (String s : list) {
			System.out.println(s);
		}
	}

	public static ArrayList<String> combinations(String str) {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<String> list1 = new ArrayList<String>();

		list.add("");

		for (int i = 0; i < str.length(); i++) {
			String t = map.get(str.charAt(i));
			for (int j = 0; j < t.length(); j++) {
				for (String s : list) {
					s = new String(s + t.charAt(j));
					list1.add(s);
				}
			}
			list =list1;
			list1 = new ArrayList<String>();
		}
		return list;
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
