package com.recursion.backtracking;

import java.util.*;

class CombintionSum {
    public static void main(String[] args) {
      int[] candidates ={2,3,6,7};int  target = 7;
        System.out.println( combinationSum(candidates,target));
     }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ds = new ArrayList<>();


        findCombinations(0,candidates,target,ans,ds);
        return ans;

    }

    private static void findCombinations(int i, int[] candidates, int target, List<List<Integer>> ans, List<Integer> ds) {
        if(i== candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(target ==0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        if(candidates[i]  <= target){
            ds.add(candidates[i]);
            findCombinations(i,candidates,target-candidates[i],ans,ds);
            ds.removeLast();
        }
        findCombinations(i+1,candidates,target,ans,ds);
    }


}