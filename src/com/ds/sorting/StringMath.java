package sorting;

public class StringMath {
	static int a = 5;
	int b;
	int c;
	public StringMath(int a,int b) {
		b =a;
		c = b;
	}
	public void print()
	{
		System.out.println(a+this.b+c);
	}
	
	public static void main(String[] args) {
		
		StringMath v = new StringMath(1, 2);
		v.print();
		
		// TODO Auto-generated method stub
		String a = "*dgj*hjk*n***s*";
		String[] arr = a.split("\\*");
		StringBuilder builder = new StringBuilder();
		for (String i : arr)
		{
			if(i.length()>2)
			{
				for(int j =1;j<i.length()-1;j++)
					builder.append(i.charAt(j));
			}
		}
		System.out.println(builder.toString());
		int prev =0;
		while(a.charAt(prev)=='*')
		{
			prev++;
		}
		System.out.println(prev);
	}
}
