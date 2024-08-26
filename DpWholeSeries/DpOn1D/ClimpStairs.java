package DpWholeSeries.DpOn1D;

public class ClimpStairs {
    private int count(int ind, int[] dp){
        if(ind<=1) return 1;
        if(dp[ind] != -1) return dp[ind];

        return dp[ind] = count(ind -1, dp) + count(ind - 2, dp);
    }
    private int countBotUp(int n){
        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i = 2; i<= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public int climbStairs(int n) {
        //   int dp[] = new int[n+1];
        //   Arrays.fill(dp,-1);
        //   return count(n,dp);
        return countBotUp(n);
    }
}
