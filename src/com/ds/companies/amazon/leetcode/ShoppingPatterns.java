package com.ds.companies.amazon.leetcode;

import java.util.*;

public class ShoppingPatterns {

	static int getMinScore(int productsNodes, int[] productsFrom, int[] productsTo) {
		Map<Integer, Set<Integer>> edges = buildMap(productsFrom, productsTo);
		int minSum = Integer.MAX_VALUE;
		for (int vertex : edges.keySet()) {
			if (edges.get(vertex) != null && edges.get(vertex).size() >= 2) {
				int sum = findProSum(vertex, edges);
				System.out.println(sum);
				minSum = Math.min(minSum, sum);
			}
		}
		return minSum;
	}

	static int findProSum(int vertex, Map<Integer, Set<Integer>> edges) {
		Set<Integer> trioSet = edges.get(vertex);
		trioSet.add(vertex);
		int count = 0;
		for (int i : trioSet) {
			for (int j : edges.get(i)) {
				if (!trioSet.contains(j)) {
					count++;
				}
			}
		}
		trioSet.remove(vertex);
		return count;
	}

	static Map<Integer, Set<Integer>> buildMap(int[] start, int[] end) {
		Map<Integer, Set<Integer>> edges = new HashMap<>();

		for (int i = 0; i < start.length; i++) {
			Set<Integer> vertices = edges.getOrDefault(start[i], new HashSet<>());
			vertices.add(end[i]);
			edges.put(start[i], vertices);

			vertices = edges.getOrDefault(end[i], new HashSet<>());
			vertices.add(start[i]);
			edges.put(end[i], vertices);
		}

		return edges;
	}

	private static int getShoppingPatternsTrioMinimum(int numOfProducts,
													  List<Integer> products_from, List<Integer> products_to) {
		if(numOfProducts < 1 || products_from == null || products_to == null || products_to.size() != products_from.size()) return -1;

		Map<Integer,Set<Integer>> graph = new HashMap<>();
		for(int i=1;i<=numOfProducts;i++){
			graph.put(i,new HashSet<>());
		}

		for(int i=0;i<products_from.size();i++){
			//since its undirected
			graph.get(products_from.get(i)).add(products_to.get(i));
			graph.get(products_to.get(i)).add(products_from.get(i));
		}

		int count =  Integer.MAX_VALUE;
		for(int i=1;i<=numOfProducts;i++){
			for(int j=i+1;j<=numOfProducts;j++){
				for(int k=j+1;k<=numOfProducts;k++){
					if(graph.get(i).contains(j) && graph.get(j).contains(k) && graph.get(k).contains(i)){
						// these vertices forms a TRio
						int val = (graph.get(i).size() + graph.get(j).size() + graph.get(k).size()) - 6;
						count =  Math.min(count, val);
					}
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {

		//int score = getMinScore(6,6,new int[]{1,2,2,3,4,5}, new int[]{2,4,5,5,5,6});
		int score = getMinScore(6, new int[]{1, 1, 1, 2, 2, 3, 4}, new int[]{6, 2, 3, 3, 4, 4, 5});
		//int score = getShoppingPatternsTrioMinimum(6, Arrays.asList(1, 1, 1, 2, 2, 3, 4), Arrays.asList(6, 2, 3, 3, 4, 4, 5));
		System.out.println("Min score is " + score);
	}
}
