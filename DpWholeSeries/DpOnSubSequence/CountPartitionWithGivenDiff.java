package DpWholeSeries.DpOnSubSequence;
import java.util.*;

public class CountPartitionWithGivenDiff {

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
    public int countPartitions(int n, int d, int[] arr) {
        // code here
        int totSum = 0;
        for (int j : arr) {
            totSum += j;
        }

        //Checking for edge cases
        if(totSum-d<0) return 0;
        if((totSum-d)%2==1) return 0;

        int s2 = (totSum-d)/2;

        int[][] dp = new int[n][s2+1];

        for(int[] row : dp)
            Arrays.fill(row,-1);

        return f(n-1,s2,arr,dp);
    }


    //tabulation format
     int findWays(int[] num, int tar){
        int n = num.length;

        int prev[] = new int[tar+1];

        if(num[0] == 0) prev[0] =2;  // 2 cases -pick and not pick
        else prev[0] = 1;  // 1 case - not pick

        if(num[0]!=0 && num[0]<=tar) prev[num[0]] = 1;  // 1 case -pick

        for(int ind = 1; ind<n; ind++){
            int cur[]=new int[tar+1];
            for(int target= 0; target<=tar; target++){
                int notTaken = prev[target];

                int taken = 0;
                if(num[ind]<=target)
                    taken = prev[target-num[ind]];

                cur[target]= (notTaken + taken)%mod;
            }
            prev = cur;
        }
        return prev[tar];
    }

     int countPartitions2(int n, int d,int[] arr){
        int totSum = 0;
        for(int i=0; i<n;i++){
            totSum += arr[i];
        }
        //Checking for edge cases
        if(totSum-d <0 || (totSum-d)%2 ==1) return 0;

        return findWays(arr,(totSum-d)/2);
    }
}
