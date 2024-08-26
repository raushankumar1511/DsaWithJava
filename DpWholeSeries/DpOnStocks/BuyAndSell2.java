package DpWholeSeries.DpOnStocks;

import java.util.Arrays;

public class BuyAndSell2 {
    int f(int ind, int buy, int[] prices,int n, int[][] dp){
        if(ind == n)return 0;

        if(dp[ind][buy] != -1) return dp[ind][buy];

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[ind] + f(ind+1, 0,prices,n,dp),
                    f(ind+1, 1,prices,n,dp));
        }else {
            profit = Math.max(prices[ind] + f(ind+1, 1,prices,n,dp),
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

    public int maxProfitTab(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;
        for(int ind = n-1; ind >=0; ind--){
            for(int buy = 0; buy<2; buy ++ ){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max(-prices[ind] + dp[ind+1][0],dp[ind+1][1]);
                }else {
                    profit = Math.max(prices[ind] + dp[ind+1][1],dp[ind+1][0]);
                }
                 dp[ind][buy] = profit;
            }
        }
        return dp[0][1];
    }

    public int maxProfitTabSpaceOpti(int[] prices) {
        int n = prices.length;
        int[] ahead = new int[2];
        int[] curr = new int[2];
        ahead[0] = ahead[1] = 0;
        for(int ind = n-1; ind >=0; ind--){
            for(int buy = 0; buy<2; buy ++ ){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max(-prices[ind] + ahead[0], ahead[1]);
                }else {
                    profit = Math.max(prices[ind] + ahead[1], ahead[0]);
                }
                curr[buy] = profit;
            }
            ahead = curr;
        }
        return ahead[1];
    }

    public int maxProfitTabSpaceOpti2(int[] prices) {
        int n = prices.length;
        int aheadNotBuy, aheadBuy, curBuy, curNotBuy;
        aheadNotBuy = aheadBuy =0;

        for (int ind = n - 1; ind >= 0; ind--) {
            curBuy = Math.max(-prices[ind] + aheadNotBuy, aheadBuy);
            curNotBuy = Math.max(prices[ind] + aheadBuy, aheadNotBuy);
            aheadNotBuy = curNotBuy;
            aheadBuy = curBuy;
        }
        return aheadBuy;
    }

}
