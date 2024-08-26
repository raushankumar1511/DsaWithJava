package DpWholeSeries.DpOnSubSequence;

public class PartitionASetIntoTwoSubsetsWithMInAbsDiff {
    public static int minSubsetSumDifference(int []arr, int n) {
        int totSum = 0;
        for(int it : arr){
            totSum += it;
        }
        int sum = totSum;
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
        int min = (int)1e9;
        for(int s1 = 0; s1 <= totSum / 2; s1++){
            if(dp[n-1][s1]){
                min = Math.min(min, Math.abs((totSum-s1) - s1));
            }
        }
        return min;
    }
}
