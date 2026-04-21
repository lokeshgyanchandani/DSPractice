package com.ds.leetcode.first_time;

import java.util.Arrays;
import java.util.Comparator;

public class Q252_MeetingRoomsI {

	public static boolean canAttendMeetings(int[][] meetings) {
		if (meetings.length == 0) throw new IllegalArgumentException();

		Arrays.sort(meetings, new IntervalComparator());

		int prevEndTime = -1;
		for (int[] meeting: meetings) {
			if (meeting[0] < prevEndTime)
				return false;
			prevEndTime = meeting[1];
		}

		return true;
	}

	public static void main(String[] args) {
		int[][] meetings = new int[][] {{0, 30}, {5, 10}, {15, 20}};
		System.out.println(canAttendMeetings(meetings));
	}
}

class IntervalComparator implements Comparator<int[]> {

	public int compare(int[] a, int[] b) {
		if (a[0] == b[0]) return a[1] - b[1];
		return a[0] - b[0];
	}
}
