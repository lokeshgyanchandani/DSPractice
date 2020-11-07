package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Backtrack {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3};
		List<List<Integer>> a = subsets(nums);
		System.out.println(a.size());
		for (List x : a) {
			System.out.println(x);
		}
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);
		backtrack(list, new ArrayList<>(), nums, 0);
		return list;
	}

	private static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
		//if(tempList.size()==3)
		list.add(new ArrayList<>(tempList));
		for (int i = start; i < nums.length; i++) {
//			if(tempList.contains(nums[i]))
//				continue;
			tempList.add(nums[i]);
			backtrack(list, tempList, nums, i+1);
			tempList.remove(tempList.size()-1);
		}
	}
}