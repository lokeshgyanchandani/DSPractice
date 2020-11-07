package listjava;

public class reversewords {
				public static void main(String[] args) {
				// TODO Auto-generated method stub
				String str = "Dont let anyone steal your dream";
				char [] c = str.toCharArray();
				char [] newc = reverse(c,0,c.length-1);
				for (int i = 0; i<newc.length;i++)
				{
					System.out.print(newc[i]);
				}
				System.out.println();
				int j =0;
				for(int i=0;i< newc.length;i++)
				{
					if (newc[i]==' ')
		    	    {
						char[] st =reverse (newc,j,i-1);
						j= i+1;
					}
					else if(i==newc.length-1)
					{
						char[] st1 =reverse(newc,j,i-1);	
					}
				}
				for (int i = 0; i<newc.length;i++)
				{
					String t = " a  b ";
					t.trim();
					String st[]= t.split(" ");
					for(String k :st)
					{
						System.out.println(k);
					}
					//System.out.println("ash"+t.trim());
					//System.out.print(newc[i]);
				}
			}
			
			public static char[] reverse(char[] c, int low, int high)
			{
			    while(low<high)
			    {
			    	char temp = c[low];
			    	c[low]=c[high];
			    	c[high] = temp;
			    	low++;
			    	high--;
			    }
				return c;
			}
			
			
	}

