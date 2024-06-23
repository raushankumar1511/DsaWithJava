package com.Maths.Bitwise;

import java.util.Scanner;

public class NoOfSetBits {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String a = "1010";
        long x = Long.parseLong(a,2);
        System.out.println(x);
        System.out.println(Integer.toBinaryString(n));

//        System.out.println(setBits(n));
    }

    private static int setBits(int n) {
        int count =0;

//        while (n>0){
//            count++;
//            n -= (n & -n);
//        }

        while (n>0){
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
