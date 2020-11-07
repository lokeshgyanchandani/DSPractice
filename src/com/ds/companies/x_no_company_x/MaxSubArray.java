package com.ds.companies.x_no_company_x;

public class MaxSubArray {

	public static void main(String[] args) {
		int[] a ={-11,-1,7,-6,7,-8};
		int maxSofar = a[0];
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			maxSofar = Math.max(a[i], maxSofar+a[i]);
			max= Math.max(maxSofar,max);

		}
		System.out.println(max);

	}

}
