package Graphs.Questions;

import java.util.*;

public class FindSafeNodesUsingCycleDetection {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] vis = new int[V];
        int[] pathVis = new int[V];
        int[] check = new int[V];

        List<Integer> safeNodes = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if(vis[i] == 0){
                dfsCheck(i, graph, vis, pathVis,check);
            }
        }
        for(int node : check){
            if(node == 1){
                safeNodes.add(node);
            }
        }
        return safeNodes;
    }

    private boolean dfsCheck(int node, int[][] adj, int[] vis, int[] pathVis ,int[] check) {
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;
        // traverse for adjacent node
        for ( int it : adj[node]){
            if(vis[it] == 0){
                //dfs returns true means its a cyclic and that node is not a safe node
                if(dfsCheck(it,adj,vis,pathVis,check))return true;
            }else if(pathVis[it] == 1){
                return true;
            }
        }
        //dfs call over and not find cycle means this node eventually leads to terminal node
        //so it is a safe node
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
}
