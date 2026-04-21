package com.ds.companies.amazon.leetcode.OA;

public class KindlePageNumberOfWays {

    public static long numberOfWays(String book) {
        long count0 = 0, count1 = 0;
        long count01 = 0, count10 = 0;
        long result;

        for (char c: book.toCharArray()) {
            if (c == '0') {
                count0++;
                count10 += count1;
            } else {
                count1++;
                count01 += count0;
            }
        }

        result = count01 * (count1 - count01) + count10 * (count0 - count10);
        return result;
    }

    public static void main(String[] args) {
        String book = "10111";
        System.out.println("Number of ways: " + numberOfWays(book));
    }
}
