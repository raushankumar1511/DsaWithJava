package DpWholeSeries.DpOnSubSequence;

import java.util.Arrays;

public class NoOfSubsetWithGivenSum {

    int  mod = (int)1e9 + 7;
    private int f(int ind, int target, int[] arr, int[][] dp) {
        // Base cases
        if (ind == 0) {
            if(target == 0 && arr[0] == 0)return 2;
            if(target == 0 || target == arr[0])return 1;
            else return 0;
        }

        if (dp[ind][target] != -1)
            return dp[ind][target];

        int notTake = f(ind - 1, target, arr, dp);
        int take = 0;
        if (arr[ind] <= target) {
            take = f(ind - 1, target - arr[ind], arr, dp);
        }
        return dp[ind][target] = (take + notTake) % mod;
    }

    public int perfectSum(int arr[],int n, int sum) {
        int[][] dp = new int[n][sum + 1];
        for (int[] it : dp) {
            Arrays.fill(it, -1);
        }

        return f(n - 1, sum, arr, dp);
    }

    //tabulation
     int noOfWays(int n, int[] arr, int sum){
        // code here
        int[][] dp = new int[n][sum + 1];

        // Initialize the dp array for the first element
        if(arr[0] == 0)dp[0][0] = 2;
        else dp[0][0] = 1; // There's one way to make sum 0 (by choosing the empty subset)
        if( arr[0] != 0 && arr[0] <= sum) dp[0][arr[0]] = 1; // If the first element is within sum, it can form a subset by itself

        // Fill the dp array
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= sum; target++) {
                int notTake = dp[ind - 1][target];
                int take = 0;
                if(arr[ind] <= target){
                    take = dp[ind - 1][target - arr[ind]];
                }
                dp[ind][target] = (take + notTake) % mod;
            }
        }
        return dp[n - 1][sum];
    }

    static int noOfWays2(int n, int arr[], int sum){
        // code here
        int[] prev = new int[sum + 1];

        if(arr[0] == 0)prev[0] = 2;
        else prev[0] = 1;

        if ( arr[0] != 0 && arr[0] <= sum)
            prev[arr[0]] = 1;

        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[sum + 1];
             for (int target = 1; target <= sum; target++) {
                int notTake = prev[target];
                int take = 0;
                if(arr[ind]  <= target){
                    take = prev[target - arr[ind]];
                }
                prev[target] = (take + notTake);
            }
             prev = curr;
        }
        return prev[sum];
    }
}

