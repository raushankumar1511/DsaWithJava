package com.binaryQuestions;

public class MountainArray {
    public static void main(String[] args) {
      int[] arr={1,2,4,5,6,4,3,2};
        System.out.println(peakIndexInMountainArray(arr));
    }
    public static int peakIndexInMountainArray(int[] arr) {
      int start =0;
      int end= arr.length - 1;

       while (start<end){
           int mid=start+(end-start)/2;

           if(arr[mid]<arr[mid+1]){
               start= mid+1;
           }else {
               end=mid;
           }
       }
       return start;
    }
}
