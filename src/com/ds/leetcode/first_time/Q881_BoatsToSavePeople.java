package com.ds.leetcode.first_time;

import java.util.Arrays;

public class Q881_BoatsToSavePeople {

	public int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);

		if (people[people.length - 1] > limit)
			return -1;

		int boats = 0;

		int left = 0, right = people.length - 1;
		while (left < right) {
			if (people[right] > limit)
				return -1;
			else if (people[left] + people[right] <= limit) {
				left++;
				right--;
				boats++;
			}
			else if (people[right] <= limit) {
				right--;
				boats++;
			}
		}

		if (left == right)
			boats++;

		return boats;
	}

	public static void main(String[] args) {
		Q881_BoatsToSavePeople obj = new Q881_BoatsToSavePeople();
		int[] people = new int[] {3,5,3,4};
		int limit = 5;
		System.out.println(obj.numRescueBoats(people, limit));
	}
}
