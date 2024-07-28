package Graphs.Questions;

public class FloodFill {
    private void dfs(int row, int col, int[][] ans, int[][] image, int iniCol, int newColor, int[] delRow, int[] delCol) {
        ans[row][col] = newColor;
        int n = image.length;
        int m = image[0].length;
        // check its neighbour
        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow >= 0 && nrow < n && ncol >=0 && ncol < m &&
            image[nrow][ncol] == iniCol && ans[nrow][ncol] != newColor){
                dfs(nrow, ncol, ans, image,iniCol, newColor, delRow, delCol);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int iniCol = image[sr][sc];
        int[][] ans = image;

        int[] delRow = {-1,0, 1,0};
        int[] delCol = {0,+1, 0, -1};
        dfs(sr,sc,ans, image,iniCol,color , delRow, delCol);

        return ans;
    }


}
