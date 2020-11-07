package interview;

import java.util.HashSet;
import java.util.Set;

public class Wordbreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> wordDict = new HashSet<>();
		wordDict.add("leet");
	//	wordDict.add("code");
		String s = "leetcode";
		System.out.println(wordBreak(s, wordDict));
	}

	private static boolean wordBreak(String s, Set<String> wordDict) {
		for (int i = 0; i < s.length(); i++) {
			if (wordDict.contains(s))
				return true;
			String substr1 = s.substring(0, i);
			String substr2 = s.substring(i);
			if (wordDict.contains(substr1)) {
				if (wordBreak(substr2, wordDict))
					return true;
			} else
				continue;
		}
		return false;
	}

}
