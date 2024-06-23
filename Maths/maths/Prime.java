package com.Maths.maths;

import java.util.Scanner;

public class Prime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        System.out.println(n +" "+isPrime(n));

        for (int i = 2; i <=n; i++) {
            if(isPrime(i)){
                System.out.println( i +" is prime");
            }
        }
    }
    private  static boolean isPrime(int n ){
        if(n<=1){
            return  false;
        }
        int c =2;
        while (c*c <= n){
            if(n % c == 0){
                return  false;
            }
            c++;
        }
        return true;
    }
}

