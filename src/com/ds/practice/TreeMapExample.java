package com.ds.practice;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {

	Map<String, Integer> map = new TreeMap<>(new Comparator<String>() {

		@Override
		public int compare(String o1, String o2) {
			return 0;
		}
	});

	public static void main(String[] args) {

	}
}
