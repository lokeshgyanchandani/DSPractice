package listjava;

public class duplicates {

	public static int findfirstleft(int [] a, int key, int start,int end)
	{
		if (start>end)
		return start;
	
	    int mid = (start+end)/2;
	
	    if(a[mid]< key)
	    {
	    	return findfirstleft(a,key,mid+1,end);
	    }
	    else
	    	return findfirstleft(a,key,start,mid);
	
	}
	
    public static int findlastright(int [] a,int key , int start,int end)
	{
		
		if (start>end)
			return start-1;
		
		int mid =(start+end)/2;
		
		if(a[mid]> key)
		{
			return findlastright(a,key,start,mid-1);
		}
		else
			return findlastright(a,key,mid,end);
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//int [] a = {1,2,2,4,4,4,6,7,9,9,9,9,10,10,10,11,11,11,11,11,11};
	int [] a ={1,2,3};
	int n = (a.length)-1;
	int start = 0;
	int key=3;
	int i = findfirstleft(a,key,start,n);
	int j = findlastright(a,key,start,n);
    System.out.println("value of starting index= "+i);
    System.out.println("value of ending index= "+j);
    System.out.println("no of duplicate elements= "+ (j-i));
	}
	
	

}

