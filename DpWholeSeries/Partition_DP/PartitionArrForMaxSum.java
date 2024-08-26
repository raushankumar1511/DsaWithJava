package DpWholeSeries.Partition_DP;
import java.util.*;

public class PartitionArrForMaxSum {
    private int f(int ind, int k, int n, int[] arr, int[] dp) {
        if(ind == n)return 0;

        if(dp[ind] != -1)return dp[ind];

        int len = 0; int maxi = Integer.MIN_VALUE;
        int maxAns= Integer.MIN_VALUE;

        for(int j = ind; j < Math.min(ind+k,n); j++){
            len++;
            maxi = Math.max(maxi, arr[j]);
            int sum = (len * maxi) + f(j+1,k,n,arr,dp);
            maxAns = Math.max(maxAns, sum);
        }
        return dp[ind] = maxAns;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {

        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return f(0,k,n,arr,dp);
    }

    //tabultion
    public int maxSumAfterPartitioningTab(int[] arr, int k) {

        int n = arr.length;
        int[] dp = new int[n+1];

        for(int i = n-1; i >= 0; i--){
            int len = 0; int maxi = Integer.MIN_VALUE;
            int maxAns= Integer.MIN_VALUE;
            for(int j = i; j < Math.min(i +k,n); j++){
                len++;
                maxi = Math.max(maxi, arr[j]);
                int sum = (len * maxi) + dp[j+1];
                maxAns = Math.max(maxAns, sum);
            }
            dp[i] = maxAns;
        }
        return dp[0];
    }
}
