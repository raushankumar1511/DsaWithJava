package Graphs.Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ToposortBFSieKhansAlgo {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj){
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for(int it : adj.get(i)){
                inDegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for (int it:adj.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    q.offer(it);
                }
            }
        }
        return topo.stream().mapToInt(Integer::intValue).toArray();
    }

}
