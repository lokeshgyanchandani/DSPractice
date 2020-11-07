package com.ds.companies.amazon.leetcode;

import java.util.*;

public class LargestItemAssociation {

	static List<String> largestItemAssociation(List<PairString> itemAssociation) {
		Map<String, Set<String>> graph = buildGraph(itemAssociation);
		List<List<String>> connectedItems = buildConnectedItemsList(graph);
		sort(connectedItems);
		return connectedItems.get(0);
	}

	static Map<String, Set<String>> buildGraph(List<PairString> itemAssociation) {
		Map<String, Set<String>> graph = new HashMap<>();

		for(PairString pair : itemAssociation) {
			graph.putIfAbsent(pair.first, new HashSet<>());
			graph.get(pair.first).add(pair.second);
			graph.putIfAbsent(pair.second, new HashSet<>());
			graph.get(pair.second).add(pair.first);
		}

		return graph;
	}

	static List<List<String>> buildConnectedItemsList(Map<String, Set<String>> graph) {
		List<List<String>> connectedItems = new ArrayList<>();
		Set<String> seen = new HashSet<>();

		for(String node : graph.keySet()) {
			List<String> list = new ArrayList<>();
			dfs(node, graph, seen, list);
			if(!list.isEmpty()) {
				Collections.sort(list);
				connectedItems.add(list);
			}
		}

		return connectedItems;
	}

	static void dfs(String node, Map<String, Set<String>> graph, Set<String> seen, List<String> list) {
		if(seen.contains(node)) return;
		seen.add(node);
		list.add(node);

		for(String neighbour : graph.get(node))
			dfs(neighbour, graph, seen, list);
	}

	public static void sort(List<List<String>> connectedItems) {
		Collections.sort(connectedItems, new Comparator<List<String>>() {
			@Override
			public int compare(List<String> l1, List<String> l2) {
				if(l1.size() != l2.size()) return l2.size() - l1.size();
				else {
					for(int i = 0 ; i < l1.size() ; i++) {
						if(l1.get(i).equals(l2.get(i))) continue;
						else return l1.get(i).compareTo(l2.get(i));
					}
				}
				return 0;
			}
		});
	}

	public static void main(String[] args) {
		List<PairString> pairs = Arrays.asList( //
				new PairString("item1", "item2"),
				new PairString("item3", "item4"),
				new PairString("item4", "item5") //
		);

		System.out.println(largestItemAssociation(pairs));
	}
}

class PairString {
	String first;
	String second;

	PairString(String first, String second) {
		this.first = first;
		this.second = second;
	}
}
