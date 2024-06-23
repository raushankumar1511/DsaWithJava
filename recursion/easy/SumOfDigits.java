package com.recursion.easy;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(sum(2343));
        System.out.println(prodDig(56032));
    }
    static int sum(int n ){
        if(n ==0)return 0;

        return (n% 10 )+ sum(n/10);
    }
    static int prodDig(int n ){
        if(n%10 == n)return n;

        return (n% 10 ) * prodDig(n/10);
    }
}
