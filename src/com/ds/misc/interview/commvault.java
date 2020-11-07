package interview;

public class commvault {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = {-4,-1,-2,0,1,2,2,3,4};
		solve(a,4);
	}

	private static void solve(int[] a,int k) {
		int pos = 0;
		int neg = 0;
		int idlepos = k*(k+1)/2;
		int idleneg = -idlepos;
		int repeat = 0;
		int missing =0;
		
		for(int i=0;i<a.length;i++)
		{
			if(a[i]<0)
				neg = neg+a[i];
			else
				pos= pos+a[i];
		}
		if(pos == idlepos)
		{
			//processneg();
		}
		else if(pos == idleneg)
		{
			//processneg();
		}
		else
		{
			repeat = idleneg - neg;
			missing = pos - idlepos;
			System.out.println(repeat);
			System.out.println(missing);
		}
			
	}

}
