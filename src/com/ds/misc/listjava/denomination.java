package listjava;

public class denomination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] den = {25,10,5,1};
		int n = 42;
		int count =0;
		for(int i=0;i<den.length;i++)
		{
			int k = n/den[i];
			n = n - k*den[i];
			count = count+k;
		}
		System.out.println(count);
	}

}
