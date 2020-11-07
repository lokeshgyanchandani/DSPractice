package com.ds.companies.x_no_company_x;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams {

	public static void main(String[] args) {

		String h = "# 1 2";

		String[] x1 = h.split("");
		char[] ch = new char[x1.length];
		int g =0;

		for(String k:x1)
		{
			ch[g] = k.charAt(0);
		}

		char[] h1 = h.toCharArray();
		Arrays.sort(h1);
		String newh1 = new String(h1);
		System.out.println(newh1);
		List<String> x = new ArrayList<>();
		x.add("ashish");
		x.add("ishash");
		x.add("ashd");
		x.add("badldl");
		x.add("isahsh");

		for (String d : x) {
			char[] y = d.toCharArray();
			Arrays.sort(y);
			if(new String(y).equals(newh1))
			{
				System.out.println(d);
			}
		}
	}

}






















