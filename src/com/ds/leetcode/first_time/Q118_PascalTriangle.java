package com.ds.leetcode.first_time;

import java.util.ArrayList;
import java.util.List;

public class Q118_PascalTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        if (numRows == 0) return result;

        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < i; j++)
                row.set(j, row.get(j) + row.get(j + 1));
            result.add(new ArrayList<>(row));
        }
        return result;
    }

    public static void main(String[] args) {
        Q118_PascalTriangle obj = new Q118_PascalTriangle();
        System.out.println(obj.generate(5));
    }
}
