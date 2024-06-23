package com.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr={6,3,8,9,-4,-7,43};
        insertion(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void insertion(int[] arr){
        int n= arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j >0; j--) {
                if (arr[j] < arr[j-1]){
                    swap(arr,j,j-1);
                } else {
                    break;
                }
            }
        }
    }
    static void swap(int[] arr,int first, int second){
        int temp= arr[first];
        arr[first] =arr[second];
        arr[second] = temp;
    }

    public static class ThreeSum {
        public static void main(String[] args) {
               int[] nums= {1,0,-1,-2,5,6,-6,3,2};
            System.out.println(threeSum(nums));
        }
       static public List<List<Integer>> threeSum(int[] nums) {
             int n= nums.length;
            List<List<Integer>> ans= new ArrayList<>();
            Arrays.sort(nums);
            for (int i=0 ;i <nums.length;i++){
                 if (i>0 && nums[i] == nums[i-1])continue;
                 int j= i+1;
                 int k= n-1;
                 while (j<k){
                     int sum = nums[i] + nums[j] + nums[k];
                     if(sum< 0){
                         j++;
                     }else if(sum > 0){
                         k--;
                     }else {
                         List<Integer> temp= Arrays.asList(nums[i], nums[j], nums[k]);
                        ans.add(temp);
                        j++;
                        k--;
                        while (j<k && nums[j]==nums[j-1])j++;
                        while (j<k && nums[k] == nums[k+1])k--;
                     }
                 }
            }
            return ans;

        }
    }
}
