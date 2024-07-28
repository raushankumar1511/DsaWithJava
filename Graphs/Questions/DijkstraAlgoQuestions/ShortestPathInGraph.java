package Graphs.Questions.DijkstraAlgoQuestions;

import java.util.*;
public class ShortestPathInGraph {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i<= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it : edges){
            adj.get(it[0]).add(new int[]{it[1],it[2]});
            adj.get(it[1]).add(new int[]{it[0],it[2]});
        }
        PriorityQueue<int[]> pq= new PriorityQueue<>((x,y) -> x[0] - y[0]);
        int[] dist = new int[n + 1]; Arrays.fill(dist, (int) 1e9);
        int[] parent = new int[n + 1];
        for(int i = 1 ; i<= n ; i++)parent[i] = i;

        dist[1] = 0;
        pq.add(new int[]{0,1});
        while(!pq.isEmpty()){
            int dis = pq.peek()[0];
            int node = pq.peek()[1];
            pq.poll();

            for(int[] it : adj.get(node)){
                int adjNode = it[0];
                int edjW = it[1];

                if(dis + edjW < dist[adjNode]){
                    dist[adjNode] = dis + edjW;
                    pq.add(new int[]{dist[adjNode], adjNode});
                    parent[adjNode] = node;
                }
            }

        }
        List<Integer> path = new ArrayList<>();
        if(dist[n] == 1e9) {
            path.add(-1);
            return path;
        }

        int node = n;

        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        path.add(0,dist[n]);
        return path;
    }
}
