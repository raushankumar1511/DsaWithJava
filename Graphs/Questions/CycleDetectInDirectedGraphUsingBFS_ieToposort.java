package Graphs.Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CycleDetectInDirectedGraphUsingBFS_ieToposort {
    boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj){
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

        int cntTopSortEle = 0;
        while (!q.isEmpty()){
            int node = q.poll();
           cntTopSortEle++;
            for (int it:adj.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0){
                    q.offer(it);
                }
            }
        }
        return cntTopSortEle != V;
    }

}
