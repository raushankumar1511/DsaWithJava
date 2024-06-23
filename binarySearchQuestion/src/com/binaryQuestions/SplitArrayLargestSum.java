package com.binaryQuestions;

public class SplitArrayLargestSum {
    int[] nums;

    public static void main(String[] args) {

        int[] nums={4,2,7,3,1,9};
        System.out.println(splitArray(nums,3));
    }
    public  static int splitArray(int[] nums, int m){
        int start = 0;
        int end =0;
        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start,nums[i]);
            end +=nums[i];
        }

        while (start<end){
            int mid= start +(end - start)/2;

            //calculate how many pieces you can divide this is with this max sum;
            int sum =0 ;
            int pieces = 1;
            for(int num: nums){
                if(sum + num > mid){
                    //you cannot add this in this subarray , make a new one
                    //say you can add this num in new subarray, then sum=num
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if (pieces > m){
                start = mid +1;
            } else {
                end = mid;
            }
        }
        return end;
    }

    //optimised solution takes only half time
//    public int splitArray(int[] nums, int m){
//        this.nums=nums;
//        int start = 0;
//        int end =0;
//        int min=Integer.MAX_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            start = Math.max(start,nums[i]);
//            end +=nums[i];
//        }
//        while (start<=end){
//            int mid= start +(end - start)/2;
//
//            if(isPossible(mid,m)){
//                min= mid;
//                end = mid-1;
//            }else{
//                start = mid +1;
//            }
//        }
//        return min;
//    }
//
//    boolean isPossible(int mid , int m){
//
//
//        int i=0;
//        int pieces=0;
//        while(i<nums.length){
//            int sum =0;
//            while(i<nums.length && sum+nums[i] <=mid ){
//                sum+=nums[i++];
//            }
//            pieces++;
//        }
//        return pieces<=m;
//
//    }
}
