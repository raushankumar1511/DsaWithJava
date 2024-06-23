package com.recursion.easy;

public class Palindrome {
    static int rev2(int n){
        if(n%10==n)return n;
        int digits = (int)(Math.log10(n))+1;

        return n%10 * (int)Math.pow(10,digits-1) + rev2(n/10);
    }
    static boolean pali(int n){
        if(rev2(n) ==n)return true;
        return false;
    }
    public static void main(String[] args) {
        System.out.println(pali(1331));
    }
}
