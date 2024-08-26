package DpWholeSeries.DpOn2D;

import java.util.Arrays;

public class MinPathSum {
    //recursive method
    int f(int i, int j,int[][] dp,int[][] grid){
        if(i == 0 && j == 0 ){
            return grid[0][0];
        }
        if(i < 0 || j < 0)return (int)1e9;

        if(dp[i][j] != -1) return dp[i][j];
        int up = grid[i][j] + f(i-1,j,dp,grid);
        int left = grid[i][j] + f(i,j-1,dp,grid);

        return dp[i][j] = Math.min(up , left);

    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return f(m-1,n-1,dp,grid);
    }

    //tabulation mehod
//      public int minPathSum(int[][] grid) {
//          int m = grid.length;
//         int n = grid[0].length;
//         int dp[][] = new int[m][n];
////
//         for(int i = 0; i< m ;i++){
//             for(int j =0; j<n ; j++){
//                 if(i == 0 && j == 0)dp[0][0] = grid[0][0];
//                 else{
//                     int up = grid[i][j];
//                     if(i> 0) up+= dp[i-1][j];
//                     else up += (int)1e9;
////
//                     int left = grid[i][j];
//                     if(j> 0) left+= dp[i][j-1];
//                     else left += (int)1e9;
////
//                     dp[i][j] = Math.min(left ,up);
//                 }
//             }
//         }
//         return dp[m-1][n-1];
//     }

//    space optimization approch
//    public int minPathSum(int[][] grid) {
//              int m = grid.length;
//             int n = grid[0].length;
//             int[] prev = new int[n];
//
//             for(int i = 0; i< m ;i++){
//                 int[] curr = new int[n];
//                 for(int j =0; j<n ; j++){
//                     if(i == 0 && j == 0)curr[j] = grid[0][0];
//                     else{
//                         int up = grid[i][j];
//                         if(i> 0) up+= prev[j];
//                         else up += (int)1e9;
//
//                         int left = grid[i][j];
//                         if(j> 0) left+= curr[j-1];
//                         else left += (int)1e9;
//
//                         curr[j] = Math.min(left ,up);
//                     }
//                 }
//                 prev = curr;
//             }
//             return prev[n-1];
//         }
}

