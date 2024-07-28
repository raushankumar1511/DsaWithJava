package Graphs.Questions.DijkstraAlgoQuestions;

import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0 ; i<= n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it: times){
            adj.get(it[0]).add(new int[]{it[1], it[2]});
        }
        int dist[] = new int[n+1];
        Arrays.fill(dist, (int)1e9);
        dist[k]= 0;

        Queue<int[] > q = new LinkedList<>();

        q.offer(new int[]{0,k});

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int dis = temp[0];
            int node = temp[1];

            for(int[] it:adj.get(node)){
                int adjNode = it[0];
                int edW = it[1];
                if(dis + edW < dist[adjNode]){
                    dist[adjNode] = dis + edW;
                    q.offer(new int[]{dis + edW, adjNode});
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 1 ; i<= n; i++){
            ans = Math.max(ans,dist[i]);
        }

        return (ans != 1e9)?  ans:-1;
    }
}
