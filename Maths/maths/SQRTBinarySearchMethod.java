package com.Maths.maths;

public class SQRTBinarySearchMethod {
    public static void main(String[] args) {
        System.out.println(sqrt(7, 2));
    }
    static  double sqrt(int n , int p){

        int s=0;
        int e = n;
        double root = 0.0;
        while (s<=e){
            int mid = s + (e -s )/2;
            if(mid* mid == n){
                return mid;
            }else if(mid * mid > n){
                e = mid -1;
            }else {
                s = mid + 1;
                root = mid;
            }
        }
        double incr = 0.1;
        for(int i = 0; i < p;i++){
            while (root * root <= n){
                root += incr;
            }
            root -=incr;
            incr /=10;
        }
        return root;
    }
}
