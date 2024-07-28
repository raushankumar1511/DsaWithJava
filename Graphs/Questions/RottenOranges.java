package Graphs.Questions;

import java.util.*;

public class RottenOranges {
    public int orangesRotting(int[][] grid){
        if(grid == null && grid.length == 0)return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[] > queue = new LinkedList<>();
        int[][] vis = new int[rows][cols];
        int count_fresh = 0;
        // put the position of all rotten oranges in queue and count the no of fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    vis[i][j] = 2;
                }else{
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1){
                    count_fresh++;
                }
            }
        }

        if(count_fresh == 0) return 0;
        int mins =0, cnt =0;
        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,+1,0,-1};

        // bfs starting form initially rotten organges
        while(!queue.isEmpty()){
            int size = queue.size();
            cnt += size;
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nrow = cell[0] + drow[j];
                    int ncol = cell[1] + dcol[j];

                    if(nrow >= 0 && ncol >= 0 && nrow < rows && ncol < cols && grid[nrow][ncol] == 1 && vis[nrow][ncol] ==0){
                        queue.offer(new int[]{nrow,ncol});
                        vis[nrow][ncol]= 2;
                    }
                }
            }

            if(!queue.isEmpty()){
                mins++;
            }
        }
        return count_fresh == cnt ? mins : -1;
    }
}
