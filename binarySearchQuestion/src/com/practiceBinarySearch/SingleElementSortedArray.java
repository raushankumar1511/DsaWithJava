package com.practiceBinarySearch;

public class SingleElementSortedArray {
    public static void main(String[] args) {
        int[] arr={1,1,2,3,3};

        System.out.println(singleNonDuplicate(arr));
    }

    public static int singleNonDuplicate(int[] nums) {

        int start=0;
        int end=nums.length-1;
        while (start<end){
            int mid= start +(end - start)/2;
            if((nums[mid-1]< nums[mid] ) &&(nums[mid] < nums[mid+1])){
                return nums[mid];
            }
            if (nums[mid-1]==nums[mid]){
                if ((mid-1) %2 ==0){
                    start=mid+1;
                }else {
                    end = mid -2;
                }
            }
            if (nums[mid]==nums[mid+1]){
                if ((mid+1) % 2 !=0){
                    start=mid+2;
                }else {
                    end = mid -1;
                }
            }
        }
        return nums[start];
    }
}
