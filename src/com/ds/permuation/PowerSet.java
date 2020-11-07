package miscellaneous;

import java.util.Arrays;

public class PowerSet {

	public static void main(String[] args) {
		String s = new String("bac");
		String[] powerset = getPowerSet(s);
		for (String string : powerset) {
			System.out.println(string);
		}
	}

	private static String[] getPowerSet(String inputString)
	{
		int length = (int) Math.pow(2, inputString.length()) - 1;
		String[] powerSet = new String[length];
		for (int k = 1; k <= length; k++)
		{
			String subSequence = subsequence(k, inputString);
			powerSet[k - 1] = subSequence;
		}
		//Arrays.sort(powerSet);
		return powerSet;
	}

	private static String subsequence(int k, String string) {
		StringBuilder builder = new StringBuilder();
		int index = 0;
		for (int i = k; i > 0; i >>= 1) {
			if ((i & 1) == 1) {
				builder.append(string.charAt(index));
			}
			else
				builder.append('*');
			index++;
		}
		while(index < string.length())
		{
			builder.append('*');
			index++;
		}
		return builder.toString();
	}
}
