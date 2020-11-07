package com.ds.misc.listjava;

public class testing {


	public static void main(String[] args) {
	String str1 = "ashish";
	String str2 = "aaaaaa";
	int [] count = new int [26];

	if(str1.length()!=str2.length())
	{
	System.out.println("not anagram");
	return;
	}
	else
	{ int i =0;
		while(i<str1.length())
		{
			count[str1.charAt(i)-'a']++;
			count[str2.charAt(i)-'a']--;
			i++;
		}
	}
		for(int i=0;i<str1.length();i++)
		{
			if(count[str1.charAt(i)-'a']!=0)
			{
				System.out.println("not anagram");
				return;
			}

		}
		System.out.println("anagram");
	}


	/*public static void main(String[] args) {

		int a =5;
		fact(a);
	}
	public static void fact(int a)
	{
		for(int i =1;i<=10;i++)
		{
			System.out.println(a+ "*"+i +"="+a*i);
		}
	}
	/*	int[] a = {1,1,2,3,4,5,7,8,8,10};

		        int i = 0;
				int j = 9;
				int flag =0;
				while(i < j){
				   if(a[i] + a[j] == 9)
				   { System.out.println(a[i]+" "+a[j]);
				   flag =1;
				   	i++;}
				   else if (a[i] + a[j] <  9) i += 1;
				   else if (a[i] + a[j] >  9) j -= 1;
				}
				if(flag==0)
				System.out.println(0);
	}
	/*	Character hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		String binary[]={"0000","0001","0010","0011","0100","0101","0111","1000","1001","1010","1111"};
		String str = "000";
		StringBuffer str1 =new StringBuffer();
		int i =0;
		while(i<str.length())
		{
		switch(str.charAt(i)){
        case '0': str1 = str1.append("0010"); break;

        default:  System.out.println("\nInvalid hexadecimal digit"+str.charAt(i)); return;
}
		i++;
		}
		System.out.println(str1);
		}*/



	}
