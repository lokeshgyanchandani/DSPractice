package listjava;

public class zeroend {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a ={1,2,3,4,5,6,7,8,9,10};
		for(int i =10;i>0;i--)
		{
			int j = (int) (Math.random() % (i));
			int temp = a[i-1];
			a[i-1]= a[j];
			a[j] =temp;
		}
		for(int i =0;i<10;i++)
					{System.out.println(a[i]);}
	}

	}
