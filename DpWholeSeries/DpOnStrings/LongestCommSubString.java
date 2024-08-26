package DpWholeSeries.DpOnStrings;

import java.util.Arrays;

public class LongestCommSubString {
    //recursive approach
    private static int f(int i, int j, String s1, String s2, int count, int[][][] dp) {
        if (i == 0 || j == 0) return count;

        // If already computed
        if (dp[i][j][count] != -1) return dp[i][j][count];

        int currCount = count;
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            currCount = f(i - 1, j - 1, s1, s2, count + 1, dp);
        }

        int option1 = f(i - 1, j, s1, s2, 0, dp);
        int option2 = f(i, j - 1, s1, s2, 0, dp);

        // Store the result in the dp array considering the current count as a dimension
        return dp[i][j][count] = Math.max(currCount, Math.max(option1, option2));
    }

    public static int longestCommonSubString(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        // Create a 3D dp array to store results based on indices i, j, and current substring count
        int[][][] dp = new int[n + 1][m + 1][Math.min(n, m) + 1];

        // Initialize dp array with -1
        for (int[][] matrix : dp) {
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
        }

        return f(n, m, text1, text2, 0, dp);
    }

    // tabulation standard approach
    public static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = 0;
        for (int j = 0; j <= m; j++) dp[0][j] = 0;

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans,dp[i][j]);
                } else
                    dp[i][j] = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "erabcdtyd";
        String s2 = "abcdzydg";

        System.out.println("longest common lcs in " + s1 +" " + s2+" is : " + longestCommonSubString(s1,s2));

    }
}
