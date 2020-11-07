package interview;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class Targetsum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 2, 3, 6, 4 ,1,7};
		int target = 7;
		List<List<Integer>> list1 = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<>();
		helper(0, 0, a, target, list, list1);
		System.out.println(list1);
		System.out.println("processors"+Runtime.getRuntime().availableProcessors());
	}

	private static void helper(int index, int sum, int[] a, int target,
			List<Integer> list, List<List<Integer>> list1)

	{
		if (sum == target) {
			System.out.println(sum);
			System.out.println(target);
			list1.add(new ArrayList<>(list));
			return;
		}
		if (sum > target)
			return;
		if (target < 0) {
			return;
		}
		if (index > a.length - 1) {
			return;
		}
		if(!list.contains(a[index]))
		{
		list.add(a[index]);
		helper(index, sum + a[index], a, target, list, list1);
		list.remove(list.size() - 1);
		}
		helper(index + 1, sum, a, target, list, list1);

	}

}
