package listjava;

public class binarycount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,1,1,1,1,0,0};
		int low =0;
		int high = a.length-1;
		int count = countno(a,low,high);
		System.out.println(count);
	}
	public static int countno(int[] a, int l , int h)
	{
		int mid  = l+(h-l)/2;
		while(l<=h)
		{
			if(a[mid]==0)
			return countno(a,l,mid-1);
			else if(a[mid]==1)
				return mid-l+1+countno(a,mid+1,h);
		}
		return 0;
	}

}
