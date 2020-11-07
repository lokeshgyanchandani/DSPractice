package listjava;

public class prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int [] A = {1,5,13,14,62};
		int [] B = {5,15,23,25,33,100};
/*			for(int i=0;i<a.length;i++)
			{
				for (int j= 0;j<b.length;j++)
				{
				if(i<j && a[i] > b[j])
					System.out.println("(" +a[i]+" , "+b[j]+ ")");
				}
			}*/
		int sum = 34;
		int i=0;
		int diff = 100;
		int j = B.length -1;
		int a_index =0;
		int b_index =0;
		int result =0;
	
		while(i<A.length-1 && j>=0)
		{
			if (Math.abs(A[i]+B[j]-sum)<diff)
			{
				diff = Math.abs(A[i]+B[j]-sum);
				a_index =i;
				b_index =j;
				result =Math.abs(A[i]+B[j]);
			}
			else if(A[i]+B[j]<sum)
				i++;
			else
				j--;
		}
		System.out.println(diff);
		System.out.println(a_index);
		System.out.println(b_index);
		System.out.println(result);
	}
}
