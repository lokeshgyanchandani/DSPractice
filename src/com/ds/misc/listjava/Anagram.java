package listjava;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.Set;

class Anagramcomparator implements Comparator<String>{
					
					public String sortChars(String str) {
					char[] content = str.toCharArray();
						 Arrays.sort(content);
						 return new String(content);

					}
						 
						 public int compare(String s1, String s2) {
						 return sortChars(s1).compareTo(sortChars(s2));
						 }

				}

public class Anagram
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] str = {"aabbcc" ,"bbaacc"};
		Arrays.sort(str,new Anagramcomparator());
		
		for(int i=0;i<str.length;i++)
		{
			System.out.println(str[i]);
		}	
		
//		for(int i=0;i<str.length;i++)
//		{	char[] word = str[i].toCharArray();
//			Arrays.sort(word);
//			str[i] = new String(word);
//		System.out.println(str[i]);
//		}
//		
//		Hashtable<String, Integer> number = new Hashtable<String, Integer>();
//		for(int i=0;i<str.length;i++)
//		{
//			if(number.containsKey(str[i]))
//			{
//			//System.out.println("Ashish");	
//			int k = number.get(str[i]);
//			
//			number.put(str[i],++k);
//			}
//			else
//			{
//			number.put(str[i],1);	
//			}
//		}
//		
//		Set<String> s = number.keySet();	
//		for (String k : s)
//		{
//			System.out.println(k+number.get(k));
//		}
}
}