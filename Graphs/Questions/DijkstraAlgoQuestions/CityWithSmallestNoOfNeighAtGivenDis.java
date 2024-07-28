package Graphs.Questions.DijkstraAlgoQuestions;

import java.util.*;

public class CityWithSmallestNoOfNeighAtGivenDis {
    private void dijkstra(ArrayList<ArrayList<int[]>> adj, int[] dist, int src ,int maxDis){
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> x[0] - y[0]);
        dist[src] =0;
        pq.offer(new int[]{0,src});

        while (!pq.isEmpty()){
            int[] temp = pq.poll();
            int node = temp[1];
            int dis = temp[0];

            for(int[] it: adj.get(node)){
                int adjNode = it[0];
                int edW = it[1];

                if(dis + edW <= maxDis && dist[adjNode] > dis + edW){
                    dist[adjNode] = dis + edW;
                    pq.offer(new int[]{dis + edW, adjNode});
                }
            }

        }
    }
    public int findTheCity2(int n , int[][] edges,int maxDis){
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] it : edges){
            adj.get(it[0]).add(new int[]{it[1],it[2]});
            adj.get(it[1]).add(new int[]{it[0],it[2]});
        }

        int[] cityReached = new int[n];
        for(int src = 0; src <n; src++){
          int[] dist = new int[n];
          Arrays.fill(dist,(int)1e9);
          dijkstra(adj,dist,src,maxDis);

          int cnt = 0;
            for (int i = 0; i < n; i++) {
                if(dist[i] != 1e9 && i != src){
                    cnt++;
                }
            }
          cityReached[src] = cnt;
        }
        int cntCity =n;
        int cityNo = -1;
        for (int i = 0 ; i< n ; i++){
            if(cityReached[i] <= cntCity){
                cntCity = cityReached[i];
                cityNo = i;
            }
        }
        return cityNo;
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dist = new int[n][n];
        for(int[] it: dist){
            Arrays.fill(it,Integer.MAX_VALUE);
        }

        for(int[] it : edges){
            dist[it[0]][it[1]] = it[2];
            dist[it[1]][it[0]] = it[2];
        }
        for(int i = 0; i < n ;i++) dist[i][i] = 0;

        for(int k= 0; k <n ; k++){
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE){
                        continue;
                    }
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int cntCity = n;
        int cityNo = -1;
        for(int city = 0; city <n ; city ++){
            int cnt = 0;
            for(int adjCity = 0; adjCity < n ; adjCity++){
                if(dist[city][adjCity] <= distanceThreshold){
                    cnt++;
                }
            }
            if(cnt <= cntCity){
                cntCity = cnt;
                cityNo = city;
            }
        }
        return cityNo;
    }
}
