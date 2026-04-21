package com.ds.leetcode.first_time;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q253_MeetingRoomsII {

	public static int minMeetingRooms(int[][] intervals) {
		if (intervals == null || intervals.length == 0) return 0;

		// sort the meetings by their startTime
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
			}
		});

		PriorityQueue<Integer> rooms = new PriorityQueue<>();
		for (int[] interval: intervals) {
			int start = interval[0];
			// non overlapping      ==>     if startTime of next meeting is higher than endTime of prevMeeting
			if (!rooms.isEmpty() && start >= rooms.peek()) {
				rooms.remove();
				rooms.add(interval[1]);
			} else {
				rooms.add(interval[1]);
			}
		}
		return rooms.size();
	}

	public static void main(String[] args) {
		int[][] meetings = new int[][] {{0, 30}, {15, 20}, {5, 10}};
		System.out.println(minMeetingRooms(meetings));
	}
}
