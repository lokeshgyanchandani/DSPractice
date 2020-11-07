package com.ds.companies.amazon.leetcode;

import java.util.*;

public class FetchItemsToDisplay {

	static List<String> fetchItemsToDisplay(int numOfItems, HashMap<String, int[]> items,
											int sortParameter, int sortOrder,
											int itemsPerPage, int pageNumber) {

		List<String> result = new ArrayList<>();
		//first create queue with comparator

		PriorityQueue<List<String>> pq = new PriorityQueue<>(new Comparator<List<String>>() {

			public int compare(List<String> a, List<String> b) {
				//ASCENDING
				if (sortOrder == 0) {
					if (sortParameter == 0)
						return a.get(sortParameter).compareTo(b.get(sortParameter));
					else
						return Integer.valueOf(a.get(sortParameter)) - Integer.valueOf(b.get(sortParameter));
				} else { //DESCENDING
					if (sortParameter == 0)
						return b.get(sortParameter).compareTo(a.get(sortParameter));
					else
						return Integer.valueOf(b.get(sortParameter)) - Integer.valueOf(a.get(sortParameter));
				}
			}
		});

		//ADD HASH MAPS KEY-VALUE AS LIST<STRING> INTO PRIORITY QUEUE
		for (Map.Entry<String, int[]> item : items.entrySet()) {
			pq.add(Arrays.asList(String.valueOf(item.getKey()), String.valueOf(item.getValue()[0]),
					String.valueOf(item.getValue()[1])));
		}

		if (pageNumber > 0) {
			int itemNumber = itemsPerPage * pageNumber;
			while (!pq.isEmpty() && itemNumber > 0) {
				pq.poll();
				itemNumber--;
			}
		}
		while (!pq.isEmpty() && itemsPerPage > 0) {
			result.add(pq.poll().get(0));
			itemsPerPage--;
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, int[]> items = new HashMap<>();
		items.put("item1", new int[]{10, 15});
		items.put("item2", new int[]{3, 4});
		items.put("item3", new int[]{17, 8});
		System.out.println(fetchItemsToDisplay(3, items, 1, 0, 2, 1));

	}
}
