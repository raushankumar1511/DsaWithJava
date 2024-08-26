package DpWholeSeries.Partition_DP;

import java.util.*;

public class BurstBallons {
    private int f(int i, int j, List<Integer> arr, int[][] dp) {
        if(i > j )return 0;
        if(dp[i][j] != -1)return dp[i][j];

        int maxi = Integer.MIN_VALUE;
        for(int ind = i; ind <= j; ind++){
            int cost = arr.get(i-1) * arr.get(ind) * arr.get(j+1)
                    + f(i, ind-1, arr, dp) + f(ind+ 1 , j , arr, dp);
            maxi = Math.max(cost, maxi);
        }
        return dp[i][j] = maxi;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        for(int i : nums)arr.add(i);
        arr.add(1);

        int[][] dp = new int[n+1][n+1];
        for (int[] it : dp)Arrays.fill(it, -1);

        return f(1,n,arr,dp);
    }

    //tabulation
    public int maxCoinsTab(int[] nums) {
        int n = nums.length;
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        for(int i : nums)arr.add(i);
        arr.add(1);

        int[][] dp = new int[n+2][n+2];

        for(int i = n; i >= 1; i--){
            for (int j = 1; j <= n; j++) {
                if(i> j)continue;
                int maxi = Integer.MIN_VALUE;
                for(int ind = i; ind <= j; ind++){
                    int cost = arr.get(i-1) * arr.get(ind) * arr.get(j+1)
                            + dp[i][ind-1] + dp[ind+1][j];
                    maxi = Math.max(cost, maxi);
                }
                 dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }

}
