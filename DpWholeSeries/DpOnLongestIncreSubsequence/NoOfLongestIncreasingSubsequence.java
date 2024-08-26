package DpWholeSeries.DpOnLongestIncreSubsequence;

import java.util.Arrays;

public class NoOfLongestIncreasingSubsequence {
    public  int findNumberOfLIS(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        int[] count = new int[n];
        Arrays.fill(dp,1);

        int maxi = 1;
        for (int ind = 0; ind < n; ind++) {
            for(int prev = 0 ;prev < ind; prev++){
                if(nums[prev] < nums[ind] && 1+ dp[prev] > dp[ind]){
                    dp[ind] = 1 + dp[prev];
                    count[ind] = count[prev];
                }else if(nums[prev] < nums[ind] && 1+ dp[prev] == dp[ind]){
                    count[ind] += count[prev];
                }
            }
            maxi = Math.max(maxi,dp[ind]);
        }
        int noLIS = 0;
        for(int i = 0; i < n; i++){
             if(dp[i] == maxi) noLIS += count[i];
        }
        return noLIS;
    }
}
