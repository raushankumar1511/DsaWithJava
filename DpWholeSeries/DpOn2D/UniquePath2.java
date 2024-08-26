package DpWholeSeries.DpOn2D;

import java.util.Arrays;

public class UniquePath2 {
    //recursive method using dp
    int f(int i, int j,int[][] dp,int[][] grid){
        if(i>= 0 && j >= 0 && grid[i][j] == 1)return 0;
        if(i == 0 && j == 0 ){
            return 1;
        }
        if(i < 0 || j < 0)return 0;

        if(dp[i][j] != -1) return dp[i][j];
        int up = f(i-1,j,dp,grid);
        int left = f(i,j-1,dp,grid);

        return dp[i][j] = up + left;

    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int dp[][] = new int[m][n];
        for(int[] it:dp){
            Arrays.fill(it,-1);
        }
        return f(m-1,n-1,dp,obstacleGrid);
    }

//tabulation method to solve this
// public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//         int m = obstacleGrid.length;
//         int n = obstacleGrid[0].length;
//         int dp[][] = new int[m][n];
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if(obstacleGrid[i][j] == 1) dp[i][j] =  0;
//                 else if(i == 0 && j == 0 )dp[i][j] = 1;
//                 else{
//                     int up = 0;
//                     int left = 0;
//                     if(i>0)up = dp[i-1][j];
//                     if(j>0)left = dp[i][j-1];
//                     dp[i][j] = (up + left);
//                 }
//             }
//         }
//             return dp[m-1][n-1];
// }
}
