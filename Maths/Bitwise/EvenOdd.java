package com.Maths.Bitwise;

import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if(isOdd(n)){
            System.out.println(n + " is odd");
        }else {
            System.out.println(n + " is even");
        }
    }
    private static boolean isOdd(int n){
        return (n & 1) ==1;
    }

}
