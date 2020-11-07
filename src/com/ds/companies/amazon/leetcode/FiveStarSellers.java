package com.ds.companies.amazon.leetcode;

import java.util.*;

public class FiveStarSellers {

	/*public static int fiveStarReviews(List<List<Integer>> productRatings, int ratingsThreshold) {
		int num = 0;
		PriorityQueue<List<Integer>> pq = new PriorityQueue<>((l1, l2) -> diff(l2) - diff(l1)); // max-heap.

		for (List<Integer> rating : productRatings)
			pq.offer(rating); // initialize PriorityQueue.

		double curRating = 0;
		for (List<Integer> rating : productRatings)
			curRating += 100.0 * rating.get(0) / rating.get(1); // initialize curRating.
		while (curRating < ratingsThreshold * productRatings.size()) {
			num++;
			List<Integer> rating = pq.poll();
			List<Integer> newRating = Arrays.asList(rating.get(0) + 1, rating.get(1) + 1);
			curRating = curRating - 100.0 * rating.get(0) / rating.get(1) + 100.0 * newRating.get(0) / newRating.get(1); // keep updating the rating.
			pq.offer(newRating);
		}
		return num;
	}

	// the diff between the current product rating and the product added one more five-star rating.
	private static int diff(List<Integer> p) {
		double currRating = 100.0 * p.get(0) / p.get(1);
		double newRating = 100.0 * (p.get(0) + 1) / (p.get(1) + 1);
		return (int) (newRating - currRating);
	}*/

	public static int fiveStarReviews(List<List<Integer>> productRatings, int ratingThreshold) {
		if (productRatings == null)
			return 0;
		int num = 0;
		PriorityQueue<List<Double>> pq = new PriorityQueue<>(new Comparator<List<Double>>() {
			@Override
			public int compare(List<Double> l1, List<Double> l2) {
				if (diff(l2) > diff(l1)) return 1;
				if (diff(l2) < diff(l1)) return -1;
				return 0;
			}
		}); // max-heap

		for (List<Integer> rating: productRatings)
			pq.offer(Arrays.asList((double) rating.get(0), (double) rating.get(1))); //initialize PriorityQueue

		double currRating = 0.0;
		for (List<Integer> rating: productRatings)
			currRating += 100.0 * rating.get(0) / rating.get(1); // initialize currRating

		while (currRating < ratingThreshold * productRatings.size()) {
			num++;
			List<Double> rating = pq.poll();
			List<Double> newRating = Arrays.asList(rating.get(0) + 1, rating.get(1) + 1);
			currRating = currRating - 100.0 * rating.get(0) / rating.get(1) + 100.0 * newRating.get(0) / newRating.get(1); // keep updating the rating
			pq.offer(newRating);
		}

		return num;
	}

	private static double diff(List<Double> product) {
		double currRating = 100.0 * product.get(0) / product.get(1);
		double newRating = 100.0 * (product.get(0) + 1) / (product.get(1) + 1);
		return (newRating - currRating);
	}

	public static void main(String[] args) {
		List<List<Integer>> productRatings = new ArrayList<>();
		List<Integer> reviews = new ArrayList<>();
		reviews.add(4);
		reviews.add(4);
		productRatings.add(reviews);

		reviews = new ArrayList<>();
		reviews.add(1);
		reviews.add(2);
		productRatings.add(reviews);

		reviews = new ArrayList<>();
		reviews.add(3);
		reviews.add(6);
		productRatings.add(reviews);

		int ratingsThreshold = 77;

		System.out.print("Min 5 stars required " + fiveStarReviews(productRatings,
				ratingsThreshold));
	}
}
