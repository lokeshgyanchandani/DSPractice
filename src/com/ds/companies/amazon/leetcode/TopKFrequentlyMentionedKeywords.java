package com.ds.companies.amazon.leetcode;

import java.util.*;

public class TopKFrequentlyMentionedKeywords {

	public String[] getMostFrequentCommonwords(String[] reviews, String[] keywords, int k) {
		Map<String, Integer> frequencies = new HashMap<>();
		List<String> keywordList = Arrays.asList(keywords);

		for (String review : reviews) {
			review = review.toLowerCase();
			Set<String> encounteredWords = new HashSet<>();
			for (final String reviewWord : review.split(" ")) {
				if (!encounteredWords.contains(reviewWord) && keywordList.contains(reviewWord)) {
					Integer currentFrequency = frequencies.getOrDefault(reviewWord, 0);
					frequencies.put(reviewWord, currentFrequency + 1);
					encounteredWords.add(reviewWord);
				}
			}
		}

		String[] frequencyArray = frequencies.keySet().toArray(new String[k]);
		Arrays.sort(frequencyArray, (a, b) -> frequencies.get(a).equals(frequencies.get(b))
				? a.compareTo(b)
				: frequencies.get(b) - frequencies.get(a));

		return Arrays.copyOfRange(frequencyArray, 0, k);
	}

	public static void main(String[] args) {

	}
}
