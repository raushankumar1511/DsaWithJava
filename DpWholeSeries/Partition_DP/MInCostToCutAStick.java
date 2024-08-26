package DpWholeSeries.Partition_DP;

import java.util.*;

public class MInCostToCutAStick {
    private int f(int i, int j, List<Integer> cuts, int[][] dp) {
         if(i>j)return 0;

         if(dp[i][j] != -1)return dp[i][j];

         int mini = (int)1e9;
         for(int ind = i ; ind <= j; ind++){
             int cost = (cuts.get(j+1) - cuts.get(i-1))
                     + f(i, ind-1, cuts,dp) + f(ind+1, j, cuts, dp);
             mini = Math.min(mini, cost);
         }
         return dp[i][j] = mini;
    }
    public int minCost(int n, int[] cuts) {
        List<Integer> stickCuts = new ArrayList<>();
        stickCuts.add(0);
        for(int it : cuts)stickCuts.add(it);
        stickCuts.add(n);
        Collections.sort(stickCuts);

        int totalCuts = cuts.length;

        int[][] dp= new int[totalCuts +1][totalCuts +1];
        for(int[] it: dp)Arrays.fill(it, -1);

        return f(1, totalCuts,stickCuts,dp);
    }

    public int minCostTab(int n, int[] cuts) {
        List<Integer> stickCuts = new ArrayList<>();
        stickCuts.add(0);
        for(int it : cuts)stickCuts.add(it);
        stickCuts.add(n);
        Collections.sort(stickCuts);

        int c = cuts.length;

        int[][] dp= new int[c +2][c + 2];

        for(int i = c; i>=1; i--){
            for(int j = 1; j <= c; j++){
                if(i> j)continue;
                int mini = (int)1e9;
                for(int ind = i ; ind <= j; ind++){
                    int cost = (stickCuts.get(j+1) - stickCuts.get(i-1))
                            + dp[i][ind-1] + dp[ind+1][j];
                    mini = Math.min(mini, cost);
                }
                 dp[i][j] = mini;
            }
        }
        return dp[1][c];
    }
}
