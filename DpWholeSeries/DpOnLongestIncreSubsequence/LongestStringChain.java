package DpWholeSeries.DpOnLongestIncreSubsequence;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain {
    private boolean checkPossible(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        if(n != m+1)return false;

        int first = 0;
        int second = 0;
        while (first < n){
            if(second < m && s1.charAt(first) == s2.charAt(second)){
                first++;
                second++;
            }else{
                first++;
            }
        }
        return first == n && second == m;
    }
//        Comparator<String> comp = (String s1, String s2) -> s1.length() - s2.length();
    public int longestStrChain(String[] words){
//        Arrays.sort(words,comp);
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);

        int maxi = 1;
        for (int ind = 0; ind < n; ind++) {
            for(int prev = 0 ;prev < ind; prev++){
                if(checkPossible(words[ind] , words[prev]) && 1+ dp[prev] > dp[ind]){
                    dp[ind] = 1 + dp[prev];
                }
            }
            maxi = Math.max(maxi, dp[ind]);
        }
        return maxi;
    }
}
