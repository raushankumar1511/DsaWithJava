package com.Maths.maths;
import java.util.*;

class Solution {
    public static void main(String[] args) {

//        subsets(nums);
        int[] nums= {1,2,3,4,5};
        System.out.println(subsets(nums));
    }
   static public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        res.add((Arrays.asList()));
        int i=0;
        while (i<n){
          List<Integer> temp= new ArrayList<>();
          int j=i;

          while (j< n){
              temp.add(nums[j]);
              int k= j+1;

              List<Integer> temp2 = new ArrayList<>();


              while (k< n){
                  temp2.add(nums[k]);
                  System.out.println(temp2);
                  res.add(temp2);
                  System.out.println(res);
                  k++;
              }
              j++;
          }
            i++;
        }
        return Arrays.asList();
    }
}