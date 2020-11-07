package string;

public class CountCharOcc {

	// public static void main(String[] args) {
	// String str = "ashishash";
	// int count[] = new int[26];
	// for (int i = 0; i < str.length(); i++) {
	// count[str.charAt(i) - 'a']++;
	// }
	// for (int i = 0; i < str.length(); i++) {
	// if (count[str.charAt(i) - 'a'] != 0)
	// {
	// System.out.print(str.charAt(i));
	// System.out.println(count[str.charAt(i) - 'a']);
	// count[str.charAt(i)-'a'] = 0;
	// }
	// }
	// }
	public static void main(String[] args) {
		String str = "ashishash";
		char[] ch = str.toCharArray();
		int i = 0;
		int j = str.length() - 1;
		while (i < j) {
			char temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
			i++;
			j--;
		}
		for(int k=0;k<str.length();k++)
		{
			System.out.println(ch[k]);
		}
		System.out.print(ch);
	}
}
