package com.ds.leetcode.first_time;

public class Q277_FindTheCelebrity {

	private boolean knows(int a, int b) {
		return true;
	}

	private boolean isCelebrity(int candidate, int totalPeople) {
		for (int i = 0; i < totalPeople; i++) {
			if (i == candidate) continue;      // Don't ask if they know themselves.
			if (knows(candidate, i) || !knows(i, candidate)) return false;
		}
		return true;
	}

	public int findCelebrity(int n) {
		int candidate = 0;
		for (int i = 0; i < n; i++) {
			if (knows(candidate, i))
				candidate = i;
		}
		return isCelebrity(candidate, n) ? candidate : -1;
	}

	public static void main(String[] args) {

	}
}
