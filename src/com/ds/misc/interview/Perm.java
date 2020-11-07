package interview;

import java.util.ArrayList;
import java.util.List;

public class Perm {

	public static void main(String[] args) {
		List<Integer> x = new ArrayList<>();
		int[] array = {1,2,3};
		boolean[] used = new boolean[3];
		helper(x,array,used);
	}

	public static void helper(List<Integer> temp, int[] nums, boolean[] used) {
		if (temp.size() == nums.length) {
			System.out.println(temp);
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (used[i] == true)
				continue;
			used[i] = true;
			temp.add(nums[i]);
			helper(temp, nums, used);
			used[i] = false;
			temp.remove(temp.size() - 1);
		}
	}

}
