package com.ds.leetcode.first_time;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q207_CourseSchedule {

	private static boolean canFinishBFS(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = new ArrayList[numCourses];
		int[] inDegree = new int[numCourses];

		Queue<Integer> queue = new LinkedList<>();
		int count = 0;

		// Initialize adjacency list
		for (int i = 0; i < numCourses; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int[] arr : prerequisites) {
			int courseX = arr[1];
			int courseThatDependsOnX = arr[0];
			inDegree[courseThatDependsOnX]++; // Build In Degree Array
			graph[courseX].add(courseThatDependsOnX); // Fill adjacency list
		}

		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
				count++;
			}
		}

		while (!queue.isEmpty()) {
			int course = queue.poll();
			for (int i = 0; i < graph[course].size(); i++) {
				int dependentCourse = graph[course].get(i);
				inDegree[dependentCourse]--;
				if (inDegree[dependentCourse] == 0) {
					queue.add(dependentCourse);
					count++;
				}
			}
		}

		return (count == numCourses);
	}

	private static boolean canFinishDFS(int numCourses, int[][] prerequisites) {
		List<Integer>[] graph = new ArrayList[numCourses];
		boolean[] visited = new boolean[numCourses];
		boolean[] memo = new boolean[numCourses];

		// Initialize adjacency list
		for (int i = 0; i < numCourses; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int[] arr : prerequisites) {
			int courseX = arr[1];
			int courseThatDependsOnX = arr[0];
			graph[courseX].add(courseThatDependsOnX); // Fill adjacency list
		}

		for (int i = 0; i < numCourses; i++) {
			if (!dfs(graph, visited, i, memo))
				return false;
		}
		return true;
	}

	private static boolean dfs(List[] graph, boolean[] visited, int course, boolean[] memo) {
		if (visited[course])
			return false;
		if (memo[course])
			return true;

		visited[course] = true;
		for (int i = 0; i < graph[course].size(); i++) {
			if (!dfs(graph, visited, (int) graph[course].get(i), memo))
				return false;
		}
		visited[course] = false;
		memo[course] = true;
		return true;
	}

	public static void main(String[] args) {

	}
}
