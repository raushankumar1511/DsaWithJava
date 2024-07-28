package Graphs.Questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDisInBinaryMaze {
    int shortestPath(int[][] grid, int[] source, int[] destination) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][m];
        for(int[] it: dist){
            Arrays.fill(it,(int)1e9);
        }
        q.add(new int[]{0,source[0],source[1]});
        dist[source[0]][source[1]] = 0;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while (!q.isEmpty()){
            int[] temp = q.poll();
            int dis = temp[0];
            int row = temp[1];
            int col = temp[2];

            for(int i = 0; i< 4; i++){
                int newr = row + dr[i];
                int newc = col + dc[i];
                if(newr >= 0 && newr < n && newc >= 0 && newc < m &&
                grid[newr][newc] == 1 && dist[newr][newc] > dis +1){
                    if(newr == destination[0] && newc == destination[1])return dis +1;
                    grid[newr][newc] = dis +1;
                    q.add(new int[]{dis+1, newr, newr});
                }

            }
        }
        return -1;
    }
}
