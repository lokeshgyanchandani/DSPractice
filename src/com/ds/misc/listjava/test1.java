package listjava;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {0};
		int k = countone(a,0,a.length-1);
		System.out.println(k);
	}
	public static int countone(int a[],int l,int h)
	{
		if(h >=l)
		{
			int mid = h+l/2;
			if (a[mid]==1)
			{
				if(mid == h || a[mid+1]==0)
					return mid+1;
				else
					return countone(a,mid+1,h);
			}
			else
				return countone(a,l,mid-1);
		}
		return 0;
		
	}

}
