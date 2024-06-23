package com.binaryQuestions;

public class findInMountainArr {
    public static void main(String[] args) {
        int[] arr={1,2,4,5,6,4,3,2};
        System.out.println(findInMountainArray(arr,4));
    }
    static int findInMountainArray(int[] arr,int target) {
        int peak = peakIndexInMountainArray(arr);

        int firsttry= orderAgnosticBS(arr,target,0,peak);
        if(firsttry!=-1){
            return firsttry;
        }
        //try to search in decresing array
        int secondTry=orderAgnosticBS(arr,target,peak+1,arr.length-1);
        return secondTry;
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
    static int orderAgnosticBS(int[] arr, int target ,int start, int end) {


        // find whether the array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while(start <= end) {
            // find the middle element
//            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
