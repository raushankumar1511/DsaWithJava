package Graphs.Questions.DijkstraAlgoQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinEffort {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[m][n];

        for(int[] it: dist){
            Arrays.fill(it,(int)1e9);
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((x,y) -> x[0] - y[0]);
        q.add(new int[]{0,0,0});

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        while (!q.isEmpty()){
            int[] temp = q.poll();
            int effort = temp[0];
            int row = temp[1];
            int col = temp[2];

            if(row == n-1 && col == m -1)return effort;
            for(int i = 0; i< 4; i++){
                int newr = row + dr[i];
                int newc = col + dc[i];
                if(newr >= 0 && newr < n && newc >= 0 && newc < m) {
                    int newEffort =Math.max(effort, Math.abs(heights[newr][newc] - heights[row][col]));
                    if(newEffort < dist[newr][newc] ){
                        dist[newr][newc] = newEffort;
                        q.add(new int[]{newEffort,newr,newc});
                    }
                }

            }
        }

return 0;
    }
}
