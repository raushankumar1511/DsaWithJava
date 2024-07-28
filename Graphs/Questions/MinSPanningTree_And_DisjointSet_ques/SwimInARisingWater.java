package Graphs.Questions.MinSPanningTree_And_DisjointSet_ques;

import java.util.PriorityQueue;

class Node {
    int i, j, value;
    Node(int i, int j, int value) {
        this.i = i;
        this.j = j;
        this.value = value;
    }
}

class DS {
    int[] parent, size;
    DS(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    boolean union(int u, int v) {
        int up_u = findUPar(u);
        int up_v = findUPar(v);
        if (up_u == up_v) return false;
        if (size[up_u] < size[up_v]) {
            parent[up_u] = up_v;
            size[up_v] += size[up_u];
        } else {
            parent[up_v] = up_u;
            size[up_u] += size[up_v];
        }
        return true;
    }

    int findUPar(int node) {
        if (node != parent[node]) {
            parent[node] = findUPar(parent[node]);
        }
        return parent[node];
    }
}
public class SwimInARisingWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Node> q = new PriorityQueue<>((a, b) -> a.value - b.value);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                q.add(new Node(i, j, grid[i][j]));
            }
        }

        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        DS ds = new DS(n * n);
        int max = 0;

        while (ds.findUPar(0) != ds.findUPar(n * n - 1)) {
            Node node = q.remove();
            int i = node.i, j = node.j;
            max = Math.max(max, node.value);

            for (int[] d : dir) {
                int ni = i + d[0], nj = j + d[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] <= node.value) {
                    System.out.println((i * n + j) +" " + (ni * n + nj));
                    ds.union(i * n + j, ni * n + nj);
                }
            }
        }

        return max;
    }
//    public int swimInWater(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         int[][] dist = new int[n][m];

//         for(int[] it: dist){
//             Arrays.fill(it,(int)1e9);
//         }
//         PriorityQueue<int[]> q = new PriorityQueue<>((x,y) -> x[0] - y[0]);
//         q.add(new int[]{grid[0][0],0,0});

//         int[] dr = {-1,0,1,0};
//         int[] dc = {0,1,0,-1};
//         while (!q.isEmpty()){
//             int[] temp = q.poll();
//             int time = temp[0];
//             int row = temp[1];
//             int col = temp[2];

//             if(row == n-1 && col == m -1)return time;
//             for(int i = 0; i< 4; i++){
//                 int newr = row + dr[i];
//                 int newc = col + dc[i];
//                 if(newr >= 0 && newr < n && newc >= 0 && newc < m) {
//                     int newTime =Math.max(time, grid[newr][newc]);
//                     if(newTime < dist[newr][newc] ){
//                         dist[newr][newc] = newTime;
//                         q.add(new int[]{newTime,newr,newc});
//                     }
//                 }

//             }
//         }
// return -1;
//     }

}

