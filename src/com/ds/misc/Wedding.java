package miscellaneous;

import java.util.Arrays;

public class Wedding {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2000;
		// int[] a = { 10, 25, 50, 100, 500 };
		// int[] a = { 5, 10, 25, 50, 100, 500 };
		// String[] u = { 5, 0, 0, 0, 0, 54.25 };
		int[] a = { 10, 25, 50, 100, 500 };

		int q = Arrays.binarySearch(a, n);
		String[] u = { "27.32", "23.13", "21.25", "18.00", "15.50" };

		float ans = interpolate(a, u, n);
		System.out.println(ans);

	}

	public static float interpolate(int[] amount, String[] ucost, int n) {

		int counter = 0;

		float[] cost = convertTofloat(ucost);

		if (cost.length == 1)
			return cost[0];

		for (int i = 0; i < cost.length; i++) {
			if (cost[i] > 0)
				counter++;
		}

		int[] newAmount = new int[counter];
		float[] newCost = new float[counter];
		int temp = 0;
		for (int i = 0; i < cost.length; i++) {
			if (cost[i] > 0) {
				newAmount[temp] = amount[i];
				newCost[temp] = cost[i];
				temp++;
			}
		}

		for (int i = 0; i < newAmount.length; i++) {
			if (n == newAmount[i]) {
				System.out.println(newCost[i]);
				System.out.println("new");
				return newCost[i];
			}
		}

		int start = newAmount[0];
		int end = newAmount[newAmount.length - 1];

		if (newAmount.length == 1)
			return newCost[0];

		else if (n > end) {
			return maxThanAll(newCost, newAmount, n);

		} else if (n < start) {
			return lessThanAll(newCost, newAmount, n);

		} else if (n > start && n < end) {
			return liesInBetween(newCost, newAmount, n);
		}

		return -1;

	}

	private static float liesInBetween(float[] newCost, int[] newAmount, int n) {
		for (int i = 1; i < newAmount.length; i++) {
			if (newAmount[i - 1] < n && newAmount[i] > n) {
				float startCost = newCost[i - 1];
				float endCost = newCost[i];

				int startAmount = newAmount[i - 1];
				int endAmount = newAmount[i];
				return calculateCost(startCost, endCost, startAmount,
						endAmount, n);
			}
		}
		return -1;
	}

	private static float lessThanAll(float[] newCost, int[] newAmount, int n) {
		float startCost = newCost[0];
		float endCost = newCost[1];

		int startAmount = newAmount[0];
		int endAmount = newAmount[1];

		return calculateCost(startCost, endCost, startAmount, endAmount, n);
	}

	private static float maxThanAll(float[] newCost, int[] newAmount, int n) {

		float startCost = newCost[newAmount.length - 1];
		float endCost = newCost[newAmount.length - 2];

		int startAmount = newAmount[newAmount.length - 1];
		int endAmount = newAmount[newAmount.length - 2];
		return calculateCost(startCost, endCost, startAmount, endAmount, n);
	}

	private static float calculateCost(float startCost, float endCost,
			int startAmount, int endAmount, int n) {
		float c = (((startCost - endCost) / (startAmount - endAmount)) * (n - startAmount))
				+ startCost;
		return (float) (Math.round(c * 100.0) / 100.0);
	}

	private static float[] convertTofloat(String[] ucost) {

		float d[] = new float[ucost.length];

		for (int i = 0; i < ucost.length; i++) {

			d[i] = Float.parseFloat(ucost[i]);

		}
		return d;
	}
}
