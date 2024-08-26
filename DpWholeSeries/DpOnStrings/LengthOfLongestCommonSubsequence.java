package DpWholeSeries.DpOnStrings;

import java.util.Arrays;

public class LengthOfLongestCommonSubsequence {
    int f(int i , int j, String s1, String s2, int[][] dp){
        if(i < 0 || j < 0 )return 0;

        // if already computed
        if(dp[i][j] != -1 )return dp[i][j];


        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j]   = 1 + f(i - 1, j -1,s1,s2,dp );
        }
        return dp[i][j] = Math.max(f(i-1, j, s1, s2, dp), f(i, j-1, s1, s2 ,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return f(n-1, m-1, text1, text2, dp);
    }

    //tabulation
    public int longestCommonSubsequenceTab(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i<= n ;i++)dp[i][0] = 0;
        for (int j = 0; j <= m; j++)dp[0][j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j]   = 1 + dp[i - 1][j -1];
                }else
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j -1]);
            }
        }
        return dp[n][m];
        }

        //spaceOptimization
    public int longestCommonSubsequenceTab2(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for (int j = 0; j <= m; j++)prev[j] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j]   = 1 + prev[j -1];
                }else
                    curr[j] = Math.max(prev[j],curr[j -1]);
            }
            prev = curr;
        }
        return prev[m];
    }

}
