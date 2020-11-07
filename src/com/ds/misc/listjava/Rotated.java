package listjava;

import java.util.*;

public class Rotated {
public static void main(String[] agrs)
{
	int [] a = {20,21,23,50,2,4,5,6,8,9,10,13,15};
	int low=0;
	int high = a.length -1 ;
	int k = findsmallest(a,low,high,21);
	System.out.println(k);
}
static int findsmallest(int[] a, int low,int high,int k)
{   
	int mid;
	while (low<=high)
	{
		if (low == high)
			return low;
		mid = (low+high)/2;
		if (k==a[mid])
		{
			System.out.println("Ashish");
			return mid;	
		}
			
		else if(a[mid] < a[high])
		{
			if ((k>a[mid])&& (k<a[high]))
			low = mid+1;
			else 
			high = mid-1;
		}
		else 
		{
			if ((k<a[mid])&&(k>a[low]))
			high = mid-1;
			else
		    low = mid+1;
		}
	}
	return 0;
}
}