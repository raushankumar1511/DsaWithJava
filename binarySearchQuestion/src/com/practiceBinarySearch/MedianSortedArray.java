package com.practiceBinarySearch;

public class MedianSortedArray {
    public static void main(String[] args) {
        int[] num1={1,3};
        int[] num2={2,7};
        System.out.println(findMedianSortedArrays(num1,num2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
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
                    cnt++;i++;
                    break;
                }
                cnt++;i++;
            }else {
                if(cnt == ind1) ind1el=nums2[j];
                if(cnt == ind2){
                    ind2el=nums2[j];
                    cnt++;j++;
                    break;
                }
                cnt++;j++;
            }
        }
        while (i<n1){
            if(cnt == ind1) ind1el=nums1[i];
            if(cnt == ind2){
                ind2el=nums1[i];
                cnt++;i++;
                break;
            }
            cnt++;i++;
        }
        while (j<n2){
            if(cnt == ind1) ind1el=nums2[j];
            if(cnt == ind2){
                ind2el=nums2[j];
                cnt++;j++;
                break;
            }
            cnt++;j++;
        }
        if(n%2==1){
            return (double) ind2el;
        }
        return (double) (double) (ind1el +ind2el)/2;

    }
}
