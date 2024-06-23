package com.Sorting;
import java.util.*;

class FindAllMissingNos {
    public static void main(String[] args) {
        int[] nums = {1, 5, 4, 3, 7, 1, 3, 2};
        System.out.println(findDisappearedNumbers(nums));
    }

    static public List<Integer> findDisappearedNumbers(int[] nums) {
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
                ans.add(j+1);
            }
        }
        return ans;
    }

    static void swap(int[] arr,int first, int second){
        int temp= arr[first];
        arr[first] =arr[second];
        arr[second] = temp;
    }

//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) {
//            if (map.containsKey(num)) {
//                map.put(num, map.get(num) + 1);
//            } else {
//                map.put(num, 1);
//            }
//        }
//        List<Integer> result = new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(!map.containsKey(i+1))result.add(i+1);
//        }
//        return result;
    }


















