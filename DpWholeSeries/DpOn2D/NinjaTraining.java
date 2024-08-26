package DpWholeSeries.DpOn2D;
import java.util.*;

public class NinjaTraining {
    long f(int day, int last, int points[][], long[][] dp) {
        // Base case
        if (day == 0) {
            long maxi = 0;
            for (int task = 0; task < 3; task++) {
                if (task != last) {
                    maxi = Math.max(maxi, points[day][task]);
                }
            }
            return maxi;
        }

        if (dp[day][last] != -1) return dp[day][last];

        long maxi = 0;
        for (int task = 0; task < 3; task++) {
            if (task != last) {
                long point = points[day][task] + f(day - 1, task, points, dp);
                maxi = Math.max(maxi, point);
            }
        }

        return dp[day][last] = maxi;
    }

    public int maximumPoints(int arr[][], int N) {
        long[][] dp = new long[N][4];
        for (long[] it : dp) {
            Arrays.fill(it, -1);
        }
        long result = f(N - 1, 3, arr, dp);
        return (int) result; // Casting to int since the method return type is int
    }
    public int maximumPoints2(int points[][], int N) {
        int[][] dp = new int[N][4];
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0] ,Math.max(points[0][1], points[0][2]));

        for(int day = 1; day < N; day++){
            for(int last = 0; last < 4; last ++){
                dp[day][last] = 0;
                for(int task = 0; task < 3; task ++){
                    if(task != last){
                        int point = points[day][last] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last],point);
                    }
                }
            }
        }
        return dp[N-1][3];
    }

    public int maximumPoints3(int points[][], int N) {
        int[] dp = new int[4];
        dp[0] = Math.max(points[0][1], points[0][2]);
        dp[1] = Math.max(points[0][0], points[0][2]);
        dp[2] = Math.max(points[0][0], points[0][1]);
        dp[3] = Math.max(points[0][0] ,Math.max(points[0][1], points[0][2]));

        for(int day = 1; day < N; day++){
            int[] temp   = new int[4];
            for(int last = 0; last < 4; last ++){
                temp[last] = 0;
                for(int task = 0; task < 3; task ++){
                    if(task != last){
                        temp[last] = Math.max(temp[last],points[day][task] + dp[task]);
                    }
                }
            }
            dp = temp;
        }
        return dp[3];
    }
}
