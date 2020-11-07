package interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Dict {

	static Comparator<String> lenComparator = new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {

			return o1.length() - o2.length();
		}
	};

	public static void main(String[] args) {
		String[] arr = { "abde", "abe", "abd", "ac","a" };
		Arrays.sort(arr, lenComparator);
		
		HashMap<String,Integer> map = new HashMap<>();
		
		for(String str : arr)
		{
			if(str.length() ==1)
			{
				map.put(str, 1);
				continue;
			}
			
			int max =0;
			for(int j =0;j<str.length();j++)
			{
				String temp = str.substring(0,j)+str.substring(j+1);
				if(map.containsKey(temp))
				{
					max=  Math.max(max,map.get(temp)+1);
				}
			}
			map.put(str, max);
		}
		
		 Iterator it = map.entrySet().iterator();
		 	int max = 0;
		    while (it.hasNext()) {
		        Map.Entry entry = (Map.Entry)it.next();
		        if(max < (int)entry.getValue())
		        	max = (int)entry.getValue();
		    }
		    System.out.println(max);
	}


}
