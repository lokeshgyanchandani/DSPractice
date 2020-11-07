package listjava;

import java.util.HashMap;

public class xor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int a[] = {1,2,4,2,4,6,8,7,3,5};
			int x=0;
			int y=0;
			int xor = 0;
			for(int i=0;i<a.length;i++)
			{
				xor = xor ^ a[i];
			}
			for(int i=1;i<=8;i++)
			{
				xor = xor ^ i;
			}
			
			int bit = (xor) &  ~(xor-1);
			System.out.println("bit" + bit);
			for(int i=1;i<=8;i++)
			{
				if((bit & i)== 0)
				{
					x = x ^ i;
				}
				else
					y =y ^ i;
					
			}
			
			for(int i=0;i<a.length;i++)
			{
				if((bit & a[i])== 0)
				{
					x = x ^ a[i];
				}
				else
					y =y ^ a[i];
					
			}
			System.out.println(x);
			System.out.println(y);
			
			
/*			HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
			for(int i =0;i<a.length;i++)
			{
				
				if(h.containsKey(a[i]))
						{
					        System.out.println(a[i]);
							System.out.println(h.get(a[i]));
							break;
						}
				else
					h.put(a[i],i);
						}*/
	}

}
