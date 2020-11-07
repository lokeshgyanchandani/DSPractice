package com.ds.companies.facebook.leetcode;

import java.util.*;

public class TaskScheduler {

	static class TaskInfo implements Comparable<TaskInfo> {
		char c;
		int freq;

		TaskInfo(char c, int freq) {
			this.c = c;
			this.freq = freq;
		}

		public int compareTo(TaskInfo o) {
			if (freq >= o.freq)
				return -1;
			else
				return 1;
		}
	}

	private int leastInterval(char[] tasks, int n) {
		HashMap<Character, Integer> taskInfoMap = new HashMap<>();
		for (char task : tasks) {
			if (taskInfoMap.containsKey(task))
				taskInfoMap.put(task, taskInfoMap.get(task) + 1);
			else
				taskInfoMap.put(task, 1);
		}
		TreeSet<TaskInfo> taskInfoSet = new TreeSet<>();
		for (Map.Entry<Character, Integer> entry : taskInfoMap.entrySet()) {
			taskInfoSet.add(new TaskInfo(entry.getKey(), entry.getValue()));
		}
		int intervals = 0;
		while (!taskInfoSet.isEmpty()) {
			int i = 0;
			List<TaskInfo> temp = new ArrayList<>();
			while (i <= n) {
				if (!taskInfoSet.isEmpty()) {
					TaskInfo toRemove = taskInfoSet.pollFirst();
					if (toRemove.freq > 1)
						temp.add(new TaskInfo(toRemove.c, toRemove.freq - 1));
				}
				intervals++;
				if (taskInfoSet.isEmpty() && temp.isEmpty())
					break;
				i++;
			}
			taskInfoSet.addAll(temp);
		}
		return intervals;
	}

	public static void main(String args[]) {
		System.out.println(new TaskScheduler().leastInterval(new char[]{'A','B','C','A','A'}, 2));
	}
}
