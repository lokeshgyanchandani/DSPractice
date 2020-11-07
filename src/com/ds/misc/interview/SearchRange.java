package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 1,3};
		String s[] = {"12","121"};
		Arrays.sort(s);
		System.out.println(s);
		List<String> list = summaryRanges(a);
		for (String s1 : s) {
			System.out.println(s1);
		}

	}

	public static List<String> summaryRanges(int[] nums) {
		if (nums == null)
			return null;
		int i = 0;
		List<String> list = new ArrayList<String>();

		while (i < nums.length) {
			int start = nums[i];
				while (i < nums.length - 1 && (nums[i] == nums[i + 1] - 1)) {
					i++;
				}
				if(start!=nums[i])
				{
				StringBuilder builder = new StringBuilder();
				builder.append(start);
				builder.append("->");
				builder.append(nums[i]);
				list.add(builder.toString());
				}
				else
				{
				StringBuilder builder = new StringBuilder();
				builder.append(nums[i]);
				list.add(builder.toString());
				}
				i++;
			}

		return list;

	}
}
