package com.ds.leetcode.first_time;

import java.util.*;

public class Q347_TopKFrequentElements {

	static int[] topKFrequentPriorityQueue(int[] nums, int k) {
		Map<Integer, Integer> counterMap = new HashMap<>();
		for (int num: nums) {
			int count = counterMap.getOrDefault(num, 0);
			counterMap.put(num, count + 1);
		}

		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
		for (Map.Entry<Integer, Integer> entry: counterMap.entrySet()) {
			pq.offer(entry);
			if (pq.size() > k) pq.poll();
		}

		int[] res = new int[k];
		int i = 0;
		while (!pq.isEmpty()) {
			res[i++] = pq.poll().getKey();
		}
		return res;
	}

	static int[] topKFrequentBucketSort(int[] nums, int k) {
		List<Integer>[] bucket = new ArrayList[nums.length + 1];
		Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

		for (int n : nums) {
			frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
		}

		for (int key : frequencyMap.keySet()) {
			int frequency = frequencyMap.get(key);
			if (bucket[frequency] == null) {
				bucket[frequency] = new ArrayList<>();
			}
			bucket[frequency].add(key);
		}

		List<Integer> res = new ArrayList<>();

		for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
			if (bucket[pos] != null) {
				res.addAll(bucket[pos]);
			}
		}
		return res.stream().mapToInt(i->i).toArray();
	}

	public static void main(String args[]) {

	}
}
