package com.recursion.array;

import java.util.ArrayList;

public class RecursiveLinearSearch {
    public static void main(String[] args) {
        int[] arr = {4,2,3,6,4,9,7,4};
//        ArrayList<Integer> list = new ArrayList<>();
//        search(arr, 0, 4, list);
//        System.out.println(search(arr, 0, 4));

        int[] nums= {4,5,6,7,8,0,1,2,3};
        System.out.println(rotatedBinarySearch(nums,1,0, nums.length));

    }
//    static ArrayList<Integer> search(int[] arr, int index, int target, ArrayList<Integer> list){
//        if(index == arr.length){
//            return list;
//        }
//        if(arr[index] == target)list.add(index);
//
//       return search(arr,index+1 , target , list);
//    }
    static ArrayList<Integer> search(int[] arr, int index, int target){
        ArrayList<Integer> list=new ArrayList<>();
        if(index == arr.length){
            return list;
        }
        if(arr[index] == target)list.add(index);

        ArrayList<Integer> ansFromBelowCalls= search(arr,index+1 , target);

        list.addAll(ansFromBelowCalls);
        return list;
    }
    static  int rotatedBinarySearch(int[] arr, int target, int s, int e){
        if(s>e)return -1;

        int mid = s+(e- s)/2;
        if(arr[mid] == target){
            return mid;
        }

        if(arr[s]<= arr[mid]){
            if(target >= arr[s] && target <= arr[mid]){
               return rotatedBinarySearch(arr,target,s,mid-1);
            }else {
               return rotatedBinarySearch(arr, target , mid+1, e);
            }
        }
        if(target >= mid && target <= arr[e]){
           return rotatedBinarySearch(arr, target, mid+1 ,e);
        }
        return rotatedBinarySearch(arr , target, s, mid-1);

    }
}
