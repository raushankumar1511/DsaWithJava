package Graphs.Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule_toposort {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        //form a graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites){
            adj.get(pair[1]).add(pair[0]);
        }

        //topo sort;
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
        if(topo.size() == V) return true;
        else return false;
    }
}
