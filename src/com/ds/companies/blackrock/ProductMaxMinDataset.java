package com.ds.companies.blackrock;

import java.util.*;

public class ProductMaxMinDataset {

	private static List<Long> maxMin(List<String> operations, List<Integer> x) {
		List<Long> results = new ArrayList<>();

		if (operations == null || operations.size() == 0 || x == null || x.size() == 0 ||
				operations.size() != x.size())
			return results;

		int size = operations.size();

		TreeMap<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < size; i++) {
			String operation = operations.get(i);
			int num = x.get(i);

			if (operation.equalsIgnoreCase("push")) {
				map.put(num, 1);
			}
			else if (operation.equalsIgnoreCase("pop")) {
				if (results.isEmpty())
					return results;
				else
					map.remove(num);
			}
			long currMin = map.firstKey();
			long currMax = map.lastKey();
			results.add(currMin * currMax);
		}
		return results;
	}

	public static void main(String[] args) {
		String[] operationsArr = new String[] {"push", "push"};
		List<String> operations = Arrays.asList(operationsArr);
		List<Integer> x = Arrays.asList(3, 2);
		System.out.println(maxMin(operations, x));
	}
}
