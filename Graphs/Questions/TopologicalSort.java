package Graphs.Questions;

import java.util.*;
public class TopologicalSort {
    private static void dfs(int node, int[] vis, ArrayList<ArrayList<Integer>> adj,Stack<Integer> st) {
        vis[node] =1;
        for (int it: adj.get(node)){
            if(vis[it] == 0){
                dfs(it,vis,adj,st);
            }
        }
        st.push(node);
    }
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // add your code here
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if(vis[i] == 0){
                dfs(i,vis,adj,st);
            }
        }

        int i = 0;
        int[] ans = new  int[V];
        while (!st.isEmpty()){
            ans[i++] = st.pop();
        }
        return ans;
    }
}
