package com.recursion.backtracking;
import java.util.*;

public class Combinations {
    private void findCombinations(int ind, int[] candidates,int k, List<List<Integer>> ans, List<Integer> ds) {

        if(ds.size() ==k){
            ans.add(new ArrayList<>(ds));
            return;
        }
        if(ds.size() > k)return;
        for(int i = ind ;i<candidates.length; i++){

            ds.add(candidates[i]);
            findCombinations(i+1,candidates, k,ans,ds);
            ds.removeLast();

        }


    }
    public List<List<Integer>> combine(int n, int k) {
        int[] candidates = new int[n];
        for(int i = 0; i< n; i++){
            candidates[i] = i+1;
        }
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ds = new ArrayList<>();

        findCombinations(0,candidates,k,ans,ds);
        return ans;
    }
}
