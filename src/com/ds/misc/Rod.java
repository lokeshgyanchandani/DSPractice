package miscellaneous;

public class Rod {

	// public static void main(String[] args) {
	// int[] price = { 3, 5, 8, 9, 10, 17, 17, 20 };
	// int cost = findmax(price, 8);
	// System.out.println(cost);
	// }
	//
	// private static int findmax(int[] price, int i) {
	//
	// return max(price, 0, 0, i);
	// }
	//
	// private static int max(int[] price, int index, int cost, int len) {
	// if (len == 0) {
	// return cost;
	// } else if (len < 0 || index > price.length -1) {
	// return -1;
	// } else {
	//
	// return Math.max(
	// max(price, index, cost + price[index], len - (index + 1)),
	// max(price, index + 1, cost, len));
	// }
	// }

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		int cut_cost = 1;

		int unit_price = 10;

		int lengths[] = { 26, 103, 59 };

		System.out.println(maxProfit(cut_cost, unit_price, lengths));

	}

	public static int maxProfit(int cost_per_cut, int metal_price, int[] lengths) {

		int maxlength = Integer.MIN_VALUE;
		int maxprice = Integer.MIN_VALUE;

		for (int i = 0; i < lengths.length; i++) {
			if (lengths[i] > maxlength)
				maxlength = lengths[i];
		}

		for (int i = 1; i <= maxlength; i++)
		{
			int price = findPrice(cost_per_cut, metal_price, lengths, i);
			if (findPrice(cost_per_cut, metal_price, lengths, i) > maxprice)
				maxprice = price;
		}
		return maxprice;
	}

	public static int findPrice(int cut_cost, int unit_price, int[] lengths,
			int length_of_cut) {

		int rods = 0;
		int totalRods = 0;
		int cuts = 0;
		for (int i = 0; i < lengths.length; i++) {
			
			if (length_of_cut == lengths[i]) {
				cuts = cuts + 0;
				rods = 1;
			}
			else {
				rods = lengths[i] / length_of_cut;
				cuts = cuts + rods;
			}
			totalRods += rods;
		}
		return totalRods * unit_price * length_of_cut - cuts * cut_cost;
	}

}