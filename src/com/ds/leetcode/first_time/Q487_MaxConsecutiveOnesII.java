package com.ds.leetcode.first_time;

public class Q487_MaxConsecutiveOnesII {

    public int findMaxConsecutiveOnes(int[] nums) {
        int lastZeroIndex = -1, max = 0, startIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                startIndex = lastZeroIndex + 1;
                lastZeroIndex = i;
            }
            max = Math.max(max, i - startIndex + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        Q487_MaxConsecutiveOnesII obj = new Q487_MaxConsecutiveOnesII();

        int[] arr = new int[] {1,0,1,1,0,1};
        System.out.println(obj.findMaxConsecutiveOnes(arr));
    }
}
