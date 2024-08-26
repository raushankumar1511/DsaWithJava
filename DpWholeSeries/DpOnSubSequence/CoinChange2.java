package DpWholeSeries.DpOnSubSequence;
import java.util.*;

public class CoinChange2 {
    int f( int ind, int amount, int[] coins , int[][] dp)
    {
        if(ind == 0) {
            if (amount % coins[0] == 0) return 1;
            return 0;
        }
        if(dp[ind][amount] != -1)return dp[ind][amount];
        int notTake = f(ind -1, amount,coins,dp);
        int take = 0;
        if(coins[ind] <= amount){
            take =f(ind, amount - coins[ind],coins,dp);
        }
        return dp[ind][amount] = take + notTake;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return f(n-1,amount,coins,dp);
    }


    public int change2(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for(int tar = 0 ; tar <= amount; tar++){
            if(tar  % coins[0] == 0)
                dp[0][tar] = 1;
            else
                dp[0][tar] = 0;
        }

        for (int ind = 1; ind < n ; ind++) {
            for (int T = 0; T <= amount; T++) {
                int notTake = dp[ind -1][T];
                int take = 0;
                if(coins[ind] <= T){
                    take = dp[ind][T - coins[ind]];
                }
                dp[ind][T] = (notTake+take);
            }
        }

        return dp[n-1][amount];
    }
}
