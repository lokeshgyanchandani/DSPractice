package listjava;

public class maxarr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int [] a = {-11,-1,7,-6,7,-8};
			findsum(a);
	}
	public static void findsum(int[] a)
	{
		int len = a.length;
		int sumsofar = a[0];
		int summax = a[0];
		int j=0,k=0;
		int s=0;
		for(int i=0;i<len;i++)
		{
			sumsofar = sumsofar+a[i];
			if (sumsofar < a[i])
			{
				sumsofar = a[i];
				s=i;

			}
			
			if (sumsofar> summax)
			{	
				j=s;
				k=i;
				
				summax = sumsofar;
			}
				
		}
		System.out.println(summax);
		System.out.println(j + "&" + k);
		//System.out.println(sumsofar);
	}
}
