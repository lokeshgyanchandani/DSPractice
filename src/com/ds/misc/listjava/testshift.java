package listjava;

public class testshift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] ={1,2,0,0,4,5,0,7,8,0,0,9,0};
		int s =0;
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==0)
			{
				s++;
			}
			else
				a[i-s] = a[i];
		}
		while(s>0)
		{
			a[a.length -s]= 0;
			s--;
		}
		for(int j :a)
		{
		System.out.println(j);
		}
	}

}
