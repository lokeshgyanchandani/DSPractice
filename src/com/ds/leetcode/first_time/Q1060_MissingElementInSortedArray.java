package com.ds.leetcode.first_time;

public class Q1060_MissingElementInSortedArray {

	public int missingElement(int[] nums, int k) {
		// 0, 2, 3, 3
		// 0, 0, 1

		int len = nums.length;
		int missing = nums[len - 1] - nums[0] - (len - 1 - 0); // nums[b] - nums[a] - (index_b - index_a)

		if (k > missing)
			return nums[len - 1] + k - missing;

		int start = 0, end = len - 1;
		while (start < end) {
			int mid = start + (end - start) / 2;
			int newMissing = nums[mid] - nums[start] - (mid - start);

			if (start == end - 1) // necessary to avoid infinite loop since for neighbours (start, end)
				break;			  // the mid is always same as start, so newmissing will be 0

			if (k > newMissing) {
				k -= newMissing;
				start = mid;
			} else {
				end = mid;
			}
		}
		return nums[start] + k;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {4, 7, 9, 10};
		Q1060_MissingElementInSortedArray obj = new Q1060_MissingElementInSortedArray();
		System.out.println(obj.missingElement(nums, 1));
	}
}
