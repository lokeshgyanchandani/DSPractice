package listjava;

import java.util.ArrayList;

public class recur{

	public static void main(String[] args)
	{
		int[] a={1,2,3,4};
		
		printCombination(a,4,3);
		
	}
	public static void printCombination(int arr[] ,int n,int r)
	{
	int data[] = new int[r];
	printcomb(arr,data,0,n-1,0,r);
	}

	public static void printcomb(int arr[], int data[],int start, int end,int index,int r)
	{
	if(index == r)
	{
	for(int i =0; i<r;i++)
	    System.out.print(data[i]);
	System.out.println();
	return;
	}
	else
	{
	for(int i =start;i<=end;i++)
	{	boolean found = false;
	    if(index > 0 && arr[i]==data[index-1])
	    {found = true;}
	    if(!found)
	    {
	    data[index] = arr[i];
	    printcomb(arr,data,start,end,index+1,r) ;     
	    }
	    	 
	}
	}
	}
}
/*	
	public static void printCombination(int arr[], int n, int r)
	{
	    // A temporary array to store all combination one by one
	    int data[] = new int[r];
	 
	    // Print all combination using temprary array 'data[]'
	    combinationUtil(arr, data, 0, n-1, 0, r);
	}
	 
	public static void combinationUtil(int arr[], int data[], int start, int end, int index, int r)
	{
	    // Current combination is ready to be printed, print it
	    if (index == r)
	    {
	        for (int j=0; j<r; j++)
	            System.out.print(data[j]);
	        System.out.println();;
	        return;
	    }
	 
	    // replace index with all possible elements. The condition
	    // "end-i+1 >= r-index" makes sure that including one element
	    // at index will make a combination with remaining elements
	    // at remaining positions
	    for (int i=start; i<=end && end-i+1 >= r-index; i++)
	    {
	        data[index] = arr[i];
	        combinationUtil(arr, data, i+1, end, index+1, r);
	    }
	}
*/

