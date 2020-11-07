package com.ds.companies.amazon.leetcode;

import java.util.HashMap;

public class FindTheHighestProfit {

	public int max_profit(int[] inventory, int orders) {
		// create map with inventory value and no of occurrences in map i.e if there are 2 items of stock 10,10 map will be 10,2
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int i : inventory) {
			hm.put(i, hm.getOrDefault(i, 0) + 1);
		}
		// find the maximum value in map. avoid sort so that we can achieve solution in O(n)
		// we know that after each item is purchased profit is going to reduce by cut_item-1
		int cur_max = Integer.MIN_VALUE;
		for (int i : hm.keySet()) {
			cur_max = Math.max(cur_max, i);
		}
		System.out.println(cur_max);
		int profit = 0;
		while (orders > 0) {
			// get the no of items in stock for cur_max inventory
			int no_items = Math.min(orders, hm.get(cur_max));
			profit += no_items * cur_max; // calculate current profit
			orders -= no_items; // reduce no of items to order still

			// we know for when we order next item it's price is going to drop by 1
			// if there is entry in map then update the map value with no of items. if not create new entry
			// if no items are left in stock for max_profit inventory item. remove the entry from map and reduce the profit by 1
			hm.remove(cur_max);
			hm.put(cur_max - 1, hm.getOrDefault(cur_max - 1, 0) + no_items);
			cur_max--;
		}

		return profit;
	}

	public static void main(String[] args) {

		int[] inventory = {2, 5}; //{10,2,8,4,6};
		int order = 4; //20;
		FindTheHighestProfit f = new FindTheHighestProfit();
		int profit = f.max_profit(inventory, order);
		System.out.println("Total Profit is:  " + profit);
	}
}
