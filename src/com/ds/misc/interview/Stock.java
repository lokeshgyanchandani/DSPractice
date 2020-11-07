package interview;

public class Stock {

	public static void main(String[] args) {
		int arr[] = { 12,11,13,9,12,8,14,13,15 };
		calculate(arr);
	}

	private static void calculate(int[] arr) {
		int min = Integer.MAX_VALUE;
		int profit[] = new int[arr.length];
		int maxprofit =0 ;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
			else
			{
			maxprofit = Math.max(maxprofit, arr[i] - min);
			}
			profit[i] = maxprofit;
		}
		System.out.println(maxprofit);
		for(int i : profit)
		{
			System.out.print(i+" ");
		}
		
		int max = Integer.MIN_VALUE;
		int profit1[] = new int[arr.length];
		maxprofit =0 ;
		for (int i = arr.length-1; i >0; i--) {
			if (arr[i] > max) {
				max = arr[i];
			}
			else
			maxprofit = Math.max(maxprofit, max-arr[i]+profit[i-1]);
			profit1[i] = maxprofit;
		}
		System.out.println(maxprofit);
		for(int i : profit1)
		{
			System.out.print(i+" ");
		}
	}
}
