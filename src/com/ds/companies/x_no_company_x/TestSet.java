package com.ds.companies.x_no_company_x;

import java.util.HashSet;
import java.util.Set;

public class TestSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<person> x = new HashSet<person>();
		person p1 = new person("Ashish","Goel");

		x.add(p1);
		x.add(new person("Ashish","Goel"));

		Set<Integer> y = new HashSet<Integer>();
		y.add(new Integer(1));
		y.add(new Integer(1));

		System.out.println(y);
		System.out.println(x);

	}



}
class person {
	String firstName;
	String lastName;

	public person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
}