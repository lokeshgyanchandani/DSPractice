package com.ds.array;

import java.util.HashSet;
import java.util.Set;

public class DeleteEvery3rdElement {

	static int findLastNumber(int N, int K) {
		Set<Integer> deleted = new HashSet<>();
		int current = 0;
		int counter = K;
		int previous = Integer.MIN_VALUE;

		while (deleted.size() != N - 1) {
			current = current % N + 1;
			if (!deleted.contains(current)) {
				counter--;
				if (counter != 0)
					previous = current;
				else {
					deleted.add(current);
					counter = K;
				}
			}
		}


		return previous;
	}

	public static void main(String args[]) {
		System.out.println(findLastNumber(10, 4));
	}
}
