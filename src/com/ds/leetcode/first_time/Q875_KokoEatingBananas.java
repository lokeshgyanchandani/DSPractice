package com.ds.leetcode.first_time;

public class Q875_KokoEatingBananas {

	static int minEatingSpeed(int[] piles, int H) {
		int low = 1, high = getMaxPile(piles);

		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (canEatAll(piles, mid, H))
				high = mid - 1;
			else
				low = mid + 1;
		}

		return low;
	}

	private static boolean canEatAll(int[] piles, int K, int H) {
		int countHour = 0;

		for (int pile : piles) {
			countHour += pile / K;
			if (pile % K != 0)
				countHour++;
		}

		return countHour <= H;
	}

	private static int getMaxPile(int[] piles) {
		int max = Integer.MIN_VALUE;
		for (int pile : piles)
			max = Math.max(max, pile);
		return max;
	}

	public static void main(String args[]) {
		int[] piles = new int[] {3, 6, 7, 11};
		System.out.println(minEatingSpeed(piles, 8));
	}
}
