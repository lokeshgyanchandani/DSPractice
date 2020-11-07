package listjava;

public class denomination2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] den = { 1, 2, 3 };
		int k = findno(den, den.length, 51);
		System.out.println(k);

	}

	public static int findno(int[] den, int m, int n) {
		// If n is 0 then there is 1 solution (do not include any coin)
	    if (n == 0)
	        return 1;
	     
	    // If n is less than 0 then no solution exists
	    if (n < 0)
	        return 0;
	 
	    // If there are no coins and n is greater than 0, then no solution exist
	    if (m <=0 && n >= 1)
	        return 0;
	 
		else
			return (findno(den, m, n - den[m-1]) + findno(den, m - 1, n));

	}
}