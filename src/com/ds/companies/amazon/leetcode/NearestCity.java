package com.ds.companies.amazon.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NearestCity {

	static HashMap<String, int[]> cm = new HashMap<>();
	static HashMap<Integer, List<String>> xm = new HashMap<>();
	static HashMap<Integer, List<String>> ym = new HashMap<>();

	static int getDistance(String a, String b) {
		return Math.abs(cm.get(a)[0] - cm.get(b)[0]) + Math.abs(cm.get(a)[1] - cm.get(b)[1]);
	}

	static List<String> nearestCity(String[] cities, int[] xs, int[] ys, String[] queries) {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < cities.length; i++) {
			cm.put(cities[i], new int[]{xs[i], ys[i]});

			//xlist
			List<String> cxlist = xm.getOrDefault(xs[i], new ArrayList<>());
			cxlist.add(cities[i]);
			xm.put(xs[i], cxlist);

			//ylist
			List<String> cylist = ym.getOrDefault(ys[i], new ArrayList<>());
			cylist.add(cities[i]);
			ym.put(ys[i], cylist);
		}

		//for loop for queries
		for (String query : queries) {
			//retrieve x and y
			int[] coo = cm.get(query);

			//get x distance
			List<String> xl = xm.get(coo[0]);
			int minDistance = Integer.MAX_VALUE;
			String minCity = "None";

			for (int j = 0; j < xl.size(); j++) {
				if (query.equals(xl.get(j))) {
					continue;
				}
				int distance = getDistance(query, xl.get(j));
				if (distance == minDistance) {
					if (xl.get(j).compareTo(minCity) < 0) {
						minCity = xl.get(j);
					}
				} else if (distance < minDistance) {
					minDistance = distance;
					minCity = xl.get(j);
				}
			}

			//get y distance
			List<String> yl = ym.get(coo[1]);
			for (int j = 0; j < yl.size(); j++) {
				if (query.equals(yl.get(j))) {
					continue;
				}
				int distance = getDistance(query, yl.get(j));
				if (distance == minDistance) {
					if (yl.get(j).compareTo(minCity) < 0) {
						minCity = yl.get(j);
					}
				} else if (distance < minDistance) {
					minDistance = distance;
					minCity = yl.get(j);
				}
			}
			result.add(minCity);
		}

		return result;
	}

	public static void main(String[] args) {
		String[] cities = {"c1", "c2", "c3"};
		int[] xs = {3, 2, 1};
		int[] ys = {3, 2, 3};
		String[] queries = {"c1", "c2", "c3"};
		System.out.println(nearestCity(cities, xs, ys, queries));

	}
}
