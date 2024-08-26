package DpWholeSeries.DpOnSubSequence;

import java.util.Arrays;

public class SubsetSumProblem {
    //memoization
    private static Boolean f(int ind, int target, int[] arr,int[][] dp) {
        //base cases
        if(target == 0)return true;
        if(ind == 0) return arr[0] == target;

        if(dp[ind][target] != -1 )
            return dp[ind][target] != 0;

        boolean notTake = f(ind -1 , target, arr, dp);
        boolean take = false;
        if(arr[ind]  <= target){
            take = f(ind - 1, target - arr[ind], arr, dp);
        }
            dp[ind][target] = (take || notTake) ? 1 : 0;
        return notTake || take;
    }
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        int[][] dp = new int[N][sum + 1];
        for(int[] it: dp){
            Arrays.fill(it,-1);
        }
        return f(N-1,sum, arr,dp);
    }

    //tabulation
    static Boolean isSubsetSum2(int n, int arr[], int sum){
        // code here
        boolean[][] dp = new boolean[n][sum + 1];

        for (int i = 0; i <n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= sum)
            dp[0][arr[0]] = true;

        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= sum; target++) {
                boolean notTake = dp[ind -1 ][target];
                boolean take = false;
                if(arr[ind]  <= target){
                    take = dp[ind - 1][target - arr[ind]];
                }
                dp[ind][target] = (take || notTake);
            }
        }
        return dp[n-1][sum];
        }

        // space optimization
    static Boolean isSubsetSum3(int n, int arr[], int sum) {
        // code here
        boolean[] prev = new boolean[sum + 1];
        prev[0] = true;

        if (arr[0] <= sum) {
            prev[arr[0]] = true;
        }

            for (int ind = 1; ind < n; ind++) {
                boolean curr[] = new boolean[sum + 1];

                // Initialize the first column of the current row
                curr[0] = true;
                for (int target = 1; target <= sum; target++) {
                    boolean notTake = prev[target];
                    boolean take = false;
                    if (arr[ind] <= target) {
                        take = prev[target - arr[ind]];
                    }
                    curr[target] = (take || notTake);
                }
                prev = curr;
            }
            return prev[sum];
        }
    }
