package com.ds.companies.amazon.leetcode.OA;

import java.util.*;

public class ProcessSchedulerBasedOnPriority {

    public static List<Integer> getPrioritiesAfterExecution(List<Integer> priorities) {
        while (true) {
            Map<Integer, List<Integer>> priorityMap = new HashMap<>();
            for (int i = 0; i < priorities.size(); i++) {
                priorityMap.computeIfAbsent(priorities.get(i), k -> new ArrayList<>()).add(i);
            }

            int maxPriority = -1;
            for (int key : priorityMap.keySet()) {
                if (priorityMap.get(key).size() >= 2) {
                    maxPriority = Math.max(maxPriority, key);
                }
            }

            if (maxPriority == -1 || maxPriority == 0) {
                break;
            }

            List<Integer> indices = priorityMap.get(maxPriority);
            int process1 = indices.get(0);
            int process2 = indices.get(1);

            priorities.remove(process1);
            if (process2 > process1) {
                process2--;
            }

            priorities.set(process2, priorities.get(process2) / 2);
        }
        return priorities;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> priorities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            priorities.add(scanner.nextInt());
        }
        scanner.close();

        List<Integer> result = getPrioritiesAfterExecution(priorities);
        for (int priority : result) {
            System.out.print(priority + " ");
        }
    }
}
