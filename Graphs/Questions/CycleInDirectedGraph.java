package Graphs.Questions;

import java.util.ArrayList;

public class CycleInDirectedGraph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] vis = new int[V];
        int[] pathVis = new int[V];

        for (int i = 0; i < V; i++) {
            if(vis[i] == 0){
                if(dfsCheck(i, adj, vis, pathVis))return true;
            }
        }
        return false;
    }

    private boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathVis) {
        vis[node] = 1;
        pathVis[node] = 1;
        // traverse for adjacent node
        for ( int it : adj.get(node)){
            if(vis[it] == 0){
                if(dfsCheck(it,adj,vis,pathVis))return true;
            }else if(pathVis[it] == 1){
                    return true;
            }
        }
        pathVis[node] = 0;
        return false;
    }
}
