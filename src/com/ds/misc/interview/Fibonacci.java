package interview;

public class Fibonacci {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cal(20);
	}

	private static void cal(int n) {
		int a[] = new int[n];
		a[0] = 0;
		a[1] =1;
		for(int i=2;i<n;i++)
		{
			a[i] = a[i-1]+a[i-2];
		}
		for(int i:a )
		{
			System.out.println(i);
		}
	}

}
