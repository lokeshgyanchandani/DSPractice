package com.ds.companies.x_no_company_x;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

	public static ArrayList<String> popularNFeatures(int numFeatures,
											  int topFeatures,
											  List<String> possibleFeatures,
											  int numFeatureRequests,
											  List<String> featureRequests) {


		Map<String, Integer> map = new HashMap<>();

		for (int i=0; i < numFeatureRequests; i++) {
			String currRequest = featureRequests.get(i);
			String [] words = currRequest.split("\\s+");
			if (words.length == 0)
				continue;
			List<String> wordsList = Arrays.asList(words);

			for (int j=0; j < numFeatures; j++) {

				String currFeature = possibleFeatures.get(j);

				if (wordsList.stream().anyMatch(x -> x.equalsIgnoreCase(currFeature))) {
					map.put(currFeature, map.getOrDefault(currFeature, 0) + 1);
				}

			}
		}


		return map.entrySet().stream()
				.sorted(new Comparator<Map.Entry<String, Integer>>() {
					@Override
					public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
						if (o1.getValue().compareTo(o2.getValue()) != 0)
							return o2.getValue().compareTo(o1.getValue());
						else
							return o1.getKey().compareTo(o2.getKey());
					}
				})
				.limit(topFeatures)
				.map(Map.Entry::getKey)
				.collect(Collectors.toCollection(ArrayList::new));

	}

	public static void main(String[] args) {
		List<String> features = Arrays.asList("anacell" , "betacellular", "cetracular", "deltacellular", "eurocell");
		List<String> reviews = Arrays.asList(
				"I love anacell Best services anacell",
				"betacellular has great",
				"deltacellular provides betacellular",
				"cetracular is worse eurocell",
				"betacellular is better deltacellular");
		System.out.println(popularNFeatures(5, 2, features, 5, reviews));

	}
}






















