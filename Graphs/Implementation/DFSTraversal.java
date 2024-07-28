package Graphs.Implementation;

import java.util.ArrayList;

public class DFSTraversal {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ls = new ArrayList<>();
        int[] vis= new int[V];

        int start=0;
        dfs(start, adj, vis, ls);

        return ls;
    }
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, ArrayList<Integer> ls){
        vis[node] =1;
        ls.add(node);

        //travels all its neighbours
        for(Integer it : adj.get(node)){
            if(vis[it] == 0){
                dfs(it,adj, vis, ls);
            }
        }
    }
}
