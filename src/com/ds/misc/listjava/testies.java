package listjava;

public class testies {
			public static void main(String[] args) {
			// TODO Auto-generated method stub
			String a = "abcdef";
			char[] b = new char[3];
			findrec(a,b,0,3,6,0);

		}

		public static void findrec(String a, char[] b,int index,int len,int k,int low)
		{
			if(index==len)
			{
			    System.out.println(b);
				return;
			}
			else
			{
				for(int i =low;i<=k-len+index;i++)
				{
					b[index] = a.charAt(i);
					findrec(a,b,index+1,len,k,i+1);
				}
			}

}
}
