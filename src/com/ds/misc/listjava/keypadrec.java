package listjava;

public class keypadrec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = {"abc","def","ghi"};
		char[] b = new char[3];
		findrec(a,b,0,3);

	}

	public static void findrec(String [] a, char[] b,int index,int len)
	{
		if(index==len)
		{
		    System.out.println(b);
			return;
		}
		
		
			for(int i =0;i<len;i++)
			{
				boolean flag=false;
				
				if(index>0)
				{
				for(int j=0;j<index;j++)
				{
					if(b[j]==a[0].charAt(i))
					{
						flag =true;
						break;
					}
						
				}
				}
				
				if(flag==false)
				{
				b[index] = a[0].charAt(i);
				findrec(a,b,index+1,len);
				}
				
			}
		
	}
		
}
