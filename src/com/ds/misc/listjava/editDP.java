package listjava;

public class editDP {

	public static int cost(char[] x, char[] y) {
		int m = x.length + 1;
		int n = y.length + 1;

		int a[][] = new int[m][n];

		for (int i = 0; i < m; i++) {
			a[i][0] = i;
		}

		for (int i = 0; i < n; i++) {
			a[0][i] = i;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				int b = 0, c = 0, d = 0;
				if (x[i - 1] == y[j - 1])
					b = a[i - 1][j - 1];
				else
					b = a[i - 1][j - 1] + 1;

				c = a[i - 1][j] + 1;
				d = a[i][j - 1] + 1;

				a[i][j] = Math.min(Math.min(b, c), d);

			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		return a[m - 1][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x1 = "sunday";
		String y1 = "saturday";
		char[] x = x1.toCharArray();
		char[] y = y1.toCharArray();
		int k = cost(x, y);
		System.out.println(k);
	}

}
