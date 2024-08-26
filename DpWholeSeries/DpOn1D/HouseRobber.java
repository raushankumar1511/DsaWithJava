package DpWholeSeries.DpOn1D;
import java.util.*;

public class HouseRobber {
    //using the memoization
    int f( int ind , int[] nums,int[] dp){
        if(ind == 0) return nums[ind];
        if(ind < 0) return 0;
        if(dp[ind] != -1) return dp[ind];

        int pick = nums[ind] +  f(ind-2,nums,dp);

        int notPick = 0 + f(ind-1,nums,dp);

        return dp[ind] = Math.max(pick,notPick);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp,-1);

        return f(n-1,nums,dp);
    }
    //tabulation
    public int rob2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int take = nums[i] ;
            if(i > 1) take += dp[i-2];
            int notTake = dp[i-1];

            dp[i] = Math.max(take,notTake);
        }
        return dp[n-1];
    }
    //space optimization
    public int rob3(int[] nums) {
        int n = nums.length;
        int prev = nums[0] ;
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int take = nums[i] ;
            if(i > 1) take += prev2;

            int notTake = 0 + prev;

            int curri = Math.max(take,notTake);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
}
