package listjava;

public class bucket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5,1,2,3,4,5,1,2,0,0,0};
		int bucket[] = new int[6];
		for(int i=0;i<=5;i++)
		{
			bucket[i] = 0;
		}
		for(int i = 0;i<arr.length;i++)
		{
			bucket[arr[i]]++;
		}
		int index =0;
		for(int i =0;i<=5;i++)
			for(int j=0;j<bucket[i];j++)
				arr[index++]=i;
		
		for(int i :arr)
			System.out.println(i);
	}

}
