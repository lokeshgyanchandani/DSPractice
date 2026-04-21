package com.ds.leetcode.first_time;

import java.util.*;

public class Q554_BrickWall {

    public static int leastBricks(List<List<Integer>> wall) {
        if (wall.size() == 0)
            return 0;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> list : wall) {
            int length = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                length += list.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
                count = Math.max(count, map.get(length));
            }
        }
        return wall.size() - count;
    }

    public static void main(String[] args) {
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(1));
        wall.add(Arrays.asList(1));
        wall.add(Arrays.asList(1));
        System.out.println(leastBricks(wall));
    }
}
