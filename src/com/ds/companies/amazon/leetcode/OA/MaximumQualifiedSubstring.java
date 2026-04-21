package com.ds.companies.amazon.leetcode.OA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MaximumQualifiedSubstring {

    public static int maxQualifiedSubstring(String word, String[] strs) {
        Set<String> forbidden = new HashSet<>(Arrays.asList(strs));
        int maxLen = 0, left = 0;

        for (int right = 0; right < word.length(); right++) {
            for (int j = left; j <= right; j++) {
                if (containsForbiddenSubstring(word.substring(j, right + 1), forbidden)) {
                    left = j + 1;
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    private static boolean containsForbiddenSubstring(String s, Set<String> forbidden) {
        for (String str : forbidden) {
            if (s.contains(str)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(maxQualifiedSubstring("abcd", new String[]{"a", "d"})); // Output: 2
        System.out.println(maxQualifiedSubstring("aaaa", new String[]{"ab"})); // Output: 4
    }
}
