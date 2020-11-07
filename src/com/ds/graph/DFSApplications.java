package com.ds.graph;

import java.util.*;

public class DFSApplications<T> {

    private void DFSUtil(Vertex<T> vertex, Set<Vertex<T>> visited, Deque<Vertex<T>> stack) {
        for (Vertex<T> childVertex : vertex.getAdjacentVertex()) {
            if (visited.contains(childVertex))
                continue;
            stack.add(childVertex);
            visited.add(childVertex);
            DFSUtil(childVertex, visited, stack);
        }
    }

    private Deque<Vertex<T>> DFS(Graph<T> graph) {
        Deque<Vertex<T>> stack = new ArrayDeque<>();
        Set<Vertex<T>> visited = new HashSet<>();
        for (Vertex<T> vertex : graph.getAllVertex().values()) {
            if (visited.contains(vertex))
                continue;
            stack.add(vertex);
            visited.add(vertex);
            DFSUtil(vertex, visited, stack);
        }
        return stack;
    }

    private void topSortUtil(Vertex<T> vertex, Set<Vertex<T>> visited, Deque<Vertex<T>> stack) {
        for (Vertex<T> childVertex : vertex.getAdjacentVertex()) {
            if (visited.contains(childVertex))
                continue;
            visited.add(childVertex);
            topSortUtil(childVertex, visited, stack);
            stack.addFirst(childVertex);
        }
    }

    private Deque<Vertex<T>> topSort(Graph<T> graph) {
        Deque<Vertex<T>> stack = new ArrayDeque<>();
        Set<Vertex<T>> visited = new HashSet<>();
        for (Vertex<T> vertex : graph.getAllVertex().values()) {
            if (visited.contains(vertex))
                continue;
            visited.add(vertex);
            topSortUtil(vertex, visited, stack);
            stack.addFirst(vertex);
        }
        return stack;
    }

    private boolean cycleInUndirectedGraphUtil(Vertex<T> vertex,
                                               Set<Vertex<T>> visited,
                                               Vertex<T> parent) {
        visited.add(vertex);
        for (Vertex<T> childVertex : vertex.getAdjacentVertex()) {
            if (childVertex.equals(parent)) {
                continue;
            }
            if (visited.contains(childVertex)) {
                return true;
            }
            if (cycleInUndirectedGraphUtil(childVertex, visited, vertex))
                return true;
        }
        return false;
    }

    private boolean cycleInUndirectedGraph(Graph<T> graph) {
        Set<Vertex<T>> visited = new HashSet<>();
        for (Vertex<T> vertex : graph.getAllVertex().values()) {
            if (visited.contains(vertex))
                continue;
            if (cycleInUndirectedGraphUtil(vertex, visited, null))
                return true;
        }
        return false;
    }

    private boolean cycleInDirectedGraphUtil(Vertex<T> vertex,
                                             Set<Vertex<T>> visited,
                                             Set<Vertex<T>> currentVisited) {
        visited.add(vertex);
        currentVisited.add(vertex);
        for (Vertex<T> childVertex : vertex.getAdjacentVertex()) {
            if (currentVisited.contains(childVertex))
                return true;
            if (cycleInDirectedGraphUtil(childVertex, visited, currentVisited))
                return true;
        }
        return false;
    }

    private boolean cycleInDirectedGraph(Graph<T> graph) {
        Set<Vertex<T>> visited = new HashSet<>();
        for (Vertex<T> vertex : graph.getAllVertex().values()) {
            if (visited.contains(vertex))
                continue;
            Set<Vertex<T>> currentVisited = new HashSet<>();
            if (cycleInDirectedGraphUtil(vertex, visited, currentVisited))
                return true;
        }
        return false;
    }

    private Graph<T> reverseDirectedGraph(Graph<T> graph) {
        Graph<T> reversedGraph = new Graph<>(true);
        for (Edge<T> edge : graph.getAllEdges()) {
            reversedGraph.addEdge(edge.getVertex2().getId(), edge.getVertex1().getId());
        }
        return reversedGraph;
    }

    private void stronglyConnectedComponentsUtil(Vertex<T> vertex,
                                                 Set<Vertex<T>> visited,
                                                 Set<Vertex<T>> resultSet) {
        resultSet.add(vertex);
        visited.add(vertex);
        for (Vertex<T> childVertex : vertex.getAdjacentVertex()) {
            if (visited.contains(childVertex))
                continue;
            stronglyConnectedComponentsUtil(childVertex, visited, resultSet);
        }
    }

    private List<Set<Vertex<T>>> stronglyConnectedComponents(Graph<T> graph) {
        Deque<Vertex<T>> stack = DFS(graph);
        Graph<T> reversedGraph = reverseDirectedGraph(graph);
        List<Set<Vertex<T>>> results = new ArrayList<>();
        Set<Vertex<T>> visited = new HashSet<>();
        while (!stack.isEmpty()) {
            Vertex<T> vertex = stack.poll();
            if (!visited.contains(vertex)) {
                Set<Vertex<T>> result = new HashSet<>();
                stronglyConnectedComponentsUtil(reversedGraph.getAllVertex().get(vertex.getId()),
                                                visited,
                                                result);
                results.add(result);
            }
        }
        return results;
    }

    public static void main(String args[]) {
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);

        DFSApplications<Integer> dfsApplications = new DFSApplications<>();

        // DEPTH FIRST SEARCH
        /*Deque<Vertex<Integer>> result = dfsApplications.DFS(graph);
        while (!result.isEmpty()) {
            Vertex vertex = result.poll();
            System.out.print(vertex.getId() + " -> ");
        }*/

        // TOPOLOGICAL SORTING
        /*Deque<Vertex<Integer>> result = dfsApplications.topSort(graph);
        while (!result.isEmpty()) {
            Vertex vertex = result.poll();
            System.out.print(vertex.getId() + " -> ");
        }*/

        // CYCLE IN UNDIRECTED GRAPH
        /*System.out.println(dfsApplications.cycleInUndirectedGraph(graph));*/

        // CYCLE IN DIRECTED GRAPH
        System.out.println(dfsApplications.cycleInDirectedGraph(graph));

        // REVERSE A DIRECTED GRAPH
        // STRONGLY CONNECTED COMPONENTS
        /*List<Set<Vertex<Integer>>> stronglyConnectedComponents =
                dfsApplications.stronglyConnectedComponents(graph);
        for (Set<Vertex<Integer>> stronglyConnectedComponent : stronglyConnectedComponents) {
            for (Vertex<Integer> vertex : stronglyConnectedComponent) {
                System.out.print(vertex.getId() + ", ");
            }
            System.out.println();
        }*/
    }
}
