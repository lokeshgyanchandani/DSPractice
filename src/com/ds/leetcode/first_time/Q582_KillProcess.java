package com.ds.leetcode.first_time;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q582_KillProcess {

	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

		Map<Integer, List<Integer>> parentChildMap = new HashMap<>();
		for (int i = 0; i < pid.size(); i++) {
			int parent = ppid.get(i);
			int child = pid.get(i);
			parentChildMap.putIfAbsent(parent, new ArrayList<>());
			parentChildMap.get(parent).add(child);
		}

		List<Integer> res = new ArrayList<>();
		res.add(kill);

		if (!parentChildMap.containsKey(kill))
			return res;

		dfsHelper(parentChildMap, res, kill);

		return res;
	}

	private void dfsHelper(Map<Integer, List<Integer>> parentChildMap, List<Integer> res, int parent) {
		if (!parentChildMap.containsKey(parent))
			return;

		for (int child: parentChildMap.get(parent)) {
			res.add(child);
			dfsHelper(parentChildMap, res, child);
		}
	}

	public static void main(String[] args) {
		Q582_KillProcess obj = new Q582_KillProcess();
	}
}
