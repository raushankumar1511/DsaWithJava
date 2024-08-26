package DpWholeSeries.DpOn2D;

public class CherryPickUp2 {
    int f(int i, int j1, int j2, int r, int c, int[][] grid, Integer[][][] dp){
        if(j1< 0 || j2<0 || j1>= c || j2 >= c){
            return (int)-1e8;
        }
        if(i == r -1){
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }
        if(dp[i][j1][j2] != null) return  dp[i][j1][j2];

        int maxi = (int)-1e8;
        for(int dj1 = -1; dj1 <= +1; dj1++){
            for(int dj2 = -1; dj2 <= +1; dj2++){
                int value = 0;
                if(j1 == j2) value = grid[i][j1];
                else value = grid[i][j1] + grid[i][j2];
                value += f(i+1, j1+dj1, j2+dj2, r,c, grid,dp);
                maxi = Math.max(maxi,value);
            }
        }
        return dp[i][j1][j2] = maxi;
    }
    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        Integer[][][] dp = new Integer[r][c][c];

         return f(0,0,c-1,r,c,grid,dp);
    }

    public int cherryPickup2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][m];

        for(int j1 = 0; j1 < m ; j1++){
            for (int j2 = 0; j2 < m; j2++) {
                if(j1 == j2)dp[n-1][j1][j2] = grid[n-1][j1];
                else dp[n-1][j1][j2] = grid[n-1][j1] + grid[n-1][j2];
            }
        }

        for (int i = n-2; i >= 0 ; i--) {
            for (int j1 = 0; j1 < m; j1++) {
                for (int j2 = 0; j2 < m; j2++) {
                    int maxi = (int)-1e8;
                    for(int dj1 = -1; dj1 <= +1; dj1++){
                        for(int dj2 = -1; dj2 <= +1; dj2++){
                            int value = 0;
                            if(j1 == j2) value = grid[i][j1];
                            else value = grid[i][j1] + grid[i][j2];
                            if(j1+dj1 >= 0 && j1 + dj1 <m && j2 + dj2 >= 0 && j2 + dj2 < m){
                                value += dp[i+1][j1+dj1][j2+dj2];
                            }else {
                                value += -(int) 1e8;
                            }
                            maxi = Math.max(maxi,value);
                        }
                    }
                    dp[i][j1][j2] = maxi;
                }
            }

        }
    return dp[0][0][m-1];
    }
}
