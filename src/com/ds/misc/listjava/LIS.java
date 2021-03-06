package listjava;

import java.util.ArrayList;
import java.util.Arrays;

public class LIS {

	public static int cost(int[] x, int[] y) {
		int m = x.length + 1;
		int n = y.length + 1;
		ArrayList<Integer> list = new ArrayList<Integer>();
		int a[][] = new int[m][n];

		
		for (int i = 0; i < m; i++) {
			a[i][0] = 0;
		}

		for (int i = 0; i < n; i++) {
			a[0][i] = 0;
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				int b = 0, c = 0, d = 0;
				if (x[i - 1] == y[j - 1])
					b = a[i - 1][j - 1]+1;
				else
					b = a[i - 1][j - 1];

				c = a[i - 1][j] ;
				d = a[i][j - 1] ;

				a[i][j] = Math.max(Math.max(b, c), d);
				
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		int i1=m-1;
		int i2=n-1;
		while(i1>0 && i2>0)
		{
			if(x[i1-1]==y[i2-1])
			{
				list.add(0,x[i1-1]);
				i1--;
				i2--;
			}
			else if
			(a[i1-1][i2]>a[i1][i2-1])
					{
				i1--;
					}
			else
				i2--;
		}
		for(int t :list){
			System.out.print(t+" ");
		}
		System.out.println();
		return a[m - 1][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] x2 =  {10,1,2,22,9,33,11,21,50,41,60,80} ;
		int[] x1 =  {10,1,2,22,9,33,11,21,50,41,60,80} ;
		Arrays.sort(x1);
		
		int k = cost(x1, x2);

}
}