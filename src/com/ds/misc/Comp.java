package miscellaneous;

import java.util.*;

public class Comp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 3, 30, 34,5,9};
		Integer A[] = new Integer[a.length];
		for (int i = 0; i < a.length; i++) {
			A[i] = Integer.valueOf(a[i]);
		}
		Arrays.sort(A, new x());
		StringBuilder builder = new StringBuilder();
		for (int i : A) {
			builder.append(i);
		}
		System.out.println(builder.toString());
	}
}

class x implements Comparator<Integer>
{

	@Override
	public int compare(Integer o1,Integer o2) {

		String x = String.valueOf(o1) + String.valueOf(o2);
		String xy = String.valueOf(o2) + String.valueOf(o1);

		return Integer.valueOf(xy) - Integer.valueOf(x);
	}

}
