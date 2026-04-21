package com.ds.scheduler;

import java.util.*;

public class TaskScheduler {

    private class KeyValuePair<Character, Integer> {

        private char key;
        private int count = 0;

        KeyValuePair(char key) {
            this.key = key;
        }

        int getCount() {
            return count;
        }

        void increment() {
            count = count + 1;
        }
    }

    private ArrayList<KeyValuePair<Character, Integer>> freq;

    public int leastInterval(char[] tasks, int n) {
        TreeMap<Character, Integer> uniq = new TreeMap<>();

        freq = new ArrayList<>();

        for (int i = 0; i < tasks.length; i++) {
            if (!uniq.containsKey(tasks[i]))
                uniq.put(tasks[i], 1);
        }

        //uniq.inde
        //Collections.sort(sortedList);
        for (int i = 0; i < uniq.size(); i++) {
            freq.add(new KeyValuePair((char)('A' + i)));
        }
        for (int i = 0; i < uniq.size(); i++) {
            //freq
        }
        for (int i = 0; i < tasks.length; i++) {
            freq.get(tasks[i] - 'A').increment();
        }

        return 1;
    }

    private void purge() {
        for (int i = 0; i < 26; i++) {
            if (freq.get(i).getCount() == 0)
                freq.remove(i);
        }
    }

    private int taskSchedule() {
        return 1;
    }

    public static void main(String args[]) {
        System.out.println("Hello");
    }
}
