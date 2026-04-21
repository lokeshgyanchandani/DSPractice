package com.ds.leetcode.first_time;

import java.util.Arrays;

public class Q322_CoinChange {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;

        int[] minCoins = new int[amount + 1];

        // -1 because if adding + 1 to intMAx it will make Int.Min in below
        Arrays.fill(minCoins, Integer.MAX_VALUE - 1);
        minCoins[0] = 0;

        for (int coin: coins) {
            for (int i = 0; i <= amount; i++) {
                if (coin <= i)
                    minCoins[i] = Math.min(minCoins[i], minCoins[i - coin] + 1);
            }
        }
        return minCoins[amount] == Integer.MAX_VALUE - 1 ? - 1 : minCoins[amount];
    }

    public static void main(String[] args) {

    }
}
