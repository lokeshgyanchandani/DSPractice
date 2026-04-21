package com.ds.leetcode.first_time;

import java.util.*;

public class Q752_OpenTheLock {

	private static final String START = "0000";

	public int openLock(String[] deadends, String target) {
		if (target == null || target.length() == 0) return -1;
		Set<String> visited = new HashSet<>(Arrays.asList(deadends));
		Queue<String> queue = new LinkedList<>();
		int level = 0;
		queue.offer(START);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String currentLock = queue.poll();
				if (!visited.add(currentLock)) continue;
				if (currentLock.equals(target)) return level;

				for (String nextLock : getNextStates(currentLock)) {
					if (!visited.contains(nextLock)) queue.offer(nextLock);
				}
			}
			level++;
		}

		return -1;
	}

	private List<String> getNextStates(String lock) {
		List<String> locks = new LinkedList<>();
		char[] arr = lock.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			arr[i] = c == '9' ? '0' : (char) (c + ((char) 1));
			locks.add(String.valueOf(arr));
			arr[i] = c == '0' ? '9' : (char) (c - ((char) 1));
			locks.add(String.valueOf(arr));
			arr[i] = c;
		}
		return locks;
	}

	public static void main(String[] args) {
		Q752_OpenTheLock obj = new Q752_OpenTheLock();

		String[] deadends = new String[] {"0201","0101","0102","1212","2002"};
		String target = "0202";
		obj.openLock(deadends, target);
	}
}
