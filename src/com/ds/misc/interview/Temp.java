package interview;

import java.util.ArrayList;
import java.util.List;

public class Temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] x = { "aA", "bB", "cC" };
		List<String> list = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		list.add("");
		for (int i = 0; i < x.length; i++) {
			String a = x[i];
			temp = new ArrayList<>();
			for (int j = 0; j < a.length(); j++) {
				
				for(String z:list)
				{
					String u = z + a.charAt(j);
					temp.add(u);
				}
			}
				list = temp;
			
		}
		System.out.println(list);
	}

}
