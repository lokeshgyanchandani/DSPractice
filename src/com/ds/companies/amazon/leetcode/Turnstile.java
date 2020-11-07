package com.ds.companies.amazon.leetcode;

import java.util.*;

public class Turnstile {

	static int[] getTimes(int numCustomers, int[] arrTime, int[] direction) {
		Queue<Integer> entryQueue = new ArrayDeque<>();
		Queue<Integer> exitQueue = new ArrayDeque<>();

		Map<Integer, List<Integer>> timeCustomerMap = new HashMap<>();

		for (int i = 0; i < arrTime.length; i++) {
			List<Integer> customers = timeCustomerMap.getOrDefault(arrTime[i], new ArrayList<>());
			customers.add(i);
			timeCustomerMap.put(arrTime[i], customers);
		}

		int[] timeForEachCustomer = new int[numCustomers];
		int total = 0;
		Integer prev = null;
		int time = 0;
		while (total != numCustomers) {

			List<Integer> cust = timeCustomerMap.getOrDefault(time, new ArrayList<>());
			if (cust.size() > 0) {
				for (int i : cust) {
					if (direction[i] == 0) {
						entryQueue.add(i);
					} else if (direction[i] == 1) {
						exitQueue.add(i);
					}
				}
			}

			boolean turnstileUsed = false;
			// priority check
			if (prev == null || prev == 1 || entryQueue.isEmpty()) {
				if (!exitQueue.isEmpty()) {
					timeForEachCustomer[exitQueue.poll()] = time;
					prev = 1;
					turnstileUsed = true;
				}
			}
			if (!turnstileUsed) {
				if (!entryQueue.isEmpty()) {
					timeForEachCustomer[entryQueue.poll()] = time;
					prev = 0;
					turnstileUsed = true;
				}
			}

			if (!turnstileUsed) {
				prev = null;
			} else {
				total += 1;
			}

			time += 1;
		}

		return timeForEachCustomer;
	}

	public static void main(String[] args) {
		int customers = 7;
		int[] times = new int[]{0, 0, 0, 0, 1, 1, 1};
		int[] directions = new int[]{0, 1, 1, 0, 1, 0, 1};
		System.out.println(Arrays.toString(getTimes(customers, times, directions)));
	}
}
