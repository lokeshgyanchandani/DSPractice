package com.ds.companies.amazon.leetcode.OA;

public class MinCostDataLexicographicOrder {
    public static String getMinCostData(String data) {
        char[] arr = data.toCharArray();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] == '?') {
                for (char c = 'a'; c <= 'z'; c++) {
                    if ((i > 0 && arr[i - 1] == c) || (i < n - 1 && arr[i + 1] == c)) {
                        continue;
                    }
                    arr[i] = c;
                    break;
                }
            }
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        String data = "abcd?";
        System.out.println(getMinCostData(data)); // Output: "abcde"
    }
}
