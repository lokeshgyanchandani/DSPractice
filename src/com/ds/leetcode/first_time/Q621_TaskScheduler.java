package com.ds.leetcode.first_time;

public class Q621_TaskScheduler {

	static int leastInterval(char[] tasks, int n) {
		int[] counter = new int[26];
		int max = 0, maxCount = 0;
		for (char task : tasks) {
			counter[task - 'A']++;
			if (max < counter[task - 'A']) {
				max = counter[task - 'A'];
				maxCount = 1;
			} else if (max == counter[task - 'A'])
				maxCount++;
		}
		int partCount = max - 1;
		int emptySlots = partCount * (n - (maxCount - 1));
		int availableTasks = tasks.length - max * maxCount;
		int idles = Math.max(0, emptySlots - availableTasks);
		return tasks.length + idles;
	}

	public static void main(String args[]) {
		System.out.println(leastInterval(new char[] {'A', 'A', 'A', 'B', 'B', 'B', 'C'}, 2));
	}
}
