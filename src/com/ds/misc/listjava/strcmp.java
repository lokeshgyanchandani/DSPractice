package listjava;

public class strcmp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "ash";
		String str2 = "ashish";
		int x = strcomp(str1,str2);
		System.out.println(x);
	}
	public static int strcomp(String str1, String str2)
	{
		char st1[] = str1.toCharArray();
		char st2[] = str2.toCharArray();
		int i =0;
		if(str1.length()<str2.length())
			return -1;
		while(i< str1.length())
		{
			if(str2.length()< i+1) return 1;
			if((str1.charAt(i)>(str2.charAt(i))))
					return 1;
			if((str2.charAt(i)>(str1.charAt(i))))
				return -1;
			i++;
		}
	
		return 0;
	}

}
