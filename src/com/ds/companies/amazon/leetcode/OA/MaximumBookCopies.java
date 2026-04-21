package com.ds.companies.amazon.leetcode.OA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaximumBookCopies {

    public static List<Integer> maximumBookCopies(int[] portalUpdate) {
        Map<Integer, Integer> inventory = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int maxCopies;

        for (int update : portalUpdate) {
            if (update > 0) {
                inventory.put(update, inventory.getOrDefault(update, 0) + 1);
            } else {
                int bookId = -update;
                if (inventory.containsKey(bookId)) {
                    inventory.put(bookId, inventory.get(bookId) - 1);
                    if (inventory.get(bookId) == 0) {
                        inventory.remove(bookId);
                    }
                }
            }

            maxCopies = inventory.values().stream().max(Integer::compare).orElse(0);
            result.add(maxCopies);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] portalUpdate = {6, 6, 2, -6, -2, -6};
        System.out.println(maximumBookCopies(portalUpdate));
    }
}
