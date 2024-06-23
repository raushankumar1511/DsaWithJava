package com.Maths.maths;

public class EuclidHCFAlgo {
    public static void main(String[] args) {
//        System.out.println(gcd(48, 18));
        System.out.println(lcm(48, 18));
    }
    private static int gcd(int a, int b){
        if(a== 0)return b;

        return gcd(b%a , a);
    }

    private static  int lcm(int a , int b ){
        return  a*b / gcd(a, b);
    }
}
