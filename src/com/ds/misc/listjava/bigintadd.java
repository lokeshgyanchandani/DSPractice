package listjava;

import java.util.ArrayList;
import java.util.Arrays;

public class bigintadd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> a1 = new ArrayList<Integer>(
				Arrays.asList(8, 9, 3, 4));
		ArrayList<Integer> a2 = new ArrayList<Integer>(
				Arrays.asList( 3, 9));
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		int i = a1.size() - 1;
		int j = a2.size() - 1;
		int d = i-j;
		if(d>0)
		{
			j=j+d;
			while(d>0)
		{
			a2.add(0,0);
			d--;
		}
		
		}
		for(Integer l : a2)
		{
			System.out.print(l);
		}
		int carry = 0;
		int sum = 0;
		while (i>=0 && j >= 0) {
			sum = carry +a1.get(i)+a2.get(j);
			
			carry = sum/10;
			sum = sum%10;
			a3.add(0,sum);
			i--;
			j--;
		}
		/*if(i==-1&&j!=0)
		{
			if(carry>0)
			{
			a3.add(0,a2.get(j)+carry);
			carry =0;
			j--;
			}
			while(j>=0)
			{
				a3.add(0,a2.get(j));
				j--;
			}
		}
		if(j==-1&&i!=0)
		{
			System.out.println("ash");
			if(carry>0)
			{
			a3.add(0,a1.get(i)+carry);
			carry =0;
			i--;
			}
			while(i>=0)
			{
				a3.add(0,a1.get(i));
				i--;
			}
		}*/
		if (carry>0)
		{
			a3.add(0,carry);
		}
for(Integer k : a3)
{
	System.out.print(k);
}
	}

}
