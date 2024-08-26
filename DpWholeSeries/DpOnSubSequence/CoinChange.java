package DpWholeSeries.DpOnSubSequence;

import java.util.Arrays;

public class CoinChange {
    //recursion
    int f( int ind, int amount, int[] coins , int[][] dp)
    {
        if(ind == 0) {
            if (amount % coins[0] == 0) return amount / coins[0];
            return (int) 1e9;
        }
        if(dp[ind][amount] != -1)return dp[ind][amount];
            int notTake = 0 + f(ind -1, amount,coins,dp);
            int take = Integer.MAX_VALUE;
            if(coins[ind] <= amount){
                take = 1 + f(ind, amount - coins[ind],coins,dp);
            }
            return dp[ind][amount] = Math.min(notTake,take  );
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return f(n-1,amount,coins,dp);
    }

    //tabulation
    public int coinChange2(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for(int tar = 0 ; tar <= amount; tar++){
            if(tar  % coins[0] == 0)
                dp[0][tar] = tar / coins[0];
            else
                dp[0][tar] = (int)1e9;
        }

        for (int ind = 1; ind < n ; ind++) {
            for (int T = 0; T <= amount; T++) {
                int notTake = dp[ind -1][T];
                int take = Integer.MAX_VALUE;
                if(coins[ind] <= T){
                    take = 1 + dp[ind][T - coins[ind]];
                }
                dp[ind][T] = Math.min(notTake,take);
            }
        }

        int noOfCoins =  dp[n-1][amount];

        return noOfCoins>= 1e9 ? -1 : noOfCoins;
    }

    //space optimization
    public int coinChange3(int[] coins, int amount) {
        int n = coins.length;

        // Create two arrays to store results of subproblems: prev and cur
        int[] prev = new int[amount + 1];
        int[] cur = new int[amount + 1];

        // Initialize the prev array for the first element of the array
        for (int T = 0; T <= amount; T++) {
            if (T % coins[0] == 0)
                prev[T] = T / coins[0];
            else
                prev[T] = (int) 1e9;
        }

        // Fill the cur array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= amount; target++) {
                int notTake = 0 + prev[target];
                int take = (int) Math.pow(10, 9);

                // If the current element is less than or equal to the target, calculate 'take'
                if (coins[ind] <= target)
                    take = 1 + cur[target - coins[ind]];

                // Store the minimum result in the cur array
                cur[target] = Math.min(notTake, take);
            }

            // Update prev with cur for the next iteration
            prev = cur.clone();
        }

        // Get the minimum number of elements needed for the target sum
        int ans = prev[amount];

        // If it's not possible to achieve the target sum, return -1
        if (ans >= (int) 1e9)
            return -1;
        return ans;
    }

}
