package com.recursion.backtracking;

import java.util.*;

public class CombinationSum3 {
    private void findCombinations(int ind, int[] candidates, int target,int k, List<List<Integer>> ans, List<Integer> ds) {

        if(ds.size() ==k && target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(target< 0 )return;
        for(int i = ind ;i<candidates.length; i++){
            if(candidates[i]>target)break;

            ds.add(candidates[i]);
            findCombinations(i+1,candidates,target-candidates[i],k,ans,ds);
            ds.removeLast();

        }


    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = new int[9];
        for(int i = 0; i< 9; i++){
            candidates[i] = i+1;
        }
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        findCombinations(0,candidates,n,k,ans,ds);
        return ans;
    }
}
