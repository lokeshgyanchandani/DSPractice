package interview;

public class Edit {

	public static void main(String[] args) {
		String S = "nice";
		String T = "niece";

		int m = S.length();
		char[] s1 = S.toCharArray();
		char[] t1 = T.toCharArray();
		int n = T.length();
		int flag = 0;
		if (Math.abs(m - n) > 1)
			System.out.println("IMPOSSIBLE");
		if (m == n) {
			
			int count = 0;
			for (int i = 0; i < m; i++) {
				
				if (s1[i] != t1[i]) {
					flag = 1;
					if (count < 2) {
						s1[i] = t1[i];
						count++;
					} else {
						System.out.println("IMPOSSIBLE");
					}
				}
			}
		}
		if (m > n) {
			flag = 2;
			for (int i = 0; i < n; i++) {
				if (s1[i] != t1[i]) {
					s1[i] = '#';
					break;
				}
			}
		}
		if (m < n) {
			flag = 3;
			for (int i = 0; i < m; i++) {
				if (s1[i] != t1[i]) {
					t1[i] = '#';
					break;
				}
			}
		}
		String a = "";
		String b = "";
		for (int i = 0; i < m; i++) {
			if (s1[i] != '#') {
				a = a + s1[i];
			}
		}
		for (int i = 0; i < n; i++) {
			if (t1[i] != '#') {
				b = b + t1[i];
			}
		}

		if (!a.equals(b)) {
			System.out.println("IMPOSSIBLE");
		} else {
			if (flag == 0)
				System.out.println("nothing");
			if (flag == 1)
				System.out.println("swap");
			if (flag == 2)
				System.out.println("delete");
			if (flag == 3)
				System.out.println("insert");
		}
	}

}
