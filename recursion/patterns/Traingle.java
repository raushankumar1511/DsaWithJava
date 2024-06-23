package com.recursion.patterns;

public class Traingle {
    public static void main(String[] args) {
        triangle2(4,0);
    }
    static void triangle(int r, int c){
        if(r==0)return;

        if(c<=r){
            System.out.print("*");
            triangle(r,c+1);
        }else {
            System.out.println();
           triangle (r-1,1);
        }
    }
    static void triangle2(int r, int c){
        if(r==0)return;

        if(c<=r){
            triangle2(r,c+1);
            System.out.print("*");
        }else {
            triangle2(r-1,1);
            System.out.println();
        }
    }
//static void triangle2(int r, int c , int n){
//    if(r>n)return;
//
//    if(c<=r){
//        System.out.print("*");
//        triangle2(r,c+1,n);
//    }else {
//        System.out.println();
//        triangle2(r+1,1,n);
//    }
//}
}
