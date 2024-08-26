package DpWholeSeries.DpOnStrings;

import java.util.Arrays;

public class DistinctSubsequence {
    private int f(int i, int j, String s, String t, int[][] dp) {
        //base case
        if(j==0) return 1;
        if(i == 0) return 0;

        //if already computed
        if(dp[i][j] != -1 )return dp[i][j];

        if(s.charAt(i-1) == t.charAt(j-1)){
            return dp[i][j] = f(i-1,j-1, s, t, dp) + f(i-1, j , s, t , dp);
        }else{
            return dp[i][j] = f(i-1, j , s, t , dp);
        }
    }
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return f(n,m,s,t,dp);
    }

    //tabulation
    public int numDistinctTab(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 1; j <= m; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
            return dp[n][m];
        }

        //space optimization
    public int numDistinctTabSpaceOpti(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] prev = new int[m+1];

       prev[0] =1;

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m+1];
            curr[0] =1;
            for (int j = 1; j <= m; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)){
                    curr[j] = prev[j-1] + prev[j];
                }else {
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }
        return prev[m];
    }

    //one Array space optimization
    public int numDistinctTabOneArraySpaceOpti(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[] dp = new int[m+1];

        dp[0] =1;

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[j] = dp[j - 1] + dp[j];
                }
            }
        }
        return dp[m];
    }

}
