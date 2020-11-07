package listjava;


public class permutationrec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String s = new String("abc");
		
			char[] str = s.toCharArray();
			char[] data = new char[3];
			permute(str,0,data);
	       				
	}
	
	public static void permute(char[] str, int n,char [] data)
	{
		if(n == str.length)
		{
				System.out.println(str);
		}
		
		for (int i=0; i< n+1;i++)
		{
			char temp;
			temp = str[n];
			str[n]=str[i];
			str[i] = temp;
			data[i]=str[i];
			permute(str,n+1,data);
			temp = str[n];
			str[n]=str[i];
			str[i] = temp;
		}
			 
			
		}
}


