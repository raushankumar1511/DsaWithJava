package DpWholeSeries.DpOnLongestIncreSubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubSequence {

    int f(int ind, int prevInd , int[] nums,int n,int[][] dp){

        if(ind == n)return 0;

        if(dp[ind][prevInd+1] != -1)return dp[ind][prevInd+1];

        int len = f(ind + 1, prevInd, nums, n, dp);
        //take case;
        if(prevInd == -1 || nums[prevInd] < nums[ind]){
            len  = Math.max(len, 1+ f(ind+1, ind, nums, n, dp));
        }
        return dp[ind][prevInd+1] = len;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];

        for(int[] it: dp){
            Arrays.fill(it,-1);
        }

        return f(0,-1,nums,n,dp);
    }

    public int lengthOfLISTab(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for(int ind = n-1; ind>= 0 ; ind--){
            for(int prevInd = ind -1 ; prevInd >= -1; prevInd--){
                int len = dp[ind+1][prevInd+1];
                if(prevInd == -1 || nums[ind]> nums[prevInd]){
                    len = Math.max(len , 1+ dp[ind+1][ind + 1]);
                }
                dp[ind][prevInd+1] = len;
            }
        }
        for(int[] it : dp){
            for(int i: it){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    return dp[0][-1+1];
    }

    //space optimization
    public int lengthOfLISTabSpace(int[] nums) {
        int n = nums.length;
        int[] next = new int[n+1];
        int[] cur = new int[n+1];

        for(int ind = n-1; ind>= 0 ; ind--){
            for(int prevInd = ind -1 ; prevInd >= -1; prevInd--){
                int len = next[prevInd+1];
                if(prevInd == -1 || nums[ind]> nums[prevInd]){
                    len = Math.max(len , 1+ next[ind + 1]);
                }
                cur[prevInd+1] = len;
            }
            next = cur.clone();
        }
        return cur[-1+1];
    }

    //tabulation in other form
    public int lengthOfLis(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        int maxi = 1;
        for (int ind = 0; ind < n; ind++) {
            for(int prev = 0 ;prev < ind; prev++){
                if(nums[prev] < nums[ind] && 1+ dp[prev] > dp[ind]){
                    dp[ind] = 1 + dp[prev];
                }
            }
            maxi = Math.max(maxi, dp[ind]);
        }
        return maxi;
    }

    // to print longest increasing subsequencee
    public int printLIS(int[] nums){
        int n = nums.length;
        int[] dp = new int[n];
        int [] hash = new int[n];
        Arrays.fill(dp,1);

        int maxi = 1;
        int lastIndex = 0;
        for (int ind = 0; ind < n; ind++) {
            hash[ind] = ind;
            for(int prev = 0 ;prev < ind; prev++){
                if(nums[prev] < nums[ind] && 1+ dp[prev] > dp[ind]){
                    dp[ind] = 1 + dp[prev];
                    hash[ind] = prev;
                }
            }
            if(dp[ind] > maxi){
                maxi = dp[ind];
                lastIndex = ind;
            }
        }
        List<Integer> temp = new ArrayList<>();
        temp.add(nums[lastIndex]);
        while (hash[lastIndex] != lastIndex ){
            lastIndex = hash[lastIndex];
            temp.add(nums[lastIndex]);
        }
        Collections.reverse(temp);
        return maxi;
    }
}
