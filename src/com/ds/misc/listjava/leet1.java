package listjava;
import java.util.Arrays;
import java.util.Comparator;

class leetcomp implements Comparator<Integer>{
	
	public int compare(Integer a, Integer b) {
		int k = Integer.valueOf(String.valueOf(a) + String.valueOf(b));
		//System.out.println(k);
		int l = Integer.valueOf(String.valueOf(b) + String.valueOf(a));
		//System.out.println(l);
		return l-k;
	}
}

public class leet1 {

	public static void main(String[] args) {
		// TODO Ato-generated method stub
		Integer [] a = { 3, 30, 34, 5, 9 };
		Arrays.sort(a, new leetcomp());
		String s ="";
		for(Integer i :a)
		{
		 s=s+i;
		}
		System.out.println(s);
	}

}
