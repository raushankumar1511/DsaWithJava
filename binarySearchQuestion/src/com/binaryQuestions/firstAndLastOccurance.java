package com.binaryQuestions;

import java.util.Arrays;

public class firstAndLastOccurance {
    public static void main(String[] args) {
        int[] nums = {5,7,7,7,7,8,8,10};
        System.out.println(Arrays.toString(searchRange(nums,7)));
    }
    public  static int[] searchRange(int[] nums, int target) {

        int[] res=new int[2];
        int firstPosition= search(nums,target,true);
        int lastPosition=search(nums,target,false);

        res[0]=firstPosition;
        res[1]=lastPosition;
        return res ;
    }

   static int search(int[] nums,int target,boolean findStartIndex){
        int s=0;
        int e=nums.length-1;
        int ans=-1;
        while(s<=e){
            int mid=s +(e-s) / 2;

            if(nums[mid]==target){
                ans=mid;
                if(findStartIndex){
                    e=mid-1;
                }else{
                    s=mid+1;
                }
            }else if(nums[mid]>target){
                e=mid-1;
            }else{
                s=mid+1;
            }
        }
        return ans;
    }
}
