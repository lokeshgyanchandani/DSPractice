package com.ds.leetcode.first_time;

public class Q215_KthLargestElementInArray {

	static int findKthLargest(int[] nums, int K) {
		int len = nums.length;
		if (K < 1 || len == 0) { return -1; }

		int l = 0, r = len - 1;
		while (l <= r) {
			int mid = partition(nums, l , r);
			if (mid == len - K) break;
			else if (mid < len - K) l = mid + 1;
			else r = mid - 1;
		}
		return nums[len - K];
	}

	static int partition(int[] nums, int l, int r) {
		int pivot = nums[l];
		while (l < r) {
			while (l < r && nums[r] >= pivot) r--;
			nums[l] = nums[r];
			while (l < r && nums[l] <= pivot) l++;
			nums[r] = nums[l];
		}
		nums[l] = pivot;
		return l;
	}

	public static void main(String args[]) {
		System.out.println(findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
	}
}
