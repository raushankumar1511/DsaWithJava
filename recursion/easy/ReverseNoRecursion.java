package com.recursion.easy;


public class ReverseNoRecursion {
    static int sum =0;
    static void reverse(int n){
        if(n == 0){
            return;
        }
        int rem = n%10;
        sum = sum*10 +rem;
        reverse(n/10);
    }

    static int rev2(int n){
        if(n%10==n)return n;
        int digits = (int)(Math.log10(n))+1;

        return n%10 * (int)Math.pow(10,digits-1) + rev2(n/10);
    }

    public static void main(String[] args) {
//        reverse(3532);
        System.out.println(rev2(14787655));
    }
}
