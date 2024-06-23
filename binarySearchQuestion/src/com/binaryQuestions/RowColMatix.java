package com.binaryQuestions;

import java.util.Arrays;

public class RowColMatix {
    public static void main(String[] args) {
    int[][] matrix={
          {1,3,5,7},
          {10,11,16,20},
          {23,30,34,60}};
        System.out.println(Arrays.toString(search(matrix,20)));
    }
        static int[] search(int[][] matrix, int target){
           int r=0;
           int c= matrix[1].length-1;
           while (r< matrix.length && c >=0){
               if (matrix[r][c]==target){
                   return new int[]{r,c};
               }
               if (matrix[r][c]<target){
                   r++;
               }else {
                   c--;
               }
           }
           return new int[]{-1,-1};
        }
    }

