package com.ds.companies.amazon.leetcode.OA;

public class StableString {

    public static int minSubstringToReplace(String s) {
        int n = s.length();
        // To check the required frequency of each character
        int requiredCount = n / 4;

        // Count the occurrences of H, B, D, and U in the string
        int[] counts = new int[4]; // counts[0] for H, counts[1] for B, counts[2] for D, counts[3] for U
        for (char c : s.toCharArray()) {
            if (c == 'H') counts[0]++;
            else if (c == 'B') counts[1]++;
            else if (c == 'D') counts[2]++;
            else if (c == 'U') counts[3]++;
        }

        // If the string is already stable
        boolean isStable = true;
        for (int i = 0; i < 4; i++) {
            if (counts[i] != requiredCount) {
                isStable = false;
                break;
            }
        }

        // If stable, no replacements are needed
        if (isStable) return 0;

        // Sliding window approach to find the minimum substring to replace
        int minLength = n;
        int left = 0;

        // Iterate through the string with a sliding window
        for (int right = 0; right < n; right++) {
            // Update counts for the character at position 'right'
            if (s.charAt(right) == 'H') counts[0]--;
            else if (s.charAt(right) == 'B') counts[1]--;
            else if (s.charAt(right) == 'D') counts[2]--;
            else if (s.charAt(right) == 'U') counts[3]--;

            // Check if the substring from left to right can make the string stable
            while (canMakeStable(counts, requiredCount)) {
                minLength = Math.min(minLength, right - left + 1);
                // Move the left pointer to shrink the window
                if (s.charAt(left) == 'H') counts[0]++;
                else if (s.charAt(left) == 'B') counts[1]++;
                else if (s.charAt(left) == 'D') counts[2]++;
                else if (s.charAt(left) == 'U') counts[3]++;
                left++;
            }
        }

        return minLength;
    }

    // Helper method to check if the string can be made stable with the current counts
    private static boolean canMakeStable(int[] counts, int requiredCount) {
        for (int count : counts) {
            if (count > requiredCount)
                return false; // If there's any character count exceeding the required, it's not stable
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "HBBBUBBB";
        System.out.println("Minimum length to replace: " + minSubstringToReplace(s)); // Output should be 5
    }
}
