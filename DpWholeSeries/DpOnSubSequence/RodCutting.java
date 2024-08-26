package DpWholeSeries.DpOnSubSequence;

import java.util.Arrays;

public class RodCutting {
    private int f(int ind, int N, int[] price , int[][] dp){
        if(ind == 0){
            return N * price[0];
        }
         if(dp[ind][N] != -1)return dp[ind][N];
        int notTake = f(ind-1, N, price,dp);
        int take = Integer.MIN_VALUE;
        int rodLength = ind + 1;
        if(rodLength <= N){
            take = price[ind] + f(ind, N - rodLength, price, dp);
        }
        return Math.max(notTake, take);
    }
    public int cutRod(int price[], int n) {
        int[][] dp = new int[n][n + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return f(n-1, n, price,dp);
    }

    //tabulation
    public int cutRod2(int price[], int n) {
        int[][] dp = new int[n][n + 1];

        for(int N = 0 ; N <= n; N++){
            dp[0][N] = N * price[0];
        }
        
        for(int ind = 1; ind < n ; ind++){
            for (int N = 0; N <= n; N++) {
                int notTake = dp[ind-1][N];
                int take = Integer.MIN_VALUE;
                int rodLength = ind + 1;
                if(rodLength <= N){
                    take = price[ind] + dp[ind][N-rodLength];
                }
                dp[ind][N] = Math.max(notTake, take);
            }
        }
        return dp[n-1][n];
    }

    // space optimization
    public int cutRod3(int[] price, int n) {
        int[] prev = new int[n + 1];
        int[] curr = new int[n + 1];

        for(int N = 0 ; N <= n; N++){
            prev[N] = N * price[0];
        }

        for(int ind = 1; ind < n ; ind++){
            for (int N = 0; N <= n; N++) {
                int notTake = prev[N];
                int take = Integer.MIN_VALUE;
                int rodLength = ind + 1;
                if(rodLength <= N){
                    take = price[ind] + curr[N-rodLength];
                }
                curr[N] = Math.max(notTake, take);
            }
            prev = curr;
        }
        return prev[n];
    }

    // 1 array space optimization
    public int cutRod4(int[] price, int n) {
        int[] curr = new int[n + 1];

        for(int N = 0 ; N <= n; N++){
            curr[N] = N * price[0];
        }

        for(int ind = 1; ind < n ; ind++){
            for (int N = 0; N <= n; N++) {
                int notTake = curr[N];
                int take = Integer.MIN_VALUE;
                int rodLength = ind + 1;
                if(rodLength <= N){
                    take = price[ind] + curr[N-rodLength];
                }
                curr[N] = Math.max(notTake, take);
            }
        }
        return curr[n];
    }
}
