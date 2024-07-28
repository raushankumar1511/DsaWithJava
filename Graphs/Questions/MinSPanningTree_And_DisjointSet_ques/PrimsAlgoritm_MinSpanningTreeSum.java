package Graphs.Questions.MinSPanningTree_And_DisjointSet_ques;

import java.util.*;

public class PrimsAlgoritm_MinSpanningTreeSum {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[0] - y[0]);
        int vis[] = new int[V];
        // weight, parent
        pq.offer(new int[]{0,0});

        int sum = 0;
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int node =temp[1];
            int wt = temp[0];

            if(vis[node] ==1 )continue;
            vis[node] = 1;

            sum = sum + wt;

            for(int[] it : adj.get(node)){
                int adjNode = it[0];
                int edW = it[1];
                if(vis[adjNode] == 0 ){
                    pq.offer(new int[]{edW, adjNode});
                }
            }
        }
        return sum;
    }
}
