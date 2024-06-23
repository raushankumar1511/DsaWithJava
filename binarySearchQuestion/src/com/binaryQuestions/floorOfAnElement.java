package com.binaryQuestions;

public class floorOfAnElement {
    public static void main(String[] args) {
        int[] arr={1,3,5,6,7,8,12,14};

        System.out.println(floorElement(arr,12));
    }

    static  int floorElement(int[] arr, int target){
        int s=0;
        int e=arr.length-1;

        int mid=(s+e)/2;

        while(s<=e){

            if(arr[mid]==target){
                return arr[mid];
            }else if (arr[mid]<target){
                s=mid+1;
            }else{
                e=mid-1;
            }
            mid=(s+e)/2;
        }
        return arr[e];
    }
    }

