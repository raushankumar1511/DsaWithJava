package Graphs.Questions;

import java.util.LinkedList;
import java.util.Queue;
 class Pair{
    int first;
    int second;
    public Pair(int row, int col){
        first = row;
        second = col;
    }
}
public class NoOfIslands {

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        int islands=0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if(grid[row][col] == '1' && !vis[row][col] ){
                    islands++;
                    bfs(row,col,vis,grid);
                }
            }
        }
        return islands;
    }

    private void bfs(int ro, int co, boolean[][] vis, char[][] grid) {
        vis[ro][co] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(ro,co));

        int n = grid.length;
        int m = grid[0].length;

        while (!queue.isEmpty()){
            Pair node = queue.poll();
            int row = node.first;
            int col = node.second;

            // traverse  in the neighbours and mark then if its a land;
            for(int delrow = -1; delrow <=1; delrow ++){
                for (int delcol = -1; delcol <= 1; delcol++) {
                    int nrow = row + delrow;
                    int ncol = col + delcol;
                    if(nrow >= 0 && nrow < n && ncol >=0 && ncol < m && grid[nrow][ncol] == '1' && !vis[nrow][ncol]){
                        vis[nrow][ncol] = true;
                        queue.add(new Pair(nrow,ncol));
                    }
                }
            }
        }
    }


    //2nd method
    public int numIslands2(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int islands=0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if(grid[row][col] == '1'){
                    islands++;
                    dfs(row,col,grid);
                }
            }
        }
        return islands;
    }
    private void dfs(int ro ,int co , char[][] grid){
        grid[ro][co] = '*';

        if(ro -1 >=0 && grid[ro -1][co] == '1'){
            dfs(ro -1 , co,grid);
        }
        if(ro + 1 < grid.length && grid[ro  + 1][co] == '1'){
            dfs(ro + 1 , co,grid);
        }
        if(co -1  >=0 && grid[ro][co - 1] == '1'){
            dfs(ro , co - 1,grid);
        }
        if(co+1 < grid[0].length && grid[ro][co +1] == '1'){
            dfs(ro, co + 1,grid);
        }
    }
}
