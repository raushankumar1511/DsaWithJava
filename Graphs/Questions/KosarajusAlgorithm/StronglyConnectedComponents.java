package Graphs.Questions.KosarajusAlgorithm;

import java.util.*;

public class StronglyConnectedComponents {
    void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj,
             Stack<Integer> st){
        vis[node] =1;
        for(int it: adj.get(node)){
            if(vis[it] == 0){
                dfs(it,vis,adj,st);
            }
        }
        st.push(node);
    }
    void dfs3(int node, int[] vis, ArrayList<ArrayList<Integer>> adjT){
        vis[node] =1;
        for(int it: adjT.get(node)){
            if(vis[it] == 0){
                dfs3(it,vis,adjT);
            }
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if(vis[i] == 0){
                dfs(i,vis,adj,st);
            }
        }

        ArrayList<ArrayList<Integer>> adjT = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<>());
        }

        //step 2 reverse the graph
        for (int i = 0; i < V; i++) {
            vis[i] = 0;
            for(int it: adj.get(i)){
                adjT.get(it).add(i);
            }
        }
        //step 3
        int scc = 0;
        while (!st.isEmpty()){
            int node = st.pop();
            if(vis[node] == 0){
                scc++;
                dfs3(node,vis,adjT);
            }
        }
        return scc;
    }
}
