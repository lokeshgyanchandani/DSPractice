package com.ds.graph;

import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
    private static void explore(ArrayList<Integer>[] adj, int vertex, boolean[] visited) {

        if(visited[vertex]) return;
        visited[vertex] = true;
        for(int i = 0; i < adj[vertex].size(); i++) {
            explore(adj, adj[vertex].get(i), visited);
        }
    }
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0;
        //write your code here
        boolean[] visited = new boolean[adj.length];

        for(int i = 0; i < adj.length; i++) {
            if(visited[i]) {
                explore(adj, i, visited);
                result = result + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}

