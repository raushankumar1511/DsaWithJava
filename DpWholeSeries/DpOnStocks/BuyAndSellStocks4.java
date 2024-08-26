package DpWholeSeries.DpOnStocks;

import java.util.Arrays;

public class BuyAndSellStocks4 {
    public int maxProfitTab(int k ,int[] prices) {
        int n = prices.length;
        int[][] after = new int[2][k+1];
        int[][] curr = new int[2][k+1];

        for(int ind = n-1 ; ind >= 0; ind--){
            for(int buy = 0 ; buy <= 1; buy++){
                for(int cap = 1; cap <= k; cap++){
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
        return after[1][k];
    }

    //other method
    // using n*4 dp array
    int f2(int ind, int tranNo, int[] prices,int n,int k, int[][] dp){
        if(ind == n|| tranNo == k*2)return 0;

        if(dp[ind][tranNo] != -1) return dp[ind][tranNo];

        int profit = 0;
        if(tranNo % 2 == 0){
            profit = Math.max(-prices[ind] + f2(ind+1, tranNo + 1,prices,n,k,dp),
                    f2(ind+1, tranNo,prices,n,k,dp));
        }else {
            profit = Math.max(prices[ind] + f2(ind+1, tranNo + 1, prices,n,k,dp),
                    f2(ind+1, tranNo, prices,n,k,dp));
        }
        return dp[ind][tranNo] = profit;
    }
    public int maxProfit2( int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][k*2];
        for(int[] it: dp){
            Arrays.fill(it,-1);
        }

        return f2(0,0,prices,n,k,dp);
    }
    public int maxProfitTab2(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2*k + 1];

        for(int ind = n-1; ind >= 0 ; ind--){
            for(int tranNo = 2*k -1  ; tranNo >= 0; tranNo-- ){
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
    public int maxProfitTab2Space(int k, int[] prices) {
        int n = prices.length;
        int[] after = new int[2*k + 1];
        int[] cur = new int[2*k + 1];

        for(int ind = n-1; ind >= 0 ; ind--){
            for(int tranNo = 2*k -1  ; tranNo >= 0; tranNo-- ){
                int profit = 0;
                if(tranNo % 2 == 0){
                    profit = Math.max(-prices[ind] + after[tranNo + 1],after[tranNo]);
                }else {
                    profit = Math.max(prices[ind] + after[tranNo + 1],after[tranNo]);
                }
                cur[tranNo] = profit;
            }
            after = cur;
        }
        return after[0];
    }
}
