package com.ds.companies.x_no_company_x;

import java.util.LinkedList;

// This class represents a directed graph using adjacency list
// representation
public class Graph {
	private int V; // No. of vertices

	// Array of lists for Adjacency List Representation
	private LinkedList<Integer> adj[];

	// Constructor
	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	// Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w); // Add w to v's list.
	}

	// A function used by DFSApplications
	boolean DFSUtil(int v, boolean visited[], boolean[] stack) {
		// Mark the current node as visited and print it
		visited[v] = true;
		stack[v] = true;
		// System.out.print(v + " ");

		// Recur for all the vertices adjacent to this vertex
		for (Integer x : adj[v]) {
			if (!visited[x] && DFSUtil(x, visited, stack))
				return true;
			else if (stack[x])
				return true;
		}
		stack[v] = false;
		return false;
	}

	// The function to do DFSApplications traversal. It uses recursive DFSUtil()
	void DFS(int v) {
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[V];
		boolean[] stack = new boolean[V];
		// Call the recursive helper function to print DFSApplications traversal
		for (int i = 0; i < V; i++)
			if (DFSUtil(v, visited, stack))
				System.out.println("true");
		System.out.println(false);
	}

	public static void main(String args[]) {

		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");
		g.DFS(2);
	}
}
// This code is contributed by Aakash Hasija
