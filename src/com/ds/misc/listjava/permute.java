package listjava;

import java.util.ArrayList;

public class permute {

	public static void main(String[] args)
	{
		String str ="abcd";
		
		ArrayList<String> list = new ArrayList<String>();
		list = permutation(str);
		for(String s:list)
		{
			
			System.out.println(s);
		}
	}
	
	public static ArrayList<String>
	permutation(String s)
	{
		//ArrayList<String> set = new ArrayList<String>();
		//if(s==null) return null;
		ArrayList<String> set1 = new ArrayList<String>();
		
	    if(s.length()==0)
	    {
	    	set1.add("");
	    	return set1;
	    }
	   
	    	char c = s.charAt(0);
	    	String rem = s.substring(1);
	    	ArrayList<String> set = permutation(rem);
	    	
	    	for(String str : set)
	    	{
	    		for(int i=0;i<=str.length();i++)
	    		{
	    		String newstr = add(str,c,i);
	    		set1.add(newstr);
	    		}
	    	}
	    
	    return set1;
	}
	
	public static String add(String s,char c,int i)
	{
		String s1 = s.substring(0,i);
		String s2 = s.substring(i);
		return s1+c+s2;
		
	}
}
