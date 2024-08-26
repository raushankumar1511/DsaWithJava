package DpWholeSeries.DpOn2D;
import java.util.*;
public class TraingleMinPathSum {

    private int f(int i, int j, int[][] dp, List<List<Integer>> triangle,int n) {
        if(i == n-1)return triangle.get(i).get(j);

        if(dp[i][j] != -1)return dp[i][j];

        int d = triangle.get(i).get(j) + f(i+1,j,dp, triangle,n);
        int dg = triangle.get(i).get(j) + f(i+1,j+1,dp, triangle,n);

        return dp[i][j] = Math.min(d,dg);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n][n];
        for(int[] it : dp){
            Arrays.fill(it, -1);
        }

        return f(0,0,dp,triangle,n);
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[][] dp = new int[n][n];

        for(int j = 0; j< n ;j ++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }
        for(int i = n - 2; i>= 0 ; i--){
            for (int j = i; j >= 0 ; j--) {

                int d = triangle.get(i).get(j) + dp[i+1][j];
                int dg = triangle.get(i).get(j) + dp[i+1][j+1];

                dp[i][j] = Math.min(d,dg);

            }
        }
        return dp[0][0];
    }
    public int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();

        int[] prev = new int[n];

        for(int j = 0; j< n ;j ++){
            prev[j] = triangle.get(n-1).get(j);
        }
        for(int i = n - 2; i>= 0 ; i--){
            int[] curr = new int[n];
            for (int j = i; j >= 0 ; j--) {

                int d = triangle.get(i).get(j) + prev[j];
                int dg = triangle.get(i).get(j) + prev[j+1];

                curr[j] = Math.min(d,dg);

            }
            prev = curr;
        }
        return prev[0];
    }


}
