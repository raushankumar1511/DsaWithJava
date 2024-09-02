package DpWholeSeries.DpOnStrings;

import java.util.Arrays;

public class ToPrintLongestCommPalindromicSubString {
    int[][] dp ;
    int helper(String s, int i, int j){
        if(i >= j)return 1;

        if(dp[i][j] != -1)return dp[i][j] ;

        if(s.charAt(i) == s.charAt(j)){
           return dp[i][j] = helper(s , i+1, j-1);
        }
        return dp[i][j] = 0;

    }

    public String longestPalindromeRec(String s) {
         dp = new int[s.length()][s.length()];
         for(int[] it : dp){
             Arrays.fill(it,-1);
         }

         int maxLen = 0;
         int startInd = -1;
         int n = s.length();
         for(int i = 0; i< n; i++){
             for (int j = 0; j < n; j++) {
                 if(helper(s,i,j) == 1){
                     if(j-i+1 > maxLen){
                         startInd = i;
                         maxLen = j-i+1;
                     }
                 }
             }
         }
         return s.substring(startInd,startInd+maxLen);
    }

    //tabulation
    public  String longestPalindrome(String s){
        int n = s.length();
        if(n<=1)return s;

        boolean[][] dp = new boolean[n][n];

        int maxLen = 1;
        int start = 0; int end = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                if(s.charAt(j) == s.charAt(i) && (i-j <= 2 || dp[j+1][i-1])){
                    dp[i][j] = true;
                    if(i-j+1 > maxLen){
                        maxLen = i-j-1;
                        start = j;
                        end = i+1;
                    }
                }
            }
        }
        return s.substring(start,end);
    }

    // 2 pointer expand from the center
        public String longestPalindrome2(String s) {
            if (s.length() <= 1) {
                return s;
            }

            String maxStr = s.substring(0, 1);

            for (int i = 0; i < s.length() - 1; i++) {
                String odd = expandFromCenter(s, i, i);
                String even = expandFromCenter(s, i, i + 1);

                if (odd.length() > maxStr.length()) {
                    maxStr = odd;
                }
                if (even.length() > maxStr.length()) {
                    maxStr = even;
                }
            }

            return maxStr;
        }

        private String expandFromCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            return s.substring(left + 1, right);
        }

}
