package DpWholeSeries.DpOnSubSequence;

import java.util.Arrays;

public class KnapSackProblem0and1 {
    int f(int ind, int W, int[] weight, int[] value, int[][] dp) {
        if (ind == 0) {
            if (W >= weight[0]) return value[0];
            else return 0;
        }
        if (dp[ind][W] != -1) return dp[ind][W];

        int notTake = 0 + f(ind - 1, W, weight, value, dp);
        int take = Integer.MIN_VALUE;
        if (weight[ind] <= W) {
            take = value[ind] + f(ind - 1, W - weight[ind], weight, value, dp);
        }
        return dp[ind][W] = Math.max(notTake, take);
    }

    int knapsack(int[] weight, int[] value, int n, int maxWeight) {

        int[][] dp = new int[n][maxWeight + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return f(n-1, maxWeight, weight, value,dp);
    }

    //tabulation
    int knapsack2(int[] weight, int[] value, int n, int maxWeight) {

        int[][] dp = new int[n][maxWeight + 1];

        for (int i = weight[0]; i <= maxWeight; i++) {
            dp[0][i] = value[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int W = 0; W <= maxWeight; W++) {
                int notTake = dp[ind - 1][ W];
                int take = Integer.MIN_VALUE;
                if (weight[ind] <= W) {
                    take = value[ind] + dp[ind - 1][W - weight[ind]];
                }
                dp[ind][W] = Math.max(notTake, take);
            }
        }

        return dp[n-1][maxWeight];
    }

    //space optimization
    int knapsack3(int[] weight, int[] value, int n, int maxWeight) {

        int[] prev = new int[maxWeight + 1];

        for (int W = weight[0]; W <= maxWeight; W++) {
            prev[W] = value[0];
        }
        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[maxWeight + 1];
            for (int W = 0; W <= maxWeight; W++) {
                int notTake = prev[ W];
                int take = Integer.MIN_VALUE;
                if (weight[ind] <= W) {
                    take = value[ind] + prev[W - weight[ind]];
                }
                curr[W] = Math.max(notTake, take);
            }
            prev = curr;
        }

        return prev[maxWeight];
    }

    //one array space optimization
    int knapsack4(int[] weight, int[] value, int n, int maxWeight) {

        int[] prev = new int[maxWeight + 1];

        for (int W = weight[0]; W <= maxWeight; W++) {
            prev[W] = value[0];
        }
        for (int ind = 1; ind < n; ind++) {
            for (int W = maxWeight; W >= 0; W--) {
                int notTake = prev[ W];
                int take = Integer.MIN_VALUE;
                if (weight[ind] <= W) {
                    take = value[ind] + prev[W - weight[ind]];
                }
                prev[W] = Math.max(notTake, take);
            }
        }

        return prev[maxWeight];
    }
}
