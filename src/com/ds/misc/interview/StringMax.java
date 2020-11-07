package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class StringMax {

	public static void main(String[] args) {

		String[] dictionary = { "cat", "cats", "catsdogcats", "catxdogcatsrat",
				"dog", "dogcatsdog", "rat", "ratcat","hipposgdjekfffnkddk",
				"ratcatdog", "ratcatdogcat" };
		ArrayList<String> list = new ArrayList<>();
		Arrays.sort(dictionary, new StringLengthComparator());

		for (String i : dictionary) {
			list.add(i);
		}

		System.out.println(findLongestCompoundWord(list));

	}

	private static String findLongestCompoundWord(ArrayList<String> list) {
		
		while (list.size() > 0) {
			String word = list.get(list.size()-1);
			list.remove(word);
			if (isCompoundWord(word,list))
				return word;
		}
		return "";
	}

	private static boolean isCompoundWord(String word, ArrayList<String> list) {
		if(list.contains(word))
			return true;
		for(int i =0;i<word.length();i++)
		{
			if(isCompoundWord(word.substring(0,i), list))
			{
				String remainder = word.substring(i,word.length());
				if (remainder.length() == 0) 
					return true;
				return isCompoundWord(remainder, list);
			}
		}
		return false;
	}
}

class StringLengthComparator implements Comparator<String> {
	@Override
	public int compare(String arg0, String arg1) {
		return Integer.compare(arg0.length(), arg1.length());
	}
}
