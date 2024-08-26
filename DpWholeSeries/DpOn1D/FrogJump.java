package DpWholeSeries.DpOn1D;
import java.util.*;
public class FrogJump {
    private int fun(int ind , int[] height, int[] dp){
        if(ind == 0) return 0;

        if(dp[ind] != -1)return dp[ind];

        int left = fun (ind-1 , height, dp) + Math.abs(height[ind] - height[ind-1]);
        int right = Integer.MAX_VALUE;
        if(ind > 1) right = fun (ind -2, height,dp) + Math.abs(height[ind] - height[ind-2]);

        return dp[ind] = Math.min(left,right);
    }
    public int minimumEnergy(int[] heights, int n){

        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

//        return fun(n-1,arr,dp);
        //code here
        //tabulation form

        dp[0] = 0;
        for (int i = 1; i <= n-1; i++) {

            int fs = dp[i-1] + Math.abs(heights[i] - heights[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i>1){
                  ss = dp[i-2] + Math.abs(heights[i] - heights[i-2]);
            }
            dp[i] = Math.min(fs,ss);
        }
     return dp[n-1];
    }

    public int minimumEnergy2(int[] heights, int n){
        int prev = 0;
        int prev2 = 0;
        for (int i = 1; i <= n-1; i++) {

            int fs = prev + Math.abs(heights[i] - heights[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i>1){
                ss = prev2 + Math.abs(heights[i] - heights[i-2]);
            }
           int curri = Math.min(fs,ss);
            prev2  = prev;
            prev = curri;
        }
        return prev;
    }
}
