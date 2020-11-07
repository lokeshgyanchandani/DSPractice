package interview;

public class Per {

	public static void main(String[] args) {
		int a[] = {0,1,2,3};
		int result[] = new int[a.length];
		boolean used[] = new boolean[a.length];
		findPermute(0,a,result,used);
	}

	private static void findPermute(int index, int[] a, int[] result, boolean[] used)
	{
			if(index == a.length)
			{
				for(int i:result)
					System.out.print(i+" ");
				System.out.println();
				return;
			}
			for(int i=0;i<a.length;i++)
			{
				if(used[i]== true)
					continue;
				used[i]= true;
				result[index] = a[i];
				findPermute(index+1, a, result,used);
				used[i] = false;
			}
	}

}
