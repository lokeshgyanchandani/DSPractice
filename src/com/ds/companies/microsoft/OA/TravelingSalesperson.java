package com.ds.companies.microsoft.OA;

import java.util.*;

public class TravelingSalesperson {

    static class Edge {
        int to;
        long weight;

        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private static long[] dijkstra(List<Edge>[] graph, int start, int n) {
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        pq.add(new long[]{start, 0});

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int u = (int) curr[0];
            long d = curr[1];

            if (d > dist[u]) continue;

            for (Edge e : graph[u]) {
                long nd = d + e.weight;
                if (nd < dist[e.to]) {
                    dist[e.to] = nd;
                    pq.add(new long[]{e.to, nd});
                }
            }
        }

        return dist;
    }

    public static List<Integer> getMinimumLength(int roadsNodes,
                                                 List<Integer> roadsFrom,
                                                 List<Integer> roadsTo,
                                                 List<Integer> roadsWeight) {

        int n = roadsNodes;
        int m = roadsFrom.size();

        // Adjacency lists (1-based indexing)
        List<Edge>[] graph = new ArrayList[n + 1];
        List<Edge>[] reverseGraph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        // Build graph and reverse graph
        for (int i = 0; i < m; i++) {
            int u = roadsFrom.get(i);
            int v = roadsTo.get(i);
            int w = roadsWeight.get(i);

            graph[u].add(new Edge(v, w));
            reverseGraph[v].add(new Edge(u, w));
        }

        List<Integer> result = new ArrayList<>(n);

        // Compute shortest cycle for each node
        for (int x = 1; x <= n; x++) {
            long[] dist = dijkstra(reverseGraph, x, n);
            long best = Long.MAX_VALUE;

            // Try all outgoing edges x -> v
            for (Edge e : graph[x]) {
                if (dist[e.to] != Long.MAX_VALUE) {
                    best = Math.min(best, e.weight + dist[e.to]);
                }
            }

            result.add(best == Long.MAX_VALUE ? 0 : (int) best);
        }

        return result;
    }

    public static void main(String[] args) {
        int road_nodes = 4;

        List<Integer> roads_from = Arrays.asList(1, 3, 2, 4, 1);
        List<Integer> roads_to = Arrays.asList(3, 2, 1, 2, 4);
        List<Integer> roads_weight = Arrays.asList(20, 25, 15, 10, 5);

        List<Integer> result =
                getMinimumLength(road_nodes, roads_from, roads_to, roads_weight);

        System.out.println(result);
        // Expected: [60, 60, 60, 0]
    }
}
