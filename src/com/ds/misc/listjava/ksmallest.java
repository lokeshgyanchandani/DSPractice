package listjava;

public class ksmallest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {1,-12,2,4,-14,4,-6,7,9,-22,9,9,10,-30,10,11,-31,11,11,-1,11};
		//int [] a = {2,3,7,5,9,1,12,6,10,15,8};
		int high = (a.length);
		int low = 0;
		quicksort(low,high-1,a,8);
		for(int i=0;i<high;i++)
	    {
	    System.out.println(a[i] + " ");
		}
	}
	
	public static void quicksort(int low,int high,int []a,int k)
	{
		if(low <= high)
		{
		int partition = findelement(a,low,high); 
		if (partition == k)
		{
			for(int i=0;i<k;i++)
			{ 
		System.out.println("element smallest\t"+a[i]);
		}
		}
		else if(partition > k)
		quicksort(low,partition-1,a,k);
		else 
		quicksort(partition+1,high,a,k);
		}
		//System.out.println(partition);
		
	}
	public static int findelement(int[] a,int low,int high)
	{
		int pivot = high;
		int wall = low;
		
		for(int i=low;i<high;i++)
		{
			if(a[i] < a[pivot])
			{
				int temp= a[wall];
				a[wall]= a[i];
				a[i]=temp;
				wall++;
			}
		}
			int k = a[pivot];
			a[pivot]= a[wall];
			a[wall]= k;
			return wall;
	}
}




