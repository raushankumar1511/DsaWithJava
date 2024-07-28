package Graphs.Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    private boolean check(int start,ArrayList<ArrayList<Integer>>adj ,int[] color){
        Queue<Integer > q = new LinkedList<>();

        q.offer(start);
        color[start] = 0;

        // Code here
        while(!q.isEmpty()){
            int node = q.poll();
            int nodeCol = color[node];

            for(int it: adj.get(node)){
                // if the adjacent node is not colored yet
                //color it with the opposite color
                if(color[it] == -1){
                    if(nodeCol == 0)color[it] = 1;
                    else color[it] = 0;
                    q.offer(it);
                }
                // is the adjacent node having the same color //
                //someone did color it on some other path
                else if(color[it] == nodeCol){
                    return false;
                }
            }
        }
     return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if(color[i] == -1){
                if(check(i, adj,color) == false){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkDfs(int node, ArrayList<ArrayList<Integer>>adj ,int[] color,int col){
        color[node] = col;
        int opp = (col == 0)?1:0;

        for(int it : adj.get(node)){
            if(color[it] == -1){
                if(!checkDfs(it,adj,color,1-col))return false;
            }
            else if(color[it] == col){
                return false;
            }
        }
        return true;
    }

    }
