package DpWholeSeries.DpOnRectangle;
import java.util.*;

public class MaximalRectangle {
    private int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxA = 0;
        for (int i = 0; i <=n ; i++) {
            while (!st.isEmpty() && (i==n || heights[st.peek()] >= heights[i])){
                int height = heights[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty()){
                    width = i;
                }else {
                    width = i- st.peek() -1 ;
                }
                maxA = Math.max(maxA, height * width);
            }
            st.push(i);
        }
        return maxA;
    }
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int maxArea = 0;

        int[] heights = new int[m];
        //tc : O(n * (m+n))
        //sc: O(m)
        for(int i = 0; i<n ; i++){
            for(int j = 0 ;j< m ;j++){
                if(matrix[i][j] == '1') heights[j]++;
                else heights[j] = 0;
            }

            int area = largestRectangleArea(heights);
            maxArea  = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
