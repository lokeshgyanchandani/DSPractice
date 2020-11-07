package listjava;

public class unique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "ab cc d ";
		uniquef(str);
	}
	public static void uniquef(String s)
	{
		int count=0;
		char [] c = s.toCharArray();
		int len = c.length;
		for(int i=0;i<c.length ;i++)
		{
			if (c[i]==' ')
				count++;
		}
		int newlen = len+2*count;
		char[] c1 = new char[newlen];
		System.out.println(c1.length);
		for(int i=len-1;i>=0;i--)
		{
			if(c[i]==' ')
			{
				c1[newlen-1]= '0';
				c1[newlen-2]= '2';
				c1[newlen-3]= '%';
				newlen = newlen-3;
			}
			else
			{
				c1[newlen-1] = c[i];
				newlen= newlen-1;
			}
		}
		for(int i=0;i<c1.length;i++)
		{
			System.out.print(c1[i]);
		}
	}

}
