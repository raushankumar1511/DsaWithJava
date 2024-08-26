package DpWholeSeries.DpOn1D;

public class HouseRobber2
{
    public int maxAdjacentSum(int[] nums) {
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
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1 )return nums[0];
        int[] temp1= new int[n-1];
        int[] temp2 = new int[n-1];

        for(int i= 0; i<n;i ++){
            if( i != 0) temp1[i-1] = nums[i];
            if(i != n-1) temp2[i] = nums[i];
        }

        return Math.max(maxAdjacentSum(temp1) , maxAdjacentSum(temp2));
    }
}
