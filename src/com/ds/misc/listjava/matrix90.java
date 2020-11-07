package listjava;

public class matrix90 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[][] a = new int[4][4];
		int[][] a = {{1,2,3,4},{5,6,7,8},{2,3,5,6},{3,4,8,9}};
		for(int i =0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}

	
	for(int i=0;i<4/2;i++)
	{
		int first = i;
		int last = 3-i;
		for(int j=first;j<last;++j)
		{
			int offset = j-first;
			int top = a[first][j];
			a[first][j]= a[last-offset][first];
			a[last-offset][first] = a[last][last-offset];
			a[last][last-offset]= a[j][last];
			a[j][last]=top;
		}
	}
	
	for(int i =0;i<4;i++)
	{
		for(int j=0;j<4;j++)
		{
			System.out.print(a[i][j] + " ");
		}
		System.out.println();
	}

}
}