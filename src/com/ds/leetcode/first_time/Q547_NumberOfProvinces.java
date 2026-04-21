package com.ds.leetcode.first_time;

public class Q547_NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(isConnected, visited, i);
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, boolean[] visited, int city) {
        int cols = isConnected.length;

        visited[city] = true;

        for (int cur = 0; cur < cols; cur++) {
            if (isConnected[city][cur] == 1 && !visited[cur]) {
                visited[cur] = true;
                dfs(isConnected, visited, cur);
            }
        }
    }

	public static void main(String[] args) {

	}
}
