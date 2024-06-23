package com.binaryQuestions;

public class cellingOfAnElement {
    public static void main(String[] args) {
        int[] arr={1,3,5,6,7,8,12,14};

        System.out.println(cellingElement(arr,4));
    }

    static  int cellingElement(int[] arr, int target){

        if(target>arr[arr.length-1]){
            return -1;
        }
        int s=0;
        int e=arr.length-1;

        int mid=(s+e)/2;
//        int celling = arr[e];
        while(s<=e){

            if(arr[mid]==target){
                return arr[mid];
            }else if (arr[mid]<target){
                s=mid+1;
            }else{
//              int   tempCelling=arr[mid];
//              if (tempCelling<=celling){
//                  celling=tempCelling;
//              }
              e=mid-1;

            }
            mid=(s+e)/2;
        }
        return arr[s];
    }

    public static class OrderAgnosticBS {
        public static void main(String[] args) {
    //        int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
            int[] arr = {99, 80, 75, 22, 11, 10, 5, 2, -3};
            int target = 22;
            int ans = orderAgnosticBS(arr, target);
            System.out.println(ans);
        }

        static int orderAgnosticBS(int[] arr, int target) {
            int start = 0;
            int end = arr.length - 1;

            // find whether the array is sorted in ascending or descending
            boolean isAsc = arr[start] < arr[end];

            while(start <= end) {
                // find the middle element
    //            int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
                int mid = start + (end - start) / 2;

                if (arr[mid] == target) {
                    return mid;
                }

                if (isAsc) {
                    if (target < arr[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                } else {
                    if (target > arr[mid]) {
                        end = mid - 1;
                    } else {
                        start = mid + 1;
                    }
                }
            }
            return -1;
        }
    }
}
