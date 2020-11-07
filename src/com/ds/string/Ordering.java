package string;

public class Ordering {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "ab";
		String b = "ae";
		String c = "abae";
		if (a.length() + b.length() != c.length()) {
			System.out.println("error");
			return;
		}

		int i = 0, j = 0, k = 0;
		while (i < a.length() && j < b.length()) {
			if (c.charAt(k) == a.charAt(i)) {
				i++;
				k++;
			} else if (c.charAt(k) == b.charAt(j)) {
				j++;
				k++;
			} else {
				System.out.println("error");
				break;
			}
		}
		while (i < a.length()) {
			if (c.charAt(k) == a.charAt(i)) {
				i++;
				k++;
			} else
				break;
		}
		while (j < b.length()) {
			if (c.charAt(k) == b.charAt(j)) {
				j++;
				k++;
			} else
				break;
		}
		if (k == c.length())
			System.out.println("macthed");
		else
			System.out.println("error");

	}
}
