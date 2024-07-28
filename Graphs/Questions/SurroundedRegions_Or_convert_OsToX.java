package Graphs.Questions;

public class SurroundedRegions_Or_convert_OsToX {
    int[] drow = {-1,0,+1,0};
    int[] dcol = {0,+1,0,-1};
    private  void dfs(int row, int col, int[][] vis, char[][] mat) {
        vis[row][col] = 1;
        int n = mat.length;
        int m = mat[0].length;
        //check for top button left and right
        for (int i = 0; i < 4; i++) {
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                    && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O'){
                dfs(nrow,ncol, vis, mat);
            }
        }

    }
     char[][] fill(char mat[][])
    {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        //traverse first and last row
        for(int j = 0 ; j<m; j++){
            //first row
            if( mat[0][j] == 'O' &&  vis[0][j] == 0){
                dfs(0,j,vis,mat);
            }
            //last row
            if(mat[n-1][j] == 'O' && vis[n-1][j] == 0){
                dfs( n-1,j,vis,mat);
            }
        }
        // traverse fist and last col
        for (int i = 0; i < n; i++) {
            //first col
            if( mat[i][0] == 'O' &&  vis[i][0] == 0){
                dfs(i,0,vis,mat);
            }
            //last row
            if( mat[i][m-1] == 'O' &&  vis[i][m -1] == 0){
                dfs(i,m-1,vis,mat);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(vis[i][j] == 0 && mat[i][j] == 'O'){
                    mat[i][j] = 'X';
                }
            }
        }
        return mat;
    }

}
