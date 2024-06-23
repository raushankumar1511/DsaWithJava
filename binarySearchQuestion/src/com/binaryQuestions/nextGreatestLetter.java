package com.binaryQuestions;

public class nextGreatestLetter {
    public static void main(String[] args) {
        char[] letters={'c','f','j'};
        System.out.println( nextGreatestLetter(letters,'c'));
    }
    public static  char nextGreatestLetter(char[] arr, char target) {
        int s=0;
        int e=arr.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;

            if (arr[mid]>target){
                e=mid-1;

            }else{
                s=mid+1;
            }
        }
        return arr[s % arr.length];
    }
}
