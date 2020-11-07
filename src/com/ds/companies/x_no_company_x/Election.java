package com.ds.companies.x_no_company_x;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Election {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = { "ashish", "Abhishek", "sikka", "amit", "ashish", "Abhishek", "sikka", "amit", "amit", "ashish" };
		HashMap<String, Integer> x = new HashMap<>();
		int max = 0;
		for (String z : a) {
			int count = 1;
			if (x.containsKey(z)) {
				count = x.get(z) + 1;
				x.put(z, count);
			} else {
				x.put(z, count);
			}
			if (max < count)
				max = count;
		}
		System.out.println(x);
		System.out.println(max);
		Iterator<Map.Entry<String, Integer>> i = x.entrySet().iterator();

		List<String> result = new ArrayList<>();
		while (i.hasNext()) {
			Map.Entry<String, Integer> pair = i.next();
			if (pair.getValue() == max)
				result.add(pair.getKey());

		}
		Collections.sort(result);
		System.out.println(result.get(0));

	}

}
