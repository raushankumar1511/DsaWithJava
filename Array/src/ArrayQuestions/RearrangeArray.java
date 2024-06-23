package ArrayQuestions;

import java.util.Arrays;

public class RearrangeArray {
    public static void main(String[] args) {
        int[] arr= {-7,-6,-9,-1,-4,4,3,2,7,8};

        System.out.println(Arrays.toString(reArrange(arr)));
    }
//    static void reArrange(int[] arr){
//        int i=0,j=0,k=0,l=1;
//        int n= arr.length;
//
//        while (l<n){
//
//            while (i<n && arr[i] < 0){
//                    i++;
//            }
//            while (j<n && arr[j]>= 0){
//                    j++;
//            }
//            swap(arr,k,i);
//            swap(arr,l,j);
//            if(i<=l)i=l+1;
//            if(j<=l)j=l+1;
//
//            k=k+2;
//            l=l+2;
//        }
//    }
//    static int[] reArrange(int[] nums){
//        ArrayList<Integer> temp1= new ArrayList<>();
//        ArrayList<Integer> temp2= new ArrayList<>();
//        for (int i = 0; i < nums.length; i++) {
//            if(nums[i] <0)temp2.add(nums[i]);
//            else temp1.add(nums[i]);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if(i%2==0){
//                nums[i]=temp1.get(i/2);
//            }else {
//                nums[i]=temp2.get(i/2);
//            }
//        }
//        return nums;
//    }
static int[] reArrange(int[] nums){
        int[] ans= new int[nums.length];
        int j=0,k=1;
    for (int i = 0; i < nums.length; i++) {
        if(nums[i] >=0){
            ans[j] = nums[i];
            j=j+2;
        }else{
            ans[k] = nums[i];
            k= k+2;
        }
    }
    return ans;
}
    static void swap(int[] arr, int one,int two){
        int temp = arr[one];
        arr[one]=arr[two];
        arr[two]= temp;
    }
}
