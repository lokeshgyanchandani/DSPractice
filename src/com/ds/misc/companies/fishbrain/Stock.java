package com.ds.misc.companies.fishbrain;

public class Stock {

	public static class Node {
		double taxedTotal;
		double reminder;
		double bandRate;
		double currTax;

		public Node(double a, double b, double c, double d) {
			this.taxedTotal = a;
			this.reminder = b;
			this.bandRate = c;
			this.currTax = d;
		}
	}

	public static void main(String args[]) {
		int sal = 0;
		int gift = 10000;

		int total = sal + gift;

		double incomeTax = find(sal * 1.0);
		System.out.println(incomeTax);

		Node wot = findTotal(total * 1.0);
		double lhs = wot.reminder + wot.currTax - incomeTax;

		System.out.println(lhs);
		double x = (lhs * 100.0) / (100.0 - wot.bandRate);
		System.out.println(x);

		double ans = wot.taxedTotal + x;
		System.out.println(ans);
	}

	private static double find(double tot) {
		double copyTotal = tot;
		if (tot > 4750.50) {
			tot -= 4750.50;
		}
		double tt = 0.0;
		double b1 = 8000.0;
		double t1 = 20.0;
		if (tot > b1) {
			tot -= b1;
			tt += (b1 * t1) / 100;
		} else {
			tt += (tot * t1) / 100;
		}

		return tt;
	}


	private static Node findTotal(double tot) {
		double copyTotal = tot;
		if (tot > 4750.50) {
			tot -= 4750.50;
		}
		double tt = 0.0;
		double b1 = 8000.0;
		double t1 = 20.0;
		if (tot > b1) {
			tot -= b1;
			tt += (b1 * t1) / 100;
		} else {
			System.out.println(tot);

			return new Node(copyTotal - tot, tot, t1, tt);
		}
		System.out.println(tt);
		double b2 = 10000.0;
		double t2 = 40.0;
		if (tot > b2) {
			tot -= b2;
			tt += (b2 * t2) / 100;
		} else {
			System.out.println(tot);

			return new Node(copyTotal - tot, tot, t2, tt);
			// tt+=((tot*100.0)/100.0-t2)-tot;
		}
		return new Node(0, 0, 0, 0);
	}
}
