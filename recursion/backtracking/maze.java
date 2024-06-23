package com.recursion.backtracking;

import java.util.ArrayList;
import java.util.List;

public class maze {
    public static void main(String[] args) {
//        System.out.println(count(3,3));
////        path("",3,3);
//        System.out.println(pathreturn("",3,3));
        int[][] maze={{1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {0, 1, 1, 1}};
        pathRestriction("",maze,0,0);

    }
    static int count(int r, int c){
        if(r==1 || c == 1){
            return 1;
        }
        int left = count(r-1, c);
        int right = count(r, c-1);
        return left+right;
    }

    static void path(String p, int r, int c){
        if(r== 1 && c ==1){
            System.out.println(p);
            return;
        }

        if(r>1){
            path(p +'D',r-1,c);
        }
        if(c >1){
            path(p + 'R',r,c-1);
        }
    }

    static ArrayList<String> pathreturn(String p, int r, int c){
        if(r== 1 && c ==1){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        if(r>1){
            list.addAll(pathreturn(p +'D',r-1,c));
        }
        if(c >1){
            list.addAll(pathreturn(p + 'R',r,c-1));
        }
        return list;
    }

    static void pathRestriction(String p, int [][] maze, int r, int c){
        if(r== maze.length-1 && c == maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(maze[r][c]==0)return;

        if(r < maze.length-1){
            pathRestriction(p +'D',maze,r+1,c);
        }
        if(c < maze[0].length-1){
            pathRestriction(p + 'R',maze,r,c+1);
        }

    }
}
