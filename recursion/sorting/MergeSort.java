package com.recursion.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
         int[] arr= {6,4,3,2,3,1};
//         arr = mergeSort(arr);
        mergeSort(arr,0,arr.length-1);
//        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(arr));
    }
//    private static int[] mergeSort(int[] arr){
//        if(arr.length==1){
//            return arr;
//        }
//        int mid= arr.length/2;
//
//        int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
//        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));
//
//        return merge(left,right);
//
//    }
//private static int[] merge(int[] first, int[] second) {
//    int[] ans = new int[first.length + second.length];
//
//    int i=0;
//    int j= 0;
//    int k = 0;
//
//    while (i< first.length && j < second.length){
//        if(first[i]<second[j]){
//            ans[k++] = first[i++];
//        }else {
//            ans[k++] = second[j++];
//        }
//    }
//
//    while (i<first.length){
//        ans[k++] = first[i++];
//    }
//    while (j< second.length){
//        ans[k++] = second[j++];
//    }
//    return ans;
//}
    private static void mergeSort(int[] arr,int s, int e){
        if( s >= e){
            return ;
        }
        int mid= s+(e-s)/2;

        mergeSort(arr,s,mid);
        mergeSort(arr,mid+1, e);

        merge(arr,s,mid, e);

    }

    private static void merge(int[] arr, int s , int m , int e) {
        int[] ans = new int[(e - s)+1];

        int i=s;
        int j= m+1;
        int k = 0;

        while (i<= m && j <= e){
            if(arr[i]<arr[j]){
                ans[k++] = arr[i++];
            }else {
                ans[k++] = arr[j++];
            }
        }

        while (i<=m){
            ans[k++] = arr[i++];
        }
        while (j<=e){
            ans[k++] = arr[j++];
        }
        for (int l = 0; l < ans.length; l++) {
            arr[s+l] = ans[l];
        }
    }
}
