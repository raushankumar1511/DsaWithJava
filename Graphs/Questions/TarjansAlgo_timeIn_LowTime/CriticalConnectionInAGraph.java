package Graphs.Questions.TarjansAlgo_timeIn_LowTime;
import java.util.*;
public class CriticalConnectionInAGraph {
    private int timer = 1;
    private void dfs(int node, int parent, int[] vis,
                     ArrayList<ArrayList<Integer>> adj,
                     int[] tin, int[] low, List<List<Integer>> bridges) {
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer ++;
        for(int it: adj.get(node)){
            if(it == parent)continue;
            if(vis[it] == 0){
                dfs(it,node,vis,adj,tin,low,bridges);
                low[node] = Math.min(low[it] ,low[node]);
                //node --- it is it is bridge
                if(low[it] > tin[node]){
                    bridges.add(Arrays.asList(it,node));
                }
            }else {
                low[node] = Math.min(low[node] , low[it]);
            }
        }
    }
    //Tc = O(v+2E) SC = O(v+2E) + O(3N)
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>>  adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(List<Integer> it: connections){
            adj.get(it.get(0)).add(it.get(1));
            adj.get(it.get(1)).add(it.get(0));
        }
        int[] vis = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        int node =3;
        int parent =3;
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(0,-1,vis,adj,tin,low,bridges);
        return bridges;
    }

}
