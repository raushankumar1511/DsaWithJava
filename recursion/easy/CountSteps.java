package com.recursion.easy;



public class CountSteps {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(7));
    }
    static int numberOfSteps(int n){
        return helper(n,0);
    }
    static int helper(int n, int steps){
        if(n==0)return steps;

        if(n%2 ==0){
            return helper(n/2,steps+1);
        }
        return helper(n-1, steps+1);
    }

//    static int count=0;
//    static int numberOfSteps(int n){
//
//        if(n==0)return count;
//        count=count+1;
//        if(n%2==0){
//            return numberOfSteps(n/2);
//        }
//       return numberOfSteps(n-1);
//    }
}
