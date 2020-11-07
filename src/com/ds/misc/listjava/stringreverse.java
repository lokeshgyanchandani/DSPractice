package listjava;

public class stringreverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "you got a dream u got to protect it";
		char[] c = str.toCharArray();
		for (char i : c) {
			System.out.print(i);
		}
		reverse(0, str.length() - 1, c);
		
		System.out.println();
		int j = 0;
		for (int i = 0; i <=c.length; i++) {
			if (i == c.length || c[i] == ' '  ) {
				reverse(j, i - 1, c);
				j = i + 1;
			}
		}
		for (char i : c) { // System.out.println("ashish");
			System.out.print(i);
		}
	}
	public static void reverse(int low, int high, char[] c) {
		while (low < high) {
			char temp = c[low];
			c[low++] = c[high];
			c[high--] = temp;
					}

	}

}
