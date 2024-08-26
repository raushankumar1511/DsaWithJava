package DpWholeSeries.DpOnStocks;

import java.util.Arrays;

public class BuyAndSellWithTransactionfee {
    int f(int ind, int buy, int[] prices,int n, int[][] dp,int fee){
        if(ind == n)return 0;

        if(dp[ind][buy] != -1) return dp[ind][buy];

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[ind] + f(ind+1, 0,prices,n,dp, fee),
                    f(ind+1, 1,prices,n,dp,fee));
        }else {
            profit = Math.max(prices[ind] - fee + f(ind+1, 1,prices,n,dp, fee),
                    f(ind+1, 0,prices,n,dp, fee));
        }
        return dp[ind][buy] = profit;
    }
    public int maxProfit(int[] prices,int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] it: dp){
            Arrays.fill(it,-1);
        }

        return f(0,1,prices,n,dp, fee);
    }

    public int maxProfitTab(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;
        for(int ind = n-1; ind >=0; ind--){
            for(int buy = 0; buy<2; buy ++ ){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max(-prices[ind] + dp[ind+1][0],dp[ind+1][1]);
                }else {
                    profit = Math.max(prices[ind] - fee + dp[ind+1][1],dp[ind+1][0]);
                }
                dp[ind][buy] = profit;
            }
        }
        return dp[0][1];
    }

    public int maxProfitTabSpaceOpti(int[] prices, int fee) {
        int n = prices.length;
        int[] ahead = new int[2];
        int[] curr = new int[2];
        for(int ind = n-1; ind >=0; ind--){
            for(int buy = 0; buy<2; buy ++ ){
                int profit = 0;
                if(buy == 1){
                    profit = Math.max(-prices[ind] + ahead[0], ahead[1]);
                }else {
                    profit = Math.max(prices[ind]-fee + ahead[1], ahead[0]);
                }
                curr[buy] = profit;
            }
            ahead = curr;
        }
        return ahead[1];
    }

    //most optimized solution just extension of above method
    public int maxProfitTabSpaceOpti2(int[] prices,int fee) {
        int n = prices.length;
        int aheadNotBuy, aheadBuy, curBuy, curNotBuy;
        aheadNotBuy = aheadBuy =0;

        for (int ind = n - 1; ind >= 0; ind--) {
            curBuy = Math.max(-prices[ind] + aheadNotBuy, aheadBuy);
            curNotBuy = Math.max(prices[ind] - fee + aheadBuy, aheadNotBuy);
            aheadNotBuy = curNotBuy;
            aheadBuy = curBuy;
        }
        return aheadBuy;
    }
}
