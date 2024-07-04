package Graphs.Implementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSTraversal {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
       ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V];

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()){

            Integer node = queue.poll();
            bfs.add(node);
            for (Integer num: adj.get(node)){
                if(!visited[num]){
                    queue.add(num);
                    visited[num] = true;
                }
            }
        }
        return bfs;

    }
}
