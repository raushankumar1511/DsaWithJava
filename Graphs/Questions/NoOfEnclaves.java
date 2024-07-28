package Graphs.Questions;

import java.util.LinkedList;
import java.util.Queue;

public class NoOfEnclaves {
    int[] drow = {-1,0,+1,0};
    int[] dcol = {0,+1,0,-1};
    private  void dfs(int row, int col, int[][] vis, int[][] mat) {
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;
        //check for top button left and right
        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 1){
                dfs(nrow,ncol, vis, mat);
            }
        }

    }
    public int numEnclaves(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        //traverse first and last row
        for(int j = 0 ; j<m; j++){
            //first row
            if( mat[0][j] == 1 &&  vis[0][j] == 0){
                dfs(0,j,vis,mat);
            }
            //last row
            if(mat[n-1][j] == 1 && vis[n-1][j] == 0){
                dfs( n-1,j,vis,mat);
            }
        }
        // traverse fist and last col
        for (int i = 0; i < n; i++) {
            //first col
            if( mat[i][0] == 1 &&  vis[i][0] == 0){
                dfs(i,0,vis,mat);
            }
            //last row
            if( mat[i][m-1] == 1 &&  vis[i][m -1] == 0){
                dfs(i,m-1,vis,mat);
            }
        }
int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mat[i][j] == 1 && vis[i][j] == 0){
                    count ++;
                }
            }
        }
return count;
    }

    public int numEnclaves2(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];

        Queue<int[]> q = new LinkedList<>();

        //traverse first and last row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i == 0 || i== n-1 || j == 0 || j == m-1){
                    if(mat[i][j] == 1){
                        q.add(new int[]{i,j});
                        vis[i][j] = 1;
                    }
                }
            }
        }
        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,+1,0,-1};
        while (!q.isEmpty()){
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];
            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                        && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 1){
                   q.add(new int[]{nrow,ncol});
                    vis[nrow][ncol] = 1;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mat[i][j] == 1 && vis[i][j] == 0){
                    count ++;
                }
            }
        }
        return count;
    }
}
