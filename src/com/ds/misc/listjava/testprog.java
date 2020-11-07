package listjava;

public class testprog {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] ={1,2,2,2,2,4,5,8,9};
		int k = a.length-1;
		int l1 = findleft(a,0,k,2);
		int l2 = findright(a,0,k,2);
		System.out.println(l1);
		System.out.println(l2);
	}
	
	public static int findleft(int[] a , int l, int h, int x)
	{
		int mid = (l+h)/2;
		while(l<h)
		{
			mid = (l+h)/2;
			if(a[mid]< x)
				l=mid+1;
			else
				h= mid-1;
		}
		return h;
	}
	public static int findright(int[] a , int l, int h, int x)
	{
		int mid = l +h/2;
		while(l<h)
		{
			mid = (l+h)/2;
			if(a[mid]>x)
				h=mid-1;
			else
				l= mid+1;
		}
		return h;
	}
}
