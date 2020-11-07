package listjava;

public class cutrod {
	public static int cutRod(int price[], int n)
	{
	   int[] val= new int[n+1];
	   val[0] = 0;
	   int i, j;
	 
	   // Build the table val[] in bottom up manner and return the last entry
	   // from the table
	   for (i = 1; i<=n; i++)
	   {
	       int max_val = -100;
	       for (j = 0; j < i; j++)
	         max_val = Math.max(max_val, price[j] + val[i-j-1]);
	       val[i] = max_val;
	   }
	 
	   return val[n];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
	    int size = arr.length;
	    System.out.println("Maximum Obtainable Value is "+cutRod(arr, size));
	

	}

}

