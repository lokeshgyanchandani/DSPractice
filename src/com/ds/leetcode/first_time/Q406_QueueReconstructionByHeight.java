package com.ds.leetcode.first_time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q406_QueueReconstructionByHeight {

	static int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, (a, b) -> (b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]));
		List<int[]> res = new ArrayList<>();
		for (int[] p : people) {
			res.add(p[1], p);
		}
		return res.toArray(new int[0][0]);
	}

	public static void main(String argsp[]) {

	}
}
