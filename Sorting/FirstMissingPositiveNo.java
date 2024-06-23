package com.Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FirstMissingPositiveNo {
    public int firstMissingPositive(int[] nums) {
        int i =0;
        while (i < nums.length){
            int correct = nums[i]-1;
            if(nums[i]>0 && nums[i] <= nums.length && nums[i]!= nums[correct]){
                swap(nums, i,correct);
            } else {
                i++;
            }
        }

        for (int index = 0; index < nums.length; index++) {
            if (nums[index]!=index +1 ){
               return index +1  ;
            }
        }
        return nums.length+1;
    }

    static void swap(int[] arr,int first, int second){
        int temp= arr[first];
        arr[first] =arr[second];
        arr[second] = temp;
    }

    public static class Four4Sum {
        public static void main(String[] args) {

        }
    //    public List<List<Integer>> fourSum(int[] nums, int target) {
    //      int n= nums.length;
    //        Set<List<Integer>> st=new HashSet<>();
    //        for (int i=0 ;i<n;i++){
    //            for (int j = i+1; j < n; j++) {
    //                Set<Integer> hashset=new HashSet<>();
    //                for (int k = j+1; k < n; k++) {
    //                    long  sum = nums[i] + nums[j];
    //                    sum+= nums[k];
    //                    long  fourth = (target) - sum;
    //                    if (hashset.contains((int)fourth)){
    //                        List<Integer> temp= Arrays.asList(nums[i], nums[j],nums[k],(int) fourth);
    //                        Collections.sort(temp);
    //                        st.add(temp);
    //                    }
    //                    hashset.add(nums[k]);
    //                }
    //            }
    //        }
    //        List<List<Integer>> ans = new ArrayList<>();
    //        ans.addAll(st);
    //        return ans;

        public List<List<Integer>> fourSum(int[] nums, int target) {
           int n = nums.length;
           List<List<Integer>> ans= new ArrayList<>();
           Arrays.sort(nums);
            for (int i = 0; i < n; i++) {
                if (i>0 && nums[i] == nums[i-1])continue;
                for (int j = 0; j < n; j++) {
                    if (j > i+1 && nums[j] == nums[j-1])continue;
                    int k=j+1;
                    int l = n-1;
                    while (k<l){
                        long sum = nums[i];
                        sum += nums[j];
                        sum+= nums[k];
                        sum+= nums[l];
                        if(sum == target){
                            List<Integer> temp=Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            ans.add(temp);
                            while (k<l && nums[k-1]== nums[k])k++;
                            while (k<l && nums[l] == nums[l+1]) l--;
                        } else if (sum<target) k++;
                        else l--;

                    }
                }
            }
            return ans;
        }
    }
}