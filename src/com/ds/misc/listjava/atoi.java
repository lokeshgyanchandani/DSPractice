package listjava;

public class atoi {
	
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			//int [] a = {1,-12,2,4,-14,4,-6,7,9,-22,9,9,10,-30,10,11,-31,11,11,-1,11};
			int [] a = {2,3,7,5,9,1,12,6,10,15,8};
			atoif("123456");
		}
		
		public static void atoif(String n)
		{
		    int k=0;
		    
			for(int i=0;i< n.length();i++)
			{
				k=k*10+ n.charAt(i) -'0';
			}
			System.out.println(k);
		}
}