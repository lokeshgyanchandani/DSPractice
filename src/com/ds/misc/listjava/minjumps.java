package listjava;

import java.util.ArrayList;

public class minjumps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a ={1,3,5,8,9,2,6,7,6,8,9};
	
		int l = findmin(0,a.length-1,a);
		System.out.println(l);
	}
	public static int findmin(int start,int end,int [] a)
	{
		if(start==end)
		{
			return 0;
		}
		if (a[start] == 0)
		     return Integer.MAX_VALUE;
		
		int min =  Integer.MAX_VALUE;
		for(int j= start+1;j<=start+a[start]&&j<end;j++)
		{
			int jump = findmin(j,end,a);
			if(jump !=Integer.MAX_VALUE && jump+1<min)
				min = jump+1;
		}
		return min;
	}

}
