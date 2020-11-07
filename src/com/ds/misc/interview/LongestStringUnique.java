package interview;

import java.util.HashMap;

public class LongestStringUnique {

	public static void main(String[] args) {
		String s = "abcbde";

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int start = 0;
		int maxlen = 0;

		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				int index = map.get(s.charAt(i));
				if(start<=index)
				{
					start = index+1;
				}
			}
			maxlen = Math.max(i-start+1, maxlen);
			map.put(s.charAt(i), i);
		}

		System.out.println(maxlen);
	}

}
