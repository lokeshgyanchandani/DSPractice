package com.ds.leetcode.first_time;

public class Q283_MoveZeroes {

    public void moveZeroesTwoPointers(int[] nums) {

        int z = 0;

        for (int nz = 0; nz < nums.length; nz++) {
            if (nums[z] == 0 && nums[nz] != 0) {
                int temp = nums[nz];
                nums[nz] = nums[z];
                nums[z] = temp;
            }

            if (nums[z] != 0) z++;
        }
    }

    public void moveZeroes(int[] nums) {

        int n = nums.length;
        int currentPointer = 0;

        for (int num: nums) {
            if (num != 0) nums[currentPointer++] = num;
        }

        while (currentPointer < n) nums[currentPointer++] = 0;
    }
}
