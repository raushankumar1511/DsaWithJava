package Graphs.Questions.MinSPanningTree_And_DisjointSet_ques;


import java.util.ArrayList;
import java.util.*;
import java.util.List;

class DSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DSet(int n){
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
public class MakingALargeIsland {
    private boolean isValid(int newr, int newc, int n) {
        return newr >= 0 && newr < n && newc >= 0 && newc < n;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSet ds = new DSet(n * n);

        //step 1;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if(grid[row][col] == 0)continue;
                int[] dr = {-1,0,1,0};
                int[] dc = {0,-1,0,1};
                for (int ind = 0; ind< 4; ind++){
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if(isValid(newr,newc,n) && grid[newr][newc] == 1){
                        int nodeNo = row * n + col;
                        int adjNodeNo = newr * n + newc;
                        ds.unionBySize(nodeNo,adjNodeNo);
                    }
                }
            }
        }
        //step 2
        int max = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if(grid[row][col] == 1)continue;
                int[] dr = {-1,0,1,0};
                int[] dc = {0,-1,0,1};
                Set<Integer> components = new HashSet<>();
                for (int ind = 0; ind< 4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if (isValid(newr, newc, n)) {
                        if(grid[newr][newc] == 1){
                            components.add(ds.findUPar(newr *n + newc));
                        }
                    }
                }
                int sizeTotal = 0;
                for(int it : components){
                    sizeTotal += ds.size.get(it);
                }
                max = Math.max(max,sizeTotal+1);
            }
        }
        for(int cellNo = 0; cellNo < n; cellNo ++){
            max = Math.max(max, ds.size.get(ds.findUPar(cellNo)));
        }
        return max;
    }
}
