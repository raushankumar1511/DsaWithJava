package Graphs.Questions.MinSPanningTree_And_DisjointSet_ques;

import java.util.*;

class DisjointSet{
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n){
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node){
        if (node == parent.get(node))
            return node;
        int ulp = findUPar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        // if ultimate parent is equal then no need to join them again
        // because both belog to same component
        if(ulp_u == ulp_v)return;
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u , ulp_v);
        }
        else if(rank.get(ulp_v) < rank.get(ulp_u)){
            parent.set(ulp_v , ulp_u);
        }
        else {
            parent.set(ulp_v,ulp_u);
            rank.set(ulp_u, rank.get(ulp_u)+1);

        }
    }

    public void unionBySize(int u, int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        // if ultimate parent is equal then no need to join them again
        // because both belog to same component
        if(ulp_u == ulp_v)return;
        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u , ulp_v);
            size.set(ulp_v,size.get(ulp_v) + size.get(ulp_u));
        }
        else {
            parent.set(ulp_v , ulp_u);
            size.set(ulp_u,size.get(ulp_u) + size.get(ulp_v));
        }
    }

}
public class MaximumStonesRemoval {
    public int removeStones(int[][] stones) {

        int n = stones.length;
        int maxRow = 0;
        int maxCol = 0;
        for(int[] it : stones){
            maxRow = Math.max(maxRow, it[0]);
            maxCol  = Math.max(maxCol, it[1]);
        }
        DisjointSet ds  = new DisjointSet(maxRow + maxCol +1);
        Map<Integer,Integer> stonesNodes = new HashMap<>();
        for(int[] it : stones){
            int nodeRow =it[0];
            int nodeCol = it[1] + maxRow +1;
            ds.unionBySize(nodeRow,nodeCol);
            stonesNodes.put(nodeRow,1);
            stonesNodes.put(nodeCol,1);
        }
        int cnt = 0;
        for(int it: stonesNodes.keySet()){
            if(ds.findUPar(it) == it){
                cnt++;
            }
        }
        return n - cnt;
    }

}
