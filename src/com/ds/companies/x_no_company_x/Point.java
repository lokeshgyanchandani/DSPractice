package com.ds.companies.x_no_company_x;

import java.util.ArrayList;
import java.util.Comparator;

public class Point {
	int x;
	int y;
	Double distance;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.distance = calculate(x, y);
	}

	private Double calculate(int x2, int y2) {
		return Math.sqrt(x2 * x2 + y2 * y2);
	}

	public static void main(String[] args) {
		ArrayList<Point> points = new ArrayList<>();
		points.add(new Point(-1, 1));
		points.add(new Point(1, 1));
		points.add(new Point(1, 3));
		points.add(new Point(-1, 3));
		points.add(new Point(1, -1));
		points.add(new Point(3, -1));
		points.add(new Point(-1, -1));
		points.add(new Point(-1, 3));
		points.add(new Point(2, 2));
		points.sort(new PointComparator());
		for (Point point : points)
			System.out.println(point.x + " " + point.y);
	}

}

class PointComparator implements Comparator<Point> {

	@Override
	public int compare(Point o1, Point o2) {
		return o1.distance.compareTo(o2.distance);
	}

}
