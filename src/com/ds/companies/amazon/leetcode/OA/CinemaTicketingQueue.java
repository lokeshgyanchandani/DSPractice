package com.ds.companies.amazon.leetcode.OA;

import java.util.*;

public class CinemaTicketingQueue {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();

        while (cases-- > 0) {
            solveCase(scanner);
        }

        scanner.close();
    }

    /**
     * TIME COMPLEXITY: O(N * log(N))
     *
     */
    private static void solveCase(Scanner scanner) {
        int n = scanner.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        List<List<Integer>> ppl = new ArrayList<>();
        for (int i = 0; i < 2 * n + 4; i++) {
            ppl.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            ppl.get(a[i]).add(i);
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (x, y) -> Integer.compare(y[0], x[0])
        );

        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        for (int pos = 1; pos <= 2 * n; pos++) {
            for (int i : ppl.get(pos)) {
                heap.offer(new int[]{pos, i});
            }

            if (!heap.isEmpty()) {
                ans[heap.poll()[1]] = pos;
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();
    }
}
