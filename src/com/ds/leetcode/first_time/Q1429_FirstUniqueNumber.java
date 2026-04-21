package com.ds.leetcode.first_time;

import java.util.HashSet;
import java.util.Set;

public class Q1429_FirstUniqueNumber {

    Set<Integer> unique;
    Set<Integer> total;

    public Q1429_FirstUniqueNumber(int[] nums) {
        unique = new HashSet<>();
        total = new HashSet<>();

        for (int num: nums)
            add(num);
    }

    public int showFirstUnique() {
        return !unique.isEmpty() ? unique.iterator().next() : -1;
    }

    public void add(int value) {
        if (total.add(value))
            unique.add(value);
        else
            unique.remove(value);
    }

    public static void main(String[] args) {

    }
}
