package com.ds.leetcode.first_time;

public class Q134_GasStation {

	static int canCompleteCircuit(int[] gas, int[] cost) {
		assert gas != null && cost != null && gas.length == cost.length;

		int start = 0, tank = 0, total = 0;
		for (int station = 0, count = gas.length; station < count; station++) {
			int fuel = gas[station] - cost[station];
			tank += fuel;
			total += fuel;
			if (tank < 0) {
				tank = 0;
				start = station + 1;
			}
		}
		if (total < 0)
			return -1;
		else
			return start;
	}

	public static void main(String args[]) {
		int[] gas = new int[] {2, 3, 4};
		int[] cost = new int[] {3, 4, 3};
		System.out.println(canCompleteCircuit(gas, cost));
	}
}
