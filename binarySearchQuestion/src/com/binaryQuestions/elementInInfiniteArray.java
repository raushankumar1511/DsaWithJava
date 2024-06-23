package com.binaryQuestions;

public class elementInInfiniteArray {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,8,12,14,19,23,27,32,33,45};
        int target=19;
        System.out.println(ansInIifiniteArr(arr,target));
    }
    static int ansInIifiniteArr(int[] arr, int target){
        int start=0;
        int end=1;

        while (arr[end]<target){
            int temp=end +1 ;
            //double the box size so do (end=end + (end - start + 1)*2)
            end=end + (end - start + 1)*2;
            start=temp;
        }

        return binarySearch(arr ,target ,start,end);
    }

    static int binarySearch(int[] arr , int target , int start, int end){

        while (start<=end){
             int mid= start +(end-start)/2;

             if (arr[mid]<target){
                 start = mid+1;
             }else if (arr[mid]>target){
                 end= mid-1;
             }else {
                 return mid;
             }
        }
        return -1;
    }


}
