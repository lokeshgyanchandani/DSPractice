package miscellaneous;

public class PermuteRec {

	public static void main(String[] args) {
		String s = new String("abc");
		char[] c = s.toCharArray();
		permute(c, 0);

	}

	public static void permute(char[] c, int n) {
		if (n == c.length) {
				System.out.println(c);
		}
		else
		{
			for(int i =n;i<c.length;i++)
			{
				swap(c,i,n);
				permute(c,n+1);
				swap(c,i,n);
			}
		}
	}

	private static void swap(char[] c, int i, int j) {
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
	}

}