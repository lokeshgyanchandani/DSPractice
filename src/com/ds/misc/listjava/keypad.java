package listjava;

import java.util.ArrayList;

public class keypad {

	
		public static void main(String[] args) {
		// TODO Auto-generated method stub
			ArrayList<String> x = new ArrayList<String>();
			x.add("a");
			x.add("b");
			x.add("c");
			x.add("d");
			ArrayList<String> y =new ArrayList<String>();
			y.add("");
			for(String i:x)
			{
				ArrayList<String> z = new ArrayList<String>();
				for(int j = 0;j<i.length();j++)
				{
					for(String k:y)
					{
						String g1 = new String( k + i.charAt(j));
						z.add(g1);
						if(k!="")
						{
						String g2= new String( k + " "+i.charAt(j));
						z.add(g2);
						}
					}
				}
				y=z;
			}
			
			for(String l :y)
			{
				System.out.println(l);
			}
	}

}
