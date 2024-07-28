package Graphs.Questions;
import java.util.*;
public class DetectCycleUndirectedGraph {

    boolean detectBFS(int src, ArrayList<ArrayList<Integer>> adj, int[] vis){
        vis[src] = 1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src,-1});
        while(!q.isEmpty()){
            int node = q.peek()[0];
            int parent = q.peek()[1];
            q.poll();
            for(int adjacentNode : adj.get(node)){
                if(vis[adjacentNode] == 0){
                    vis[adjacentNode] = 1;
                    q.add(new int[]{adjacentNode, node});
                }else{
                    if(adjacentNode != parent ){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];

        for(int i = 0; i< V; i++){
            if(vis[i] == 0){
                //bfs method
                if(detectBFS(i,adj,vis)) return true;

                // dfs method
//                if(dfsDetect(i,-1,vis,adj) == true){
//                    return true;
//                }
            }
        }
        return false;

    }

    private boolean dfsDetect(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = 1;
        for (int it: adj.get(node)){
            if(vis[it] == 0){
                if(dfsDetect(it, node, vis, adj)){
                    return true;
                }else if(it != parent){
                    return true;
                }
            }
        }
        return false;
    }
}
