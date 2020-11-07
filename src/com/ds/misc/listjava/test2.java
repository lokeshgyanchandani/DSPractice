package listjava;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar1[] = { 1, 4, 5, 7 };
		int ar2[] = { 10, 20, 30, 40 };
		int x = 29;
		int i = 0;
		int min = Integer.MAX_VALUE;
		int sum = 0;
		int start = 0;
		int end = 0;
		int j = ar2.length - 1;
		while (i < ar1.length && j >= 0) {
			sum = ar1[i] + ar2[j];
			if (Math.abs(sum - x) < min) {
				min = Math.abs(sum - x);
				start = ar1[i];
				end = ar2[j];

			}
			if (sum > x) {
				j--;
			} else
				i++;
		}
		System.out.println(min);
		System.out.println(start);
		System.out.println(end);
	}

}
