package listjava;

public class permutelast {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int []a ={1,2,3,4};
			int []b = new int[3];
			allpermutations(a,0,0,b,3);
	}

	public static void allpermutations(int[] a,int index,int start,int[] b,int k)
	{
		
		if(index==k)
		{
			for(int i:b)
			{
				System.out.print(i);
			}
			System.out.println();
			return;
			
		}
		else
		{
		
			for(int i=start;i<=a.length-1;i++)
			{
				boolean flag=false;
				for(int j=0;j<index;j++)
				{
					if (b[j]==a[i])
						flag = true;
				}
				if (flag!=true)
						{
				b[index]= a[i];
						
				allpermutations(a,index+1,start,b,k);}
						
			}
		}
		
	}
	
}

