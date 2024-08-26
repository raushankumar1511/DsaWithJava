package DpWholeSeries;

import java.util.Arrays;

public class IntroWithFibonacci {

    //memoization method using recursion;
    static int fibo(int n, int[] dp){
        if(n<=1){
            return n;
        }
        //step 2
        if(dp[n] != -1)return dp[n];
        //step 1
        return dp[n] = fibo(n-1,dp) + fibo(n-2,dp);
    }

    // dp using tabulation method
    static int fibo(int n){
        //Tc = O(n) sc : O(n)
        int[] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
//    we can also reduce this space by simple obsevation
static int fibo2(int n){
    //Tc = O(n) sc : O(1)
    int prev2 = 0, prev = 1;
    int curri = -1;
    for (int i = 2; i <= n; i++) {
        curri = prev + prev2;
        prev2 = prev;
        prev = curri;
    }
    return prev;
}
    public static void main(String[] args) {
        int n = 5;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        System.out.println(fibo(n));
    }
}
