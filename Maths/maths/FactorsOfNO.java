package com.Maths.maths;

public class FactorsOfNO {
    public static void main(String[] args) {
          factors(20);
    }
    static void factors(int n ){
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if(n % i == 0 ){
                if(n/i == i) {
                    System.out.print(i + " ");
                }
                System.out.print  (i +" " + n/i +" ");
            }
        }
    }
}