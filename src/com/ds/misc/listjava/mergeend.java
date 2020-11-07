package listjava;

public class mergeend {
	
	public static void merge(int a1 [], int a2 [],int n)
	{
		int i = n-1,j=n-1,k= 2*n-1;
		while(i !=-1 && j!=-1)
		{
			if (a1[i] > a2[j])
			{
				a2[k] = a1[i];
				k--;
				i--;
			}
			else
			{
				a2[k] = a2[j];
				k--;
				j--;
			}
		}
		if (i==-1)
		{
			while(j!=-1)
			{
				a2[k] = a2[j];
				k--;
				j--;
			}
		}
		if (j==-1)
		{
			while(i!=-1)
			{
				a2[k] = a1[i];
				k--;
				i--;
			}
		}
		for(i=0;i<2*n;i++)
		{
			System.out.println(""+a2[i]);
		}
	}
	
	public static void main(String[] args) {
		int a1 [] = {1,3,5,7,8};
		int a2 [] ={4,9,10,11,12,0,0,0,0,0};
		int n =5;
		merge(a1,a2,n);
		
	
	}

}
