package com.Maths.Bitwise;

public class IthBit {
    public static void main(String[] args) {
        long num=13,k=3;
        ithbit(num,2);
    }
    private static void ithbit(long num, long n){

//        System.out.println(( num & (1 << (n-1))) >> (n-1));

        System.out.println((num>> (n-1)) & 1);
    }

}
