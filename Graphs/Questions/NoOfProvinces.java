package Graphs.Questions;

import java.util.ArrayList;

public class NoOfProvinces {
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis) {
        vis[node] = 1;
        for (Integer it : adj.get(node)) {
            if(vis[it] == 0) {
                dfs(it, adj, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;

        ArrayList<ArrayList<Integer>> adjLs = new ArrayList<>();
        for (int i = 0; i< V ; i++){
            adjLs.add(new ArrayList<>());
        }
        // change adjacency matrix to adjacency list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if(isConnected[i][j] == 1 && i !=j ){
                    adjLs.get(i).add(j);
                    adjLs.get(j).add(i);
                }
            }
        }

        // visited array
        int[] vis = new int[V];
        int cnt = 0;

        for (int i = 0; i < V; i++) {
            if(vis[i] == 0){
                cnt++;
                dfs(i,adjLs,vis);
            }
        }
        return cnt;
    }

    // without creating adjacency list
    public int findCircleNum2(int[][] isConnected) {
        int n = isConnected.length;
        int connected = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                connected++;
                dfs2(i, visited, isConnected);
            }
        }
        return connected;
    }

    private void dfs2(int node, boolean[] visited, int[][] isConnected) {
        visited[node] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i] && isConnected[node][i] == 1) {
                dfs2(i, visited, isConnected);
            }
        }
    }
}
