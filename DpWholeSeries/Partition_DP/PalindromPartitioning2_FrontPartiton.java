package DpWholeSeries.Partition_DP;

import java.util.Arrays;

public class PalindromPartitioning2_FrontPartiton {
    private boolean isPalindrome(int i, int j, String str) {
        while (i <= j) {
            if(str.charAt(i) != str.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
    int f(int i, int n, String str, int[] dp){
        if(i == n)return 0;

        if(dp[i] != -1)return dp[i];

        int minCost = Integer.MAX_VALUE;
        //i...j
        for(int j = i; j< n; j++){
            if(isPalindrome(i,j,str)){
                int cost = 1+ f(j+1,n,str, dp);
                minCost = Math.min(cost, minCost);
            }
        }
        return dp[i] =  minCost;
    }

    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp,-1);

        return f(0,n,s, dp)-1;

    }

    //tabulatkon
    public int minCutTab(String s) {
        int n = s.length();
        int[] dp = new int[n+1];

        for(int i = n-1; i >= 0; i++){
            int minCost = Integer.MAX_VALUE;
            //i...j
            for(int j = i; j< n; j++){
                if(isPalindrome(i,j,s)){
                    int cost = 1+ dp[j+1];
                    minCost = Math.min(cost, minCost);
                }
            }
            dp[i] =  minCost;
        }
        return dp[0];

    }

}
