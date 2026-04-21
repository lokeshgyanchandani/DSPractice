package com.ds.leetcode.first_time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q1431_KidsWithTheGreatestNumberOfCandies {

	public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
		int max = 1;
		for (int candy: candies)
			max = Math.max(max, candy);

		List<Boolean> res = new ArrayList<>(candies.length);
		for (int candy: candies)
			res.add(candy + extraCandies >= max);

		return res;
	}

	public List<Boolean> kidsWithCandiesMinorOptimization(int[] candies, int extraCandies) {
		int max = 1;
		for (int candy: candies)
			max = Math.max(max, candy);

		max -= extraCandies;
		List<Boolean> res = new ArrayList<>(candies.length);
		for (int candy: candies)
			res.add(candy>= max);

		return res;
	}

	public List<Boolean> kidsWithCandiesStream(int[] candies, int extraCandies) {
		int max = Arrays.stream(candies).max().getAsInt();
		return Arrays.stream(candies).mapToObj(candy -> candy + extraCandies >= max).collect(Collectors.toList());
	}
}
