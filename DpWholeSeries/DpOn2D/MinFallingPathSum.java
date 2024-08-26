package DpWholeSeries.DpOn2D;
import java.util.*;

public class MinFallingPathSum {
    //recursive solution
    private int f(int i, int j, int[][] dp, int[][] matrix,int n) {
        if(j < 0 || j >= n)return (int)1e9;
        if(i == 0) return matrix[i][j];

        if(dp[i][j] != -1)return dp[i][j];

        int up = matrix[i][j] + f(i-1,j,dp, matrix,n);
        int ld = matrix[i][j] + f(i-1,j-1,dp,matrix,n);
        int rd = matrix[i][j] + f(i-1,j+1,dp,matrix,n);

        return dp[i][j] = Math.min(up,Math.min(ld,rd));
     }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;

        int[][] dp = new int[n][n];
        for(int[] it : dp){
            Arrays.fill(it, -1);
        }
        int ans = (int)1e9;
        for(int j = 0; j< n; j++){
            ans = Math.min(ans,f(n-1,j,dp,matrix,n));
        }
        return ans;
    }

    //tabulation method
    public int minFallingPathSum2(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for(int j =0 ; j < n; j++){
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int down = matrix[i][j] + dp[i-1][j];
                int ld = (int)1e9;
                if(j-1 >= 0) ld = matrix[i][j] + dp[i-1][j-1];

                int rd = (int)1e9;
                if(j+1 < n) rd = matrix[i][j] + dp[i-1][j+1];

                dp[i][j] = Math.min(down,Math.min(ld,rd));
            }
        }
        int ans = (int)1e9;
        for(int i = 0; i< n; i++){
            ans = Math.min(ans,dp[n-1][i]);
        }
        return ans;
    }

    //space optimization
    public int minFallingPathSum3(int[][] matrix) {
        int n = matrix.length;
        int[] prev = new int[n];

        for(int j =0 ; j < n; j++){
            prev[j] = matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            int[] curr = new int[n];
            for (int j = 0; j < n; j++) {
                int down = matrix[i][j] + prev[j];
                int ld = (int)1e9;
                if(j-1 >= 0) ld = matrix[i][j] + prev[j-1];

                int rd = (int)1e9;
                if(j+1 < n) rd = matrix[i][j] + prev[j+1];

                curr[j] = Math.min(down,Math.min(ld,rd));
            }
            prev = curr;
        }
        int ans = (int)1e9;
        for(int i = 0; i< n; i++){
            ans = Math.min(ans,prev[i]);
        }
        return ans;
    }

}
