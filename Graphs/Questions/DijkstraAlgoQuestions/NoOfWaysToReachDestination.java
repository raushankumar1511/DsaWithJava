package Graphs.Questions.DijkstraAlgoQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair2{
    long dis;
    long node;
    public Pair2(long dis,long node){
        this.dis=dis;
        this.node=node;
    }
}
public class NoOfWaysToReachDestination {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair2>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair2(roads[i][2],roads[i][1]));
            adj.get(roads[i][1]).add(new Pair2(roads[i][2],roads[i][0]));
        }
        PriorityQueue<Pair2> pq = new PriorityQueue<>((x,y)->Long.compare(x.dis, y.dis));
        long dis[]=new long[n];
        long ways[]=new long[n];
        for(int i=0;i<n;i++){
            dis[i]=Long.MAX_VALUE;
            ways[i]=0;
        }
        pq.add(new Pair2(0,0));
        dis[0]=0;
        ways[0]=1;
        int mod = (int) (1e9 + 7);
        while(!pq.isEmpty()){
            long currDis=pq.peek().dis;
            int node=(int)(pq.peek().node);
            pq.remove();
            for(Pair2 it: adj.get(node)){
                int adjNode = (int)it.node;
                long edgeWeight = it.dis;

                // this is the first time with this short distance
                if(currDis+edgeWeight<dis[adjNode]){
                    dis[adjNode]=currDis+edgeWeight;
                    ways[adjNode]=ways[node];
                    pq.add(new Pair2(currDis+edgeWeight,adjNode));
                }else if(currDis+edgeWeight==dis[adjNode]){
                    ways[adjNode]= (ways[adjNode]+ways[node])%mod;
                }
            }
        }
        return (int)(ways[n-1]%mod);
    }
}
