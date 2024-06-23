package com.Maths.Bitwise;

public class SingleEle {
    public static void main(String[] args) {
        int[]  nums=  {5,3,6,9,3,5,6};
        System.out.println(singleno(nums));
    }
    private static int singleno(int[]  num){
       int ans=0;
        for(int n : num){
            ans^=n;
        }
        return ans;
    }
}
