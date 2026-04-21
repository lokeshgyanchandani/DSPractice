package com.ds.leetcode.first_time;

public class Q33_SearchInRotatedArray {

	public static int search(int[] nums, int target) {
		int pivot = findPivot(nums);
		System.out.println(pivot);

		if (pivot == -1)
			return binarySearch(nums, 0, nums.length - 1, target);

		if (nums[pivot] == target)
			return pivot;
		else if (nums[0] <= target)
			return binarySearch(nums, 0, pivot - 1, target);
		else
			return binarySearch(nums, pivot, nums.length - 1, target);
	}

	private static int findPivot(int[] nums) {
		int start = 0, end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (mid > 0 && nums[mid] < nums[mid - 1])
				return mid;
			else if (nums[mid] > nums[end])
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}

	private static int binarySearch(int[] nums, int start, int end, int target) {
		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < target)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = new int[] {1, 3};
		System.out.println(search(nums, 1));
	}
}
