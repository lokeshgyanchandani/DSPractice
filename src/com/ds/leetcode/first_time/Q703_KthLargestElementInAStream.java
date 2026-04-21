package com.ds.leetcode.first_time;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Q703_KthLargestElementInAStream extends RuntimeException {

    private final PriorityQueue<Integer> pq;

    private final int k;

    public Q703_KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;

        List<Integer> list= new ArrayList<>();

        for(int i = 0; i < Math.min(k, nums.length); i++)
            list.add(nums[i]);

        this.pq = new PriorityQueue<>(list);

        for(int i = k; i < nums.length; ++i) {
            pq.offer(nums[i]);
            pq.poll();
        }
    }

    public int add(int val) {
        pq.offer(val);
        if(pq.size() > k) pq.poll();
        return pq.peek();
    }
}
