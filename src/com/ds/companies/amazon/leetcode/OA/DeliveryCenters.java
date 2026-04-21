package com.ds.companies.amazon.leetcode.OA;

import java.util.Arrays;

public class DeliveryCenters {

    public static int countSuitableLocations(int[] centers, int d) {
        Arrays.sort(centers);
        int left = centers[0], right = centers[centers.length - 1];
        int count = 0;

        for (int x = left; x <= right; x++) {
            int totalDistance = 0;
            for (int center : centers) {
                totalDistance += 2 * Math.abs(x - center);
            }
            if (totalDistance <= d) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] centers1 = {-2, 1, 0};
        System.out.println(countSuitableLocations(centers1, 8)); // Output: 3

        int[] centers2 = {2, 0, 3, -4};
        System.out.println(countSuitableLocations(centers2, 22)); // Output: 5

        int[] centers3 = {-3, 2, 2};
        System.out.println(countSuitableLocations(centers3, 8)); // Output: 0
    }
}
