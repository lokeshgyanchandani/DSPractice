package listjava;

public class firstunique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcdbad";
		int count[] = new int[26];
		for(int i = 0;i < str.length();i++)
		{
			count[str.charAt(i)-'a']++;
		}
		for(int i =0;i<str.length();i++)
		{
			if((count[str.charAt(i)-'a'])==1)
			{
				System.out.println(str.charAt(i));
				System.out.println("index"+i);
				return;
			}
			
		}
		System.out.println("no");
		
	}

}
