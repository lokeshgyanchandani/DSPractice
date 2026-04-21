package com.ds.leetcode.first_time;

// Intuition
//      https://leetcode.com/problems/minimum-cost-to-convert-string-i/solutions/5539929/easy-explanation-floyd-warshall-algorith-9ydn

// Graph algo comparisons
//      https://cs.stackexchange.com/questions/2942/am-i-right-about-the-differences-between-floyd-warshall-dijkstra-and-bellman-fo

// Complexity
// Time complexity: O(N + M + Σ^3)
//      N: Length of the source string (iteration to calculate sum).
//      M: Length of the original array (initial graph build).
//      Σ: Size of the alphabet (26). The Floyd-Warshall part takes 26^3 operations, which is constant time (≈17,576 ops).

// Space complexity: O(Σ^2) or O(1)
// We only need a 26×26 matrix to store the costs.


import java.util.Arrays;

public class Q2976_MinimumCostToConvertStringI {

    private static final int CHAR_COUNT = 26;
    private static final int INF = Integer.MAX_VALUE;

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] conversionGraph = buildConversionGraph(original, changed, cost);
        optimizeConversionPaths(conversionGraph);
        return computeTotalConversionCost(source, target, conversionGraph);
    }

    private int[][] buildConversionGraph(char[] original, char[] changed, int[] cost) {
        int[][] graph = new int[CHAR_COUNT][CHAR_COUNT];

        for (int[] row : graph) {
            Arrays.fill(row, INF);
        }

        for (int i = 0; i < CHAR_COUNT; i++) {
            graph[i][i] = 0;
        }

        for (int i = 0; i < cost.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            graph[from][to] = Math.min(graph[from][to], cost[i]);
        }
        return graph;
    }

    /*
    The Floyd-Warshall algorithm works by considering each vertex as an intermediate point in a path between two other vertices.
    It does this for all possible combinations of vertices.

    The outer loop (k) represents the current intermediate vertex being considered.

    The inner loops (i and j) represent the start and end vertices of a path we're trying to optimize.

    The key operation is the comparison and update:
        graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])
        This checks if going from i to j through k is cheaper than the current known path from i to j.

    The condition graph[i][k] < INF and graph[k][j] < INF ensures that we only consider valid paths.
    If either segment of the path (i to k or k to j) is impossible (INF), we don't update graph[i][j].
     */
    private void optimizeConversionPaths(int[][] graph) {
        for (int k = 0; k < CHAR_COUNT; k++) {
            for (int i = 0; i < CHAR_COUNT; i++) {
                if (graph[i][k] < INF) {
                    for (int j = 0; j < CHAR_COUNT; j++) {
                        if (graph[k][j] < INF) {
                            graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                        }
                    }
                }
            }
        }
    }

    private long computeTotalConversionCost(String source, String target, int[][] graph) {
        long totalCost = 0;

        for (int i = 0; i < source.length(); i++) {
            int sourceChar = source.charAt(i) - 'a';
            int targetChar = target.charAt(i) - 'a';

            if (sourceChar != targetChar) {
                if (graph[sourceChar][targetChar] == INF) {
                    return -1L;
                }
                totalCost += graph[sourceChar][targetChar];
            }
        }

        return totalCost;
    }
}
