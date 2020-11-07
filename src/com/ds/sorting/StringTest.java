                                                                                                                                                        package sorting;

public class StringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aacccd";
		// String sc = null;
		String result = compress(s1);
		System.out.println(result);
	}

	private static String compress(String s1) {
		char[] c = s1.toCharArray();
		StringBuilder builder = new StringBuilder();
		int count = 0;
		if (c.length < 2) {
			return s1;
		}
		for (int i = 1; i < c.length; i++) {
			if (c[i - 1] != c[i]) {
				builder.append(c[i - 1]);
				if (count > 0) {
					builder.append(count + 1);
				}
				count = 0;
			} else {
				count++;
			}
			if (i == c.length - 1) {
				builder.append(c[i]);
				if (count > 0) {
					builder.append(count + 1);
				}

			}
		}
		return builder.toString();
	}
}
