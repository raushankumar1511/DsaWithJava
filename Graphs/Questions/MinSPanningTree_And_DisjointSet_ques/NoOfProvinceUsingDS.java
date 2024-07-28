package Graphs.Questions.MinSPanningTree_And_DisjointSet_ques;
import java.util.*;
public class NoOfProvinceUsingDS {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        DisjointSet1 ds = new DisjointSet1(V);
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if(adj.get(i).get(j) == 1){
                    ds.unionBySize(i,j);
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < V; i++) {
            if(ds.parent.get(i) == i){
                cnt++;
            }
        }
        return cnt;
    }
}
