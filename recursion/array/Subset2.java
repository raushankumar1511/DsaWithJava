package com.recursion.array;

//90. Subsets II
//        Given an integer array nums that may contain duplicates, return all possible
//        subsets(the power set).
//        The solution set must not contain duplicate subsets. Return the solution in any order.
//
//        Example 1:
//        Input: nums = [1,2,2]
//        Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

import java.util.*;
public class Subset2 {
    void findSubsets(int ind, int[] nums, List<Integer> temp,List<List<Integer>> ans ){
        ans.add(new ArrayList(temp));
        for(int i = ind ; i< nums.length; i++){
            if(i != ind && nums[i] == nums[i-1] )continue;
            temp.add(nums[i]);
            findSubsets(i + 1 , nums, temp, ans);
            temp.removeLast();
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findSubsets(0, nums, new ArrayList<>(), ans);
        return ans;
    }
}
