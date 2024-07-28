package Graphs.Questions.DijkstraAlgoQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheapestFlightWithinKsteps {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
          ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] it : flights){
            adj.get(it[0]).add(new int[]{it[1],it[2]});
        }

        Queue<int[]> q =new LinkedList<>();
        q.offer(new int[]{0,src,0});
        int[] dist = new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;

        while (!q.isEmpty()){
            int[] temp = q.poll();
            int stops = temp[0];
            int node = temp[1];
            int cost = temp[2];

            if(stops > k)continue;
            for(int[] it : adj.get(node)){
                int adjNode = it[0];
                int edW = it[1];

                if(cost + edW < dist[adjNode] && stops <= k){
                    dist[adjNode] = cost + edW;
                    q.offer(new int[]{stops +1 , adjNode, cost + edW});
                }
            }
        }

        if(dist[dst] == 1e9)return -1;
        return dist[dst];
    }
}
