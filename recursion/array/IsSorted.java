package com.recursion.array;

public class IsSorted {
    public static void main(String[] args) {
        int[] arr= {2,3,4,4,5,6,7};
        System.out.println(isSorted(arr,0));
    }
    static boolean isSorted(int[] arr, int index){
        if(index ==  arr.length -1)return true;

        return (arr[index] <= arr[index+1]) && isSorted(arr,index+1);
    }
//    static boolean isSorted(int[] arr, int i){
//        if(i ==  arr.length -1)return true;
//        if(arr[i+1] < arr[i]){
//            return false;
//        }
//        return isSorted(arr,i+1);
//    }
}
