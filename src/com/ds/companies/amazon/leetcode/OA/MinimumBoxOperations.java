package com.ds.companies.amazon.leetcode.OA;

public class MinimumBoxOperations {

    public static int findMinimumOperations(int[] boxes) {
        // Calculate the total number of boxes
        int totalBoxes = 0;
        for (int box : boxes) {
            totalBoxes += box;
        }

        // Find the average number of boxes that each pile should have
        int averageBoxes = totalBoxes / boxes.length;

        // Calculate the number of piles that need more boxes than the average
        int extraPiles = totalBoxes % boxes.length;

        // Initialize the number of operations required
        int operations = 0;

        // Iterate through the piles
        for (int boxCount : boxes) {
            // Calculate the difference between the current pile and the average
            int difference = boxCount - averageBoxes;

            // If the pile has more boxes than the average
            if (difference > 0) {
                // Update operations by the difference
                operations += difference;

                // If there are extra piles, decrease the operations by 1 for each extra pile
                if (extraPiles > 0) {
                    operations -= 1;
                    extraPiles--;
                }
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        int[] boxes = {5, 5, 8, 7};
        System.out.println("Minimum operations: " + findMinimumOperations(boxes));
    }
}
