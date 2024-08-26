package DpWholeSeries.DpOnSubSequence;

import java.util.Arrays;

public class KnapSackWthDuplicatesItems {
   private static int f(int ind, int W, int[] wt, int[] val, int[][] dp) {
        if (ind == 0) {
            return (W /wt[0]) * val[0];
        }
        if (dp[ind][W] != -1) return dp[ind][W];

        int notTake = f(ind - 1, W, wt, val, dp);
        int take = Integer.MIN_VALUE;
        if (wt[ind] <= W) {
            take = val[ind] + f(ind, W - wt[ind], wt, val, dp);
        }
        return dp[ind][W] = Math.max(notTake, take);
    }
    static int knapSack(int N, int W, int val[], int wt[])
    {
        int[][] dp = new int[N][W + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return f(N-1, W, wt, val,dp);
    }

    //tabulation
    static int knapSack2(int n, int W, int[] val, int[] wt) {
        int[][] dp = new int[n][W + 1];

        // Base condition: Initialize the dp array for the first item
        for (int i = wt[0]; i <= W; i++) {
            dp[0][i] = ((int) i / wt[0]) * val[0];
        }

        // Fill the dp array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= W; cap++) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = 0 + dp[ind - 1][cap];

                // Initialize the maximum value when the current item is taken as the minimum integer value
                int taken = Integer.MIN_VALUE;

                // If the weight of the current item is less than or equal to the current capacity (cap),
                // calculate the maximum value when the current item is taken
                if (wt[ind] <= cap)
                    taken = val[ind] + dp[ind][cap - wt[ind]];

                // Store the result in the dp array
                dp[ind][cap] = Math.max(notTaken, taken);
            }
        }

        return dp[n - 1][W]; // Return the maximum value that can be obtained
    }


    //space optimization
    static int Knapsack(int n, int W, int[] val, int[] wt) {
        // Create an array to store the maximum value for each capacity from 0 to W
        int[] cur = new int[W + 1];

        // Base condition: Initialize the cur array for the first item
        for (int i = wt[0]; i <= W; i++) {
            cur[i] = ((int) i / wt[0]) * val[0];
        }

        // Fill the cur array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int cap = 0; cap <= W; cap++) {
                // Calculate the maximum value when the current item is not taken
                int notTaken = cur[cap];

                // Initialize the maximum value when the current item is taken as the minimum integer value
                int taken = Integer.MIN_VALUE;

                // If the weight of the current item is less than or equal to the current capacity (cap),
                // calculate the maximum value when the current item is taken
                if (wt[ind] <= cap)
                    taken = val[ind] + cur[cap - wt[ind]];

                // Store the result in the cur array
                cur[cap] = Math.max(notTaken, taken);
            }
        }

        return cur[W]; // Return the maximum value that can be obtained with the given capacity W
    }
}
