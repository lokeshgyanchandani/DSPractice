package com.ds.companies.amazon.leetcode.OA;

public class SuitableWarehouseLocations {

    public static int countSuitableLocations(int n, int[] center, int d) {
        int minX = -109, maxX = 109;
        int count = 0;

        for (int x = minX; x <= maxX; x++) {
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                if (Math.abs(x - center[i]) > d) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 3;
        int[] center = {-2, 1, 0};
        int d = 8;
        System.out.println(countSuitableLocations(n, center, d));
    }
}
