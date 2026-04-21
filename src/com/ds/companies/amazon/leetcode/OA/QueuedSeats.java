package com.ds.companies.amazon.leetcode.OA;

import java.util.*;

public class QueuedSeats {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // Number of people in queue
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); // Seat choices
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int num : arr) {
            queue.add(num);
        }

        Set<Integer> occupiedSeats = new HashSet<>();
        List<Integer> assignedSeats = new ArrayList<>();

        while (!queue.isEmpty()) {
            int seat = queue.poll();
            while (occupiedSeats.contains(seat)) {
                seat++; // Increment seat number if occupied
            }
            occupiedSeats.add(seat);
            assignedSeats.add(seat);
        }

        for (int seat : assignedSeats) {
            System.out.println(seat);
        }

        sc.close();
    }
}
