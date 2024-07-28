package Graphs.Questions;

import java.util.*;

public class DistinctIslands {
    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        Set<ArrayList<Integer>> ans = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1 && vis[i][j] == 0){
                    ArrayList<Integer> list = new ArrayList<>();
                    dfs(i,j,grid,vis,list,i,j);
                    ans.add(list);
                }
            }
        }
        return ans.size();
    }

    private void dfs(int row, int col, int[][] grid,int[][] vis, ArrayList<Integer> list, int rowB, int colB) {
        list.add(row-rowB);
        list.add(col-colB);
        vis[row][col] = 1;

        int n = grid.length;
        int m = grid[0].length;

        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,+1,0,-1};

        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow >= 0 && nrow< n && ncol >= 0 && ncol < m &&
            grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
                vis[nrow][ncol] = 1;
                dfs(nrow,ncol,grid,vis,list,rowB,colB);
            }
        }
    }
}
