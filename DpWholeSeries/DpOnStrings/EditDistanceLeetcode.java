package DpWholeSeries.DpOnStrings;

import java.util.*;

//You have the following three operations permitted on a word:
//Insert a character
//Delete a character
//Replace a character
//Example 1:
//Input: word1 = "horse", word2 = "ros"
//Output: 3
//Explanation:
//horse -> rorse (replace 'h' with 'r')
//rorse -> rose (remove 'r')
//rose -> ros (remove 'e')
public class EditDistanceLeetcode {
    int f(int i,int j, String s1, String s2,int[][] dp){

        if(i == 0) return j;
        if(j == 0) return i;

        if(dp[i][j] != -1)return dp[i][j];

        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return f(i-1,j-1,s1,s2,dp);
        }
        int insert = 1 + f(i,j-1,s1,s2,dp);
        int delete = 1 + f(i-1,j,s1,s2,dp);
        int replace = 1 + f(i-1, j-1, s1,s2, dp);

        return dp[i][j] = Math.min(insert,Math.min(delete,replace));
    }
    public int minDistanceMemo(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return f(n,m,word1,word2,dp);
    }

    public int minDistanceTab(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for(int j= 1 ; j<= m;j++) dp[0][j] = j;
        for(int i = 1 ; i<= n ;i ++) dp[i][0] = i;

        for(int i = 1; i<= n; i++){
            for (int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] =  dp[i-1][j-1];
                }else{
                    int insert = 1 + dp[i][j-1];
                    int delete = 1 + dp[i-1][j];
                    int replace = 1 + dp[i-1][j-1];

                    dp[i][j] = Math.min(insert,Math.min(delete,replace));
                }
            }
        }

        return dp[n][m];
    }
}
