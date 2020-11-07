package listjava;

public class mincost {

	public static int cost(int [][] a,int m,int n) {
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		int i1=m-1;
		int i2=n-1;
		int min;
		int cost =a[m-1][n-1];
		while(i1!=0 && i2!=0)
		{
			if(a[i1-1][i2-1]<a[i1-1][i2] && a[i1-1][i2-1]<a[i1][i2-1])
			{
				min = a[i1-1][i2-1];
				i1--;
				i2--;
			}
			else if(a[i1-1][i2]<a[i1][i2-1])
			{
				min = a[i1-1][i2];
				i1--;
			}
			else
			{
				min = a[i1][i2-1];
				i2--;
			}
			cost = cost+min;
			
		}
		
		return cost;
	}
	public static void main(String[] args) {
		
		int a[][] = { {1, 2, 3},
                {4, 8, 2},
                {1, 5, 3} };
		int k = cost(a,3,2);
		System.out.println(k);
	}
}
