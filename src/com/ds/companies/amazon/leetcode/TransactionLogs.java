package com.ds.companies.amazon.leetcode;

import java.util.*;

public class TransactionLogs {

	public static List<String> distincUsersMeetingThreshold(List<String> logs, int threshold) {
		Map<String, Integer> userIdToCount = new HashMap<>();
		List<String> userIds = new ArrayList<>();

		for (String log : logs) {
			String[] transactionInfo = log.split(" ");
			String userId1 = transactionInfo[0];
			String userId2 = transactionInfo[1];

			int userCount1 = userIdToCount.getOrDefault(userId1, 0) + 1;
			userIdToCount.put(userId1, userCount1);
			if (userCount1 >= threshold && !userIds.contains(userId1))
				userIds.add(userId1);

			if (!userId1.equals(userId2)) {
				int userCount2 = userIdToCount.getOrDefault(userId2, 0) + 1;
				userIdToCount.put(userId2, userCount2 + 1);
				if (userCount2 >= threshold && !userIds.contains(userId2))
					userIds.add(userId2);
			}
		}

		Collections.sort(userIds, new Comparator<String>() {
			public int compare(String s1, String s2) {
				return Integer.valueOf(s1).compareTo(Integer.valueOf(s2));
			}
		});
		return userIds;
	}

	public static void main(String[] args) {

	}
}
