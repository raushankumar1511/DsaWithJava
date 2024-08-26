package DpWholeSeries.DpOnStocks;

import java.util.Arrays;

public class BuyAndSellStocksWithCoolDown {
    int f(int ind, int buy, int[] prices,int n, int[][] dp){
        if(ind >= n)return 0;

        if(dp[ind][buy] != -1) return dp[ind][buy];

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[ind] + f(ind+1, 0,prices,n,dp),
                    f(ind+1, 1,prices,n,dp));
        }else {
            profit = Math.max(prices[ind] + f(ind+2, 1,prices,n,dp),
                    f(ind+1, 0,prices,n,dp));
        }
        return dp[ind][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] it: dp){
            Arrays.fill(it,-1);
        }

        return f(0,1,prices,n,dp);
    }

    //tabulation
    public int maxProfitTab(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];

        for(int ind = n-1; ind >=0; ind--){
            for(int buy = 0; buy<2; buy ++ ){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max(-prices[ind] + dp[ind+1][0],dp[ind+1][1]);
                }else {
                    profit = Math.max(prices[ind] + dp[ind+2][1],dp[ind+1][0]);
                }
                dp[ind][buy] = profit;
            }
        }
        return dp[0][1];
    }

    public int maxProfitTab2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];

        for(int ind = n-1; ind >=0; ind--){
                    dp[ind][1] = Math.max(-prices[ind] + dp[ind+1][0],dp[ind+1][1]);
                    dp[ind][0] = Math.max(prices[ind] + dp[ind+2][1],dp[ind+1][0]);
        }
        return dp[0][1];
    }

    //space optimization
    public int maxProfitTab2Space(int[] prices) {
        int n = prices.length;
        int[] front2 = new int[2];
        int[] front1 = new int[2];
        int[] cur = new int[2];

        for(int ind = n-1; ind >=0; ind--){
            cur[1] = Math.max(-prices[ind] + front1[0],front1[1]);
            cur[0] = Math.max(prices[ind] + front2[1],front1[0]);

            front2 = front1.clone();
            front1 = cur.clone();
        }
        return cur[1];
    }


}
