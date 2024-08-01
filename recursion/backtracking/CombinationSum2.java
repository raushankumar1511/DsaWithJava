package com.recursion.backtracking;

import java.util.*;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        findCombinations(0,candidates,target,ans,ds);
        return ans;

    }

    private void findCombinations(int ind, int[] candidates, int target, List<List<Integer>> ans, List<Integer> ds) {

        if(target ==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = ind ;i<candidates.length; i++){
            if(i>ind && candidates[i-1] == candidates[i])continue;
            if(candidates[i]>target)break;

            ds.add(candidates[i]);
            findCombinations(i+1,candidates,target-candidates[i],ans,ds);
            ds.removeLast();

        }


    }
}
