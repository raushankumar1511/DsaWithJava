package com.recursion.backtracking;

import java.util.*;

public class NQueens {
    static List<List<String>> ans = new ArrayList<>();
    public static void main(String[] args) {
//        int n = 4;
//        boolean[][] board = new boolean[n][n];
//        queens(board,0);
//        for(List<String> row:ans){
//            System.out.println(row);
//        }
      Set<Integer> keepRow= new LinkedHashSet<>();
      Set<Integer> keepCol = new HashSet<>();
      keepRow.add(6);
      keepRow.add(5);
      for(int i:keepRow){
          System.out.println(i);
      }
//        System.out.println(keepRow.i);


    }

//    static int queens (boolean[][] board , int row){
//        if(row == board.length){
//
//            List<String> temp = new ArrayList<>();
//            for (boolean[] line: board){
//                StringBuilder st =new StringBuilder();
//                for (boolean val :line){
//                    if(val){
//                        st.append("Q");
//                    }else{
//                        st.append(".");
//                    }
//                }
//                temp.add(st.toString());
//            }
//            ans.add(temp);
////            display(board);
////            System.out.println();
//            return 1;
//        }
//        int count = 0;
//
//        for(int col =0; col < board.length; col++){
//            //place the queen if it is safe
//            if(isSafe(board,row , col)){
//                board[row][col]= true;
//                count+= queens(board, row+1);
//                board[row][col]=false;
//            }
//        }
//
//        return count;
//    }

    private static void queens (boolean[][] board , int row){
        if(row == board.length){

            List<String> temp = new ArrayList<>();
            for (boolean[] line: board){
                StringBuilder st =new StringBuilder();
                for (boolean val :line){
                    if(val){
                        st.append("Q");
                    }else{
                        st.append(".");
                    }
                }
                temp.add(st.toString());
            }
            ans.add(temp);
            return;
        }
        int count = 0;

        for(int col =0; col < board.length; col++){
            //place the queen if it is safe
            if(isSafe(board,row , col)){
                board[row][col]= true;
                queens(board, row+1);
                board[row][col]=false;
            }
        }

    }
    private static boolean isSafe(boolean[][] board, int row, int col) {
        //check vertical row
        for (int i = 0; i < row; i++) {
            if(board[i][col]){
                return false;
            }
        }
        //diagonal left
        int maxLeft =Math.min(row,col);
        for(int i =1; i <=maxLeft;i++){
            if(board[row-i][col -i]){
                return false;
            }
        }
        //diagonal right
        int maxRight =Math.min(row,board.length- col -1);
        for(int i =1; i <=maxRight;i++){
            if(board[row-i][col + i]){
                return false;
            }
        }

  return true;
    }

    private static void display(boolean[][] board){
        for(boolean[] row : board){
            for(boolean element : row){
                if(element){
                    System.out.print("Q ");
                }else {
                    System.out.print ("X ");
                }
            }
            System.out.println();
        }
    }

}
