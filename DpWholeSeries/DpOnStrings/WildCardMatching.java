package DpWholeSeries.DpOnStrings;

import java.util.Arrays;

public class WildCardMatching {
    private boolean f(int i, int j, String pattern, String text, int[][] dp) {
        if(i == 0 && j == 0)return true;
        if(i == 0 && j > 0)return false;
        if(j == 0 && i > 0){
            for(int ii = 1; ii <= i; ii++){
                if(pattern.charAt(ii - 1) != '*')return false;
            }
            return true;
        }
        if(dp[i][j] != -1){
            return dp[i][j] == 1;
        }

        boolean result;
        if (pattern.charAt(i-1) == text.charAt(j-1) || pattern.charAt(i-1) == '?') {
            result = f(i - 1, j - 1, pattern, text, dp);
        } else if (pattern.charAt(i-1) == '*') {
            result = f(i - 1, j, pattern, text, dp) || f(i, j - 1, pattern, text, dp);
        } else {
            result = false;
        }

        dp[i][j] = result ? 1 : 0;
        return result;
    }
    public boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();

        int[][] dp = new int[n+1][m+1];

        for (int[] row : dp)
            Arrays.fill(row, -1);
        return f(n-1,m-1,p,s,dp);

    }

    //tabulation
    public boolean isMatchTab(String text, String pattern) {
        int n = pattern.length();
        int m = text.length();

        boolean[][] dp = new boolean[n+1][m+1];

        for (boolean[] row : dp)
            Arrays.fill(row, false);

        //base cases
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            dp[0][j] = false;
        }
        for(int i = 1; i<= n; i++){
            boolean flag = true;
            for(int ii = 1; ii <= i; ii++){
                if(pattern.charAt(ii - 1) != '*'){
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag;
        }

        for(int i = 1; i<= n ;i++){
            for(int j =1; j<= m; j++){
                boolean result;
                if (pattern.charAt(i-1) == text.charAt(j-1) || pattern.charAt(i-1) == '?') {
                    result = dp[i - 1][j - 1];
                } else if (pattern.charAt(i-1) == '*') {
                    result = dp[i-1][j] || dp[i][j-1];
                } else {
                    result = false;
                }
                dp[i][j] = result;
            }
        }
        return dp[n][m];
    }

    //space optimization
    public boolean isMatchTabSpaceOptimization(String text, String pattern) {
        int n = pattern.length();
        int m = text.length();

        boolean[] prev = new boolean[m+1];

        //base cases
        prev[0] = true;
        for (int j = 1; j <= m; j++) {
            prev[j] = false;
        }

        for(int i = 1; i<= n ;i++){
            boolean[] curr = new boolean[m+1];
            boolean flag = true;
            for(int ii = 1; ii <= i; ii++){
                if(pattern.charAt(ii - 1) != '*'){
                    flag = false;
                    break;
                }
            }
            //for every row assign the oth col's value
            curr[0] = flag;
            for(int j =1; j<= m; j++){
                boolean result;
                if (pattern.charAt(i-1) == text.charAt(j-1) || pattern.charAt(i-1) == '?') {
                    result = prev[j - 1];
                } else if (pattern.charAt(i-1) == '*') {
                    result = prev[j] || curr[j-1];
                } else {
                    result = false;
                }
                curr[j] = result;
            }
            prev = curr;
        }
        return prev[m];
    }


}
