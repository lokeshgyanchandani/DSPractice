package com.ds.leetcode.first_time;

import java.util.HashMap;
import java.util.Map;

public class Q340_LongestSubstringWithAtmostKDistinctCharacters {

    private static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) return 0;

        Map<Character, Integer> map = new HashMap<>();
        int start = 0, end = 0, distinctChars = 0, maxLen = 0;
        while (end < s.length()) {
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.get(c) == 1) distinctChars++; //new char

            while (distinctChars > 2) {
                char cTemp = s.charAt(start);
                map.put(cTemp, map.get(cTemp) - 1);
                if (map.get(cTemp) == 0) {
                    distinctChars--;
                }
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String input = "ccaabbb";
        System.out.println(lengthOfLongestSubstringKDistinct(input, 2));
    }
}
