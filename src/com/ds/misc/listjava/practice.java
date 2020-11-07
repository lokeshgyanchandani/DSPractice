package listjava;

public class practice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str ="12**34***";
		char[] c = str.toCharArray();
		int i =0;
		int index =0;
		while(i<str.length())
		{
			if(str.charAt(i)!='*')
				index =i;
			
				i++;
		}
		if(str.charAt(index) =='*')
			System.out.println(-1);
		else
			System.out.println(index/2+1);
	}

}
