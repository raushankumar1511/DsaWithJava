package DpWholeSeries.DpOnLongestIncreSubsequence;

import java.util.Arrays;

public class LongestBitonicSubSequence {
    public int longestBitonicSequence(int[] nums){
        int n = nums.length;
        int[] dp1 = new int[n];
        Arrays.fill(dp1,1);

        for (int ind = 0; ind < n; ind++) {
            for(int prev = 0 ;prev < ind; prev++){
                if(nums[prev] < nums[ind] && 1+ dp1[prev] > dp1[ind]){
                    dp1[ind] = 1 + dp1[prev];
                }
            }
        }

        int[] dp2 = new int[n];
        Arrays.fill(dp2,1);

        for (int ind = n-1; ind >= 0; ind--) {
            for(int prev = n-1 ;prev >= ind ; prev--){
                if(nums[prev] < nums[ind] && 1+ dp2[prev] > dp2[ind]){
                    dp2[ind] = 1 + dp2[prev];
                }
            }
        }
        int ans = 0;
        for(int i = 0; i<n ;i++){
            ans = Math.max( ans,dp1[i] + dp2[i] -1);
        }
        return ans;
    }
}
