package com.recursion.easy;

public class Printnum {
    public static void main(String[] args) {
        funRev(6);
    }
    static void fun(int n ){
        if(n== 0)return;

        System.out.println(n);
        fun(n-1);
    }
    static void funRev(int n ){
        if(n== 0)return;

        funRev(n-1);
        System.out.println(n);
    }
}
