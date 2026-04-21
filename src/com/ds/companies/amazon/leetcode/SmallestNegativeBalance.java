package com.ds.companies.amazon.leetcode;

import java.util.*;

class debtRecord {
	String borrower = "";
	String lender = "";

	int amount = 0;

	debtRecord(String borrower, String lender, int amount) {
		this.borrower = borrower;
		this.lender = lender;
		this.amount = amount;
	}
}

public class SmallestNegativeBalance {

	static List<String> negativeAccounts(int numRows, int numCols, List<debtRecord> records) {
		if(numRows == 0 || records == null) return new ArrayList<>();

		Map<String, Integer> ledger = new HashMap<>();
		for(debtRecord r: records) {
			String b = r.borrower, l = r.lender;
			int amount = r.amount;
			ledger.put(b, ledger.getOrDefault(b, 0) - amount);
			ledger.put(l, ledger.getOrDefault(l, 0) + amount);
		}

		int min = Integer.MAX_VALUE;
		for (Map.Entry<String, Integer> entry: ledger.entrySet()) {
			min = Math.min(min, entry.getValue());
		}

		if (min >= 0)
			return new ArrayList<>(Collections.singletonList("Nobody has a negative balance"));

		List<String> res = new LinkedList<>();
		for (Map.Entry<String, Integer> entry: ledger.entrySet()) {
			if (entry.getValue() == min) {
				res.add(entry.getKey());
			}
		}

		Collections.sort(res);
		return res;
	}

	public static void main(String[] args) {

	}
}
