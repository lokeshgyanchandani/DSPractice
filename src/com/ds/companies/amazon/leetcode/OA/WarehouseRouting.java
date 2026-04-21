package com.ds.companies.amazon.leetcode.OA;

import java.lang.reflect.Array;
import java.util.*;

public class WarehouseRouting {

    public static List<Long> getMinConnectionCost(List<Integer> warehouseCapacity,
                                                  List<List<Integer>> additionalHubs) {
        int n = warehouseCapacity.size();
        List<Long> result = new ArrayList<>();

        for (List<Integer> hubs : additionalHubs) {
            int hubA = hubs.get(0) - 1;  // Convert to 0-based index
            int hubB = hubs.get(1) - 1;  // Convert to 0-based index

            long totalCost = 0;
            for (int i = 0; i < n; i++) {
                if (i == hubA || i == hubB || i == n - 1) {
                    continue; // These are hubs, no connection cost
                }

                // Find the nearest hub
                int nearestHub;
                if (i <= hubA) {
                    nearestHub = hubA;
                } else if (i <= hubB) {
                    nearestHub = hubB;
                } else {
                    nearestHub = n - 1;
                }

                totalCost += Math.abs(warehouseCapacity.get(nearestHub) - warehouseCapacity.get(i));
            }

            result.add(totalCost);
        }

        return result;
    }

    public static List<Long> getMinConnectionCost2(List<Integer> warehouseCapacity,
                                                   List<List<Integer>> additionalHubs) {
        List<Long> results = new ArrayList<>();
        int n = warehouseCapacity.size();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < warehouseCapacity.size(); i++) {
            map.put(i, warehouseCapacity.get(i));
        }

        for (List<Integer> query : additionalHubs) {
            int hubA = query.get(0) - 1;
            int hubB = query.get(1) - 1;
            long totalCost = 0;

            for (int i = 0; i < n; i++) {
                int costA = (i <= hubA) ? map.get(hubA) - map.get(i) : Integer.MAX_VALUE;
                int costB = (i <= hubB) ? map.get(hubB) - map.get(i) : Integer.MAX_VALUE;
                int costN = map.get(n - 1) - map.get(i);

                totalCost += Math.min(Math.min(costA, costB), costN);
            }
            results.add(totalCost);
        }

        return results;
    }

    public static void main(String[] args) {
        List<Integer> warehouseCapacity = Arrays.asList(0, 2, 5, 9, 12, 18);
        List<List<Integer>> additionalHubs = Arrays.asList(Arrays.asList(2, 5), Arrays.asList(1, 3));

        List<Integer> warehouseCapacity1 = Arrays.asList(2, 6, 8, 14);
        List<List<Integer>> additionalHubs1 = Arrays.asList(Arrays.asList(1, 2));

        List<Integer> warehouseCapacity2 = Arrays.asList(3, 6, 10, 15, 20);
        List<List<Integer>> additionalHubs2 = Arrays.asList(Arrays.asList(2, 4)); // Output: [8]

        List<Long> result = getMinConnectionCost2(warehouseCapacity, additionalHubs);
        System.out.println(result); // Output: [8]
    }
}
