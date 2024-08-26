package DpWholeSeries.DpOnStocks;

import java.util.Arrays;

public class BuyAndSellStocks3 {
    int f(int ind, int buy,int cap, int[] prices,int n, int[][][] dp){
        if(ind == n|| cap == 0)return 0;

        if(dp[ind][buy][cap] != -1) return dp[ind][buy][cap];

        int profit = 0;
        if(buy == 1){
            profit = Math.max(-prices[ind] + f(ind+1, 0,cap,prices,n,dp),
                    f(ind+1, 1,cap,prices,n,dp));
        }else {
            profit = Math.max(prices[ind] + f(ind+1, 1, cap-1, prices,n,dp),
                    f(ind+1, 0,cap,prices,n,dp));
        }
        return dp[ind][buy][cap] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int[][] it: dp){
            for(int[] itt:it)
                Arrays.fill(itt,-1);
        }

        return f(0,1,2,prices,n,dp);
    }

    public int maxProfitTab(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];

        for(int ind = n-1 ; ind >= 0; ind--){
            for(int buy = 0 ; buy <= 1; buy++){
                for(int cap = 1; cap <= 2; cap++){
                    int profit = 0;
                    if(buy == 1){
                        profit = Math.max(-prices[ind] + dp[ind+1][0][cap],dp[ind+1][1][cap]);

                    }else {
                        profit = Math.max(prices[ind] + dp[ind+1][1][cap-1],dp[ind+1][0][cap]);
                    }
                     dp[ind][buy][cap] = profit;
                }
            }
        }
        return dp[0][1][2];
    }
    public int maxProfitTabSpace(int[] prices) {
        int n = prices.length;
        int[][] after = new int[2][3];
        int[][] curr = new int[2][3];

        for(int ind = n-1 ; ind >= 0; ind--){
            for(int buy = 0 ; buy <= 1; buy++){
                for(int cap = 1; cap <= 2; cap++){
                    int profit = 0;
                    if(buy == 1){
                        profit = Math.max(-prices[ind] + after[0][cap],after[1][cap]);

                    }else {
                        profit = Math.max(prices[ind] + after[1][cap-1],after[0][cap]);
                    }
                    curr[buy][cap] = profit;
                }
            }
            after = curr;
        }
        return after[1][2];
    }

    //other method
    // using n*4 dp array
    int f2(int ind, int tranNo, int[] prices,int n, int[][] dp){
        if(ind == n|| tranNo == 4)return 0;

        if(dp[ind][tranNo] != -1) return dp[ind][tranNo];

        int profit = 0;
        if(tranNo % 2 == 0){
            profit = Math.max(-prices[ind] + f2(ind+1, tranNo + 1,prices,n,dp),
                    f2(ind+1, tranNo,prices,n,dp));
        }else {
            profit = Math.max(prices[ind] + f2(ind+1, tranNo + 1, prices,n,dp),
                    f2(ind+1, tranNo, prices,n,dp));
        }
        return dp[ind][tranNo] = profit;
    }
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][4];
        for(int[] it: dp){
                Arrays.fill(it,-1);
        }

        return f2(0,0,prices,n,dp);
    }
    public int maxProfitTab2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][5];

        for(int ind = n-1; ind >= 0 ; ind--){
            for(int tranNo = 3 ; tranNo >= 0; tranNo-- ){
                int profit = 0;
                if(tranNo % 2 == 0){
                    profit = Math.max(-prices[ind] + dp[ind+ 1][tranNo + 1],dp[ind+1][tranNo]);
                }else {
                    profit = Math.max(prices[ind] + dp[ind+ 1][tranNo + 1],dp[ind+1][tranNo]);
                }
                dp[ind][tranNo] = profit;
            }
        }
        return dp[0][0];
    }
}
