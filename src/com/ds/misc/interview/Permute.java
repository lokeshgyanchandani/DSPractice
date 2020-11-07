package interview;

import java.util.ArrayList;

public class Permute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = { 1, 2, 3 };
		boolean used[] = new boolean[num.length];
		ArrayList<Integer> x = new ArrayList<>();
		permutation(num, used, x);

	}

	private static void permutation(int[] num, boolean[] used,
			ArrayList<Integer> list) {
		if (list.size() == num.length) {
			for (int i : list)
				System.out.print(i + " ");
			System.out.println();
		} else {
			for (int i = 0; i < num.length; i++) {
				if (used[i])
					continue;
				used[i] = true;
				list.add(num[i]);
				permutation(num, used, list);
				used[i] = false;
				list.remove(list.size() - 1);
			}
		}
	}

}
