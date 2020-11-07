package listjava;

import java.util.Arrays;

public class Daddy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int []a ={11,3,5,7,9,2,1,8};
		int []a = {25,-2,25,2,8,5,7};
		int[] k = calculate(a);
		for(int i:k)
		{
			System.out.println(i);
		}
	}

	private static int[] calculate(int[] a) {
		Arrays.sort(a);
		int i =0;
		int j = a.length -1;
		int k[] = new int[a.length];
		int l =0;
		while(i<=j)
		{
			k[l]=a[j];
			if(l<a.length-1)
			k[++l]=a[i];
			i++;
			j--;
			l++;
		}
		return k;
		
	}

}
