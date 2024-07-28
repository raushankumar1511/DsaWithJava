package Graphs.Questions;

import java.util.*;

public class ShortestDistanceUndirectedGraph {
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] it: edges){
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }
        //distance arry
        int[] dist = new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);

        while (!q.isEmpty()){
            int node = q.poll();
            for(int it : adj.get(node)){
                if(dist[node] +1 < dist[it]){
                    dist[it] = dist[node] +1;
                    q.add(it);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(dist[i] == 1e9){
                dist[i] = -1;
            }
        }
return dist;
    }
}
