package com.Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr={6,3,8,9,5,1,2,4};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void selection(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int last= arr.length -i-1;
            int max=0;

            for (int j = 1; j <arr.length -i ; j++) {
                if (arr[j] > arr[max]){
                    max = j;
                }
            }
            swap(arr,max,last);
        }
    }

 static void swap(int[] arr,int first, int second){
        int temp= arr[first];
        arr[first] =arr[second];
        arr[second] = temp;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length;int n2= nums2.length;
        int n=n1+n2;
        int i=0,j=0;
        int ind1=n/2-1;
        int ind2=n/2;
        int cnt=0;
        int ind1el = -1;
        int ind2el = -1;
        while (i<n1 && j<n2){
            if(nums1[i]< nums2[j]) {
                if(cnt == ind1) ind1el=nums1[i];
                if(cnt == ind2){
                    ind2el=nums1[i];
                    break;
                }
                cnt++;i++;
            }else {
                if(cnt == ind1) ind1el=nums1[j];
                if(cnt == ind2){
                    ind2el=nums1[j];
                    break;
                }
                cnt++;j++;
            }
        }
        while (i<n1){
            if(cnt == ind1) ind1el=nums1[i];
            if(cnt == ind2){
                ind2el=nums1[i];
                break;
            }
            cnt++;i++;
        }
        while (j<n2){
            if(cnt == ind1) ind1el=nums1[j];
            if(cnt == ind2){
                ind2el=nums1[j];
                break;
            }
            cnt++;j++;
        }
        if(n%2==1){
            return ind2el;
        }
        return (double) (double) (ind1el +ind2el)/2;

    }
}
