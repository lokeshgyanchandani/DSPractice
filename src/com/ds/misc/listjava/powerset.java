package listjava;

import java.util.ArrayList;

public class powerset {
	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		list = permutation(list1, 0);
		for (ArrayList<Integer> s : list) {
			// System.out.println("ashish");
			for (int i : s) {
				System.out.print(i + ",");
			}
			System.out.println();

		}
	}

	public static ArrayList<ArrayList<Integer>> permutation(ArrayList<Integer> list, int index) {
		ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
		if (list.size() == index) {
			moresubsets.add(new ArrayList<Integer>()); // Empty set

		} else {
			int x = list.get(index);

			moresubsets = (permutation(list, index + 1));
			ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> set : moresubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(set); //
				newsubset.add(x);
				allsubsets.add(newsubset);

			}
			moresubsets.addAll(allsubsets);
		}
		return moresubsets;
	}

}
