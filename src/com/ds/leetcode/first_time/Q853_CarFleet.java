package com.ds.leetcode.first_time;

import java.util.Map;
import java.util.TreeMap;

public class Q853_CarFleet {

	public int carFleet(int target, int[] pos, int[] speed) {
		//Map<Integer, Double> m = new TreeMap<>(Collections.reverseOrder());
		Map<Integer, Double> m = new TreeMap<>((a, b) -> b - a);
		for (int i = 0; i < pos.length; ++i)
			m.put(pos[i], (double)(target - pos[i]) / speed[i]);
		int res = 0; double cur = 0;
		for (double time : m.values()) {
			if (time > cur) {
				cur = time;
				res++;
			}
		}
		return res;
	}
}
