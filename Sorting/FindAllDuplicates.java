package com.Sorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 3, 7, 1, 3, 2,5};
        System.out.println(findDuplicates(nums));
    }
   static public List<Integer> findDuplicates(int[] nums) {
        int i =0;
        while (i < nums.length){
            int correct = nums[i]-1;
            if(nums[i]!= nums[correct]){
                swap(nums, i,correct);
            } else {
                i++;
            }
        }
        List<Integer> ans= new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j]!=j+1){
                ans.add(nums[j]);
            }
        }
        return ans;
    }
    static void swap(int[] arr,int first, int second){
        int temp= arr[first];
        arr[first] =arr[second];
        arr[second] = temp;
    }
//    static public List<Integer> findDuplicates(int[] nums) {
//        HashMap<Integer,Integer> map= new HashMap<>();
//        List<Integer> res= new ArrayList<>();
//        for(int num:nums){
//            if(map.containsKey(num)){
//                map.put(num,map.get(num)+1);
//            }else {
//                map.put(num,1);
//            }
//        }
//        System.out.println(map);
//        for(int i: map.keySet()){
//            if (map.get(i)>1){
//                res.add(i);
//            }
//        }
//        return res;
//    }
}
