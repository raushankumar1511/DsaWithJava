package com.practiceBinarySearch;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class IntersectionArray {
    public static void main(String[] args) {
//        int[] arr={4,5,6,7,8,0,1,2};
//        System.out.println(countRotations(arr));
        int[] num1={4,9,5};
        int[] num2={9,4,9,8,4};
        System.out.println(Arrays.toString(intersection(num1,num2)));
    }

   //using hashset
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> s1=new HashSet<>();
        HashSet<Integer> s2=new HashSet<>();

        for(int  num: nums1){
            s1.add(num);
        }
        for(int num:nums2){
            if(s1.contains(num)){
                s2.add(num);
            }
        }
        int i=0;
        int[] ans= new int[s2.size()];
        for(int items : s2){
            ans[i++]=items;
        }
        return ans;
    }

  //using Hashmap
//        public int[] intersection(int[] nums1, int[] nums2) {
//            HashMap<Integer, Integer> map= new HashMap<>();
//            Arrays.sort(nums1);
//            Arrays.sort(nums2);
//            int i =0,j=0;
//            while(i<nums1.length && j < nums2.length){
//                if(nums1[i]==nums2[j]){
//                    if(map.containsKey(nums1[i])){
//                        i++;j++;
//                    }else{
//                        map.put(nums1[i],1);
//                    }
//                }
//                else if (nums1[i]>nums2[j]){
//                    j++;
//                }else {
//                    i++;
//                }
//            }
//            int[] ans= new int[map.size()];
//            i=0;
//            for(int val: map.keySet()){
//                ans[i++]=val;
//            }
//            return ans;
//        }
    }

