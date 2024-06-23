package com.Maths.Bitwise;

import java.util.Scanner;

public class PowerOfTwo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean ans = (n & (n-1)) == 0;
        System.out.println(ans);
    }
}
