package miscellaneous;

public class UniquePath {

	public static void main(String[] args) {
		int[] a = { 1, 2, 6, 5, 3, 4};
		int ans = findKthLargest(a, 2);
		System.out.println(ans);
	}

public static int findKthLargest(int[] nums, int k) {
        
        if (k < 1 || nums == null) {
		return 0;
	}
        int size = nums.length - 1;
        helper(0,size,nums,nums.length-k); 
        return nums[nums.length-k];
        
        
    }
    
    public static void helper(int low,int high,int[] a,int k)
    {
    	//System.out.println(low);
    	//System.out.println(high);
        if(low <= high)
		{
		int partition = findelement(a,low,high); 
		for(int i:a)
		{
			System.out.print(i);
		}
		System.out.println();
		if (partition == k)
		{
		    return;
		}
		
		else if(partition > k)
		 helper(low,partition-1,a,k);
		else 
		  helper(partition+1,high,a,k);
		}
		
    }
    public static int findelement(int[] a,int start,int end)
    {
        int pivot = end;
        int wall =start;
        for(int i= start;i<end;i++)
            {
                if(a[i]<a[pivot])
                {
                    int temp = a[wall];
                    a[wall] = a[i];
                    a[i] = temp;
                    wall++;
                }
            }  
            
             int temp = a[wall];
             a[wall] = a[pivot];
             a[pivot] = temp;
             
             return wall;
        }
}
