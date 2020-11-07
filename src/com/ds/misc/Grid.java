package miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid {

	public static void main(String args[]) {
		String[] inp = { "3 3 3",};
		String[] out = new String[inp.length];
		for (int i = 0; i < inp.length; i++) {
			char[] input = inp[i].toCharArray();
			int x = input[0] - 48;
			int y = input[2] - 48;
			int k = input[4] - 48;
			List<String> list = new ArrayList<String>();
			char a[] = new char[x + y];
			getPaths(x, y, 0, 0, list, a, 0);
			for (int m = 0; m < list.size(); m++) {
				System.out.println(list.get(m));
			}
			out[i] = list.get(k);
		}
		for (int m = 0; m < out.length; m++) {
			System.out.println(out[m]);
		}

	}

	public static void getPaths(int x, int y, int start, int end,
			List<String> list, char array[], int index) {
		if (start > x || end > y) {
			return;
		} else if (start == x && end == y) {
			StringBuilder builder = new StringBuilder();
			for (char k : array) {
				builder.append(k);
			}
			list.add(builder.toString());

		} else {

			array[index] = 'H';
			getPaths(x, y, start, end + 1, list, array, index + 1);
			array[index] = 'V';
			getPaths(x, y, start + 1, end, list, array, index + 1);
		}
	}
}
