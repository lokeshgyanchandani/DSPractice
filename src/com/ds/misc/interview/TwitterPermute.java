package interview;

import java.util.ArrayList;
import java.util.List;

public class TwitterPermute {

	public static void main(String[] args) {
		String s = "a b c {abc,def,ghi} d e f {lk,jj,kl} g h j ";
		List<List<String>> list = new ArrayList<List<String>>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{') {
				StringBuffer buffer = new StringBuffer();
				i++;
				while (s.charAt(i) != '}') {
					buffer.append(s.charAt(i));
					i++;
				}
				List<String> l = new ArrayList<String>();
				String[] temp = buffer.toString().split(",");
				for (String s1 : temp) {
					l.add(s1);
				}
				list.add(l);
			}

		}
		letterCombinations1(list);
		System.out.println(list);
	}

	private static void letterCombinations1(List<List<String>> list) {
		
	}

	public List<String> letterCombinations(String digits) {

		if (digits.equals("")) {
			return new ArrayList<>();
		}
		String[] nums = { " ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs",
				"tuv", "wxyz" };
		List<String> list = new ArrayList<>();
		String x = "";
		helper(0, nums, x, digits, list);
		return list;
	}

	public void helper(int index, String[] nums, String x, String digits,
			List<String> list) {
		if (x.length() == digits.length()) {
			list.add(x);
			return;
		}
		int temp = Character.getNumericValue(digits.charAt(index));
		String word = nums[temp];
		for (int i = 0; i < word.length(); i++) {
			x = x + word.charAt(i);
			helper(index + 1, nums, x, digits, list);
			x = x.substring(0, x.length() - 1);
		}
	}
}
