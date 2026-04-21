package com.ds.leetcode.first_time;

public class Q1573_Number_Of_Ways_To_Split_A_String {

    private static final int MOD = 1000000007;

    public int numWays(String s) {
        int len = s.length();
        int numOnes = 0;
        for (int i = 0; i < len; i++)
            numOnes += s.charAt(i) - '0';

        if (numOnes == 0)
            return (int)(((len - 1L) * (len - 2L) / 2) % MOD);
        else if (numOnes % 3 != 0)
            return 0;

        int onesPerBlock = numOnes / 3, count = 0;
        long firstBlockNumWays = 0, secondBlockNumWays = 0;

        for (int i = 0; i < len; i++) {
            count += s.charAt(i) - '0';
            if (count == onesPerBlock)
                firstBlockNumWays++;
            else if (count == onesPerBlock * 2)
                secondBlockNumWays++;
        }

        return (int)(firstBlockNumWays * secondBlockNumWays % MOD);
    }

    public static void main(String[] args) {
        Q1573_Number_Of_Ways_To_Split_A_String obj = new Q1573_Number_Of_Ways_To_Split_A_String();
        System.out.println(obj.numWays("100100010100110"));
    }
}
