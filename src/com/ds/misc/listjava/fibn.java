package listjava;

public class fibn {
	
	public static void fib(int n,int x)
	{
		  int [] a= new int[x];
		for(int i = 0; i < n; i++)
		a[i] = 1;

	for(int i = n; i < x; i++)
	{   
		a[i] =0;
		for(int j=1;j<=n;j++)
		{
			a[i] += a[i-j] ;
		}
	}
	
	
	  for(int i=0;i<x;i++)
          System.out.print(a[i] + " ");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		int x1 = 10;
		int n2 = 4;
		fib(n2,x1);
	}

}
