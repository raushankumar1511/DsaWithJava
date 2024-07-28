package Graphs.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ShortestPathInDirectedAcyclicGraph {
    private void topSort(int node, List<List<int[]>> adj, int[] vis, Stack<Integer> st) {
        vis[node] = 1;
        for(int[] it: adj.get(node)){
            int v = it[0];
            if(vis[v] == 0){
                topSort(v,adj,vis,st);
            }
        }
        st.push(node);
    }

    public int[] shortestPath(int N,int M, int[][] edges) {
        //Code here
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adj.add(new ArrayList<int[]>());
        }
        for(int i =0;i < M ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new int[]{v,wt});
        }
        //find the topo sort
        int[] vis = new int[N];
        Stack<Integer> st = new Stack<>();
        for (int i = 0 ; i< N; i++){
            if(vis[i] == 0){
                topSort(i,adj,vis,st);
            }
        }
        //step 2 do the distance thing
        int[] dist = new int[N];
        Arrays.fill(dist,(int)1e9);
        dist[0] = 0;
        while (!st.isEmpty()){
            int node = st.pop();

            for(int[] it : adj.get(node)){
                int v = it[0];
                int wt = it[1];

                if(dist[node] + wt < dist[v]){
                    dist[v] = dist[node] + wt;
                }
            }
        }
return dist;
    }


}
