package Graphs.Questions;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int row;
    int col;
    int distance;
    public Node(int row, int col, int distance) {
        this.row = row;
        this.col = col;
        this.distance = distance;
    }
}
public class DistanceOfNearestCellHaving1 {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<Node> q= new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mat[i][j] == 1) {
                    q.offer(new Node(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }
        int[] drow = {-1,0,+1,0};
        int[] dcol = {0,+1,0,-1};

        while (!q.isEmpty()){
            Node cell = q.poll();
            int row =cell.row;
            int col = cell.col;
            int steps = cell.distance;
            dist[row][col] = steps;
            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow >= 0 && nrow < n  && ncol >= 0 && ncol < m
                        && vis[nrow][ncol] == 0){
                    q.offer(new Node(nrow,ncol,steps +1));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        return dist;
    }
}
