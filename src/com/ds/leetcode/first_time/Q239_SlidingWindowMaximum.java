package com.ds.leetcode.first_time;

// Intuition and different approaches
// https://leetcode.com/problems/sliding-window-maximum/solutions/458121/java-all-solutions-b-f-pq-deque-dp-with-750vv

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class Q239_SlidingWindowMaximum {

    // Get TLE in LeetCode
    public int[] maxSlidingWindowPriorityQueue(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1]; // number of windows

        PriorityQueue<Integer> maxPQ = new PriorityQueue<>((i1, i2) -> (nums[i2] - nums[i1])); // stores values

        for (int i = 0; i < n; ++i) {
            int start = i - k;
            if (start >= 0) {
                maxPQ.remove(start); // remove the out-of-bound value
            }
            maxPQ.offer(i);
            if (maxPQ.size() == k) {
                result[i - k + 1] = nums[maxPQ.peek()];
            }
        }
        return result;
    }

    /*
        Create a dequeue, push max on top
        If last bottom less than curr, keep on poping it
        Add current to end
        If top index - i >k pop it
        Maxima[i] = dequeue top
     */
    public int[] maxSlidingWindowDeque(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1]; // number of windows

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; ++i) {
            // Remove indices that are out of bound
            while (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.poll();
            }

            // Remove indices whose corresponding values are less than nums[i]
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // Add nums[i]
            deque.offerLast(i);

            // Add to result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Q239_SlidingWindowMaximum obj = new Q239_SlidingWindowMaximum();

        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        System.out.println(Arrays.toString(obj.maxSlidingWindowDeque(nums, k)));
    }
}
