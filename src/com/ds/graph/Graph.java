package com.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {

    private boolean isDirected = false;
    private List<Edge<T>> allEdges;
    private Map<Long, Vertex<T>> allVertex;

    Graph(boolean isDirected) {
        this.isDirected = isDirected;
        allEdges = new ArrayList<>();
        allVertex = new HashMap<>();
    }

    void addEdge(long id1, long id2) {
        addEdge(id1, id2, 0);
    }

    void addEdge(long id1, long id2, int weight) {
        Vertex<T> vertex1;
        if (allVertex.containsKey(id1)) {
            vertex1 = allVertex.get(id1);
        } else {
            vertex1 = new Vertex<>(id1);
            allVertex.put(id1, vertex1);
        }

        Vertex<T> vertex2;
        if (allVertex.containsKey(id2)) {
            vertex2 = allVertex.get(id2);
        } else {
            vertex2 = new Vertex<>(id2);
            allVertex.put(id2, vertex2);
        }

        Edge<T> edge = new Edge<>(vertex1, vertex2, isDirected);
        if (!allEdges.contains(edge))
            allEdges.add(edge);
        vertex1.addAdjacentVertex(edge, vertex2);
        if (!isDirected)
            vertex2.addAdjacentVertex(edge, vertex1);
    }

    Map<Long, Vertex<T>> getAllVertex() {
        return allVertex;
    }

    List<Edge<T>> getAllEdges() {
        return allEdges;
    }

    boolean isDirected() {
        return isDirected;
    }
}

class Vertex<T> {
    private long id;
    private List<Edge<T>> edges;
    private List<Vertex<T>> adjacentVertex;

    Vertex(long id) {
        this.id = id;
        this.edges = new ArrayList<>();
        this.adjacentVertex = new ArrayList<>();
    }

    void addAdjacentVertex(Edge<T> edge, Vertex<T> vertex) {
        edges.add(edge);
        adjacentVertex.add(vertex);
    }

    long getId() {
        return id;
    }

    List<Edge<T>> getEdges() {
        return edges;
    }

    List<Vertex<T>> getAdjacentVertex() {
        return adjacentVertex;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (id != other.id)
            return false;
        return true;
    }
}

class Edge<T> {
    private boolean isDirected;
    private Vertex<T> vertex1;
    private Vertex<T> vertex2;
    private int weight;

    Edge(Vertex<T> vertex1, Vertex<T> vertex2) {
        this(vertex1, vertex2, false);
    }

    Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected) {
        this(vertex1, vertex2, isDirected, 0);
    }

    Edge(Vertex<T> vertex1, Vertex<T> vertex2, boolean isDirected, int weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.isDirected = isDirected;
        this.weight = weight;
    }

    Vertex<T> getVertex1() {
        return vertex1;
    }

    Vertex<T> getVertex2() {
        return vertex2;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
        result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Edge other = (Edge) obj;
        if (vertex1 == null) {
            if (other.vertex1 != null)
                return false;
        } else if (!vertex1.equals(other.vertex1))
            return false;
        if (vertex2 == null) {
            if (other.vertex2 != null)
                return false;
        } else if (!vertex2.equals(other.vertex2))
            return false;
        return true;
    }
}
