package com.recursion.array;

import java.util.*;


public class Subset {
    // recursive method
   void helper(int i, int[] nums, List<Integer> temp, List<List<Integer>> ans){
        if(i == nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        temp.add(nums[i]);
        helper(i+1,nums,temp,ans);
        temp.removeLast();
        helper(i+1,nums,temp,ans);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>  outer = new ArrayList<>();

        // iterative method;
        // outer.add(new ArrayList<>());

        // for(int num: nums){
        //     int n = outer.size();
        //     for (int i = 0; i < n; i++) {
        //         List<Integer> internal = new ArrayList<>(outer.get(i));
        //         internal.add(num);
        //         outer.add(internal);
        //     }
        // }
        // return outer;

        helper(0,nums,new ArrayList<>(), outer);
        return outer;
    }

//    static List<List<Integer>> subset(int[] arr){
//        Arrays.sort(arr);
//        List<List<Integer>>  outer = new ArrayList<>();
//
//        outer.add(new ArrayList<>());
//         int start =0;
//         int end=0;
//        for(int i = 0; i < arr.length; i++){
//            start =0;
//          if(i>0 && arr[i] == arr[i-1]){
//              start = end +1;
//          }
//          end = outer.size()-1;
//          int n = outer.size();
//            for (int j = start; j < n; j++) {
//                List<Integer> internal = new ArrayList<>(outer.get(j));
//                internal.add(arr[i]);
//                outer.add(internal);
//            }
//        }
//        return outer;
//    }
}


