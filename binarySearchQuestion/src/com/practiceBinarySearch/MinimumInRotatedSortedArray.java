package com.practiceBinarySearch;

public class MinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr= {4,5,6,7,8,1,2};
        System.out.println(findMin(arr));
    }
    public static int findMin(int[] arr) {
        int start=0;
        int end=arr.length-1;

        while (start<=end){
            int mid=start+(end-start)/2;
            //4 cases
            if (mid < end && arr[mid] > arr[mid+1]){
                return arr[mid+1];
            }
            if (mid > start && arr[mid-1] > arr[mid] ){
                return arr[mid];
            }
            if(arr[mid]>= arr[start]){
                start =mid+1;
            }else{
                end=mid-1;
            }
        }
        return arr[0];
    }

}
