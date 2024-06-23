package linearSearch;

import java.util.Arrays;

class RotateArray {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,7};
        rotate(nums,3);
        System.out.println(Arrays.toString(nums));
    }
    static public void rotate(int[] nums, int k) {
//        int i=1;
//        while (i<=k){
//            int temp = nums[nums.length-1];
//            for (int j = nums.length-1; j >=1; j--) {
//                nums[j]=nums[j-1];
//            }
//            nums[0] = temp;
//            i++;
//        }


//        int[] result = new int[nums.length];
//            int i=0;
//            int j=nums.length-k;
//            while (j<nums.length){
//                result[i++]=nums[j];
//                j++;
//            }
//
//            int l =0;
//            while (l< nums.length-k){
//                result[i++]=nums[l];
//                l++;
//            }
//
//        for (int m = 0; m < nums.length; m++) {
//                nums[m]= result[m];
//        }


        reverseArr(nums,0,nums.length-1);
        reverseArr(nums,0,k-1);
        reverseArr(nums,k, nums.length-1);

    }
    static private void reverseArr( int[] arr,int start, int end){
        while (start<=end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;

            start++;end--;

        }

    }
}