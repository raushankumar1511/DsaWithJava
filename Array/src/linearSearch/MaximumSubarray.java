package linearSearch;

import java.util.HashMap;
import java.util.Map;

public class MaximumSubarray {
    public static void main(String[] args) {

        int[] arr = {8,3,6,3,7,9,5};
        System.out.println(maxSubArray(arr));
    }
   static public int maxSubArray(int[] nums) {
        long sum =0, maxi = Integer.MIN_VALUE;
        int ansStart=-1,ansEnd=-1;int start=-1;
        for(int i= 0;i<nums.length;i++){

            if(sum==0){
                start=i;
            }
            sum+=nums[i];

            if(sum>maxi){
                maxi=sum;
                ansStart=start;
                ansEnd=i;
            }
            if(sum<0){
                sum=0;
            }
        }
        return (int)(maxi);
    }
    static public int longestSubarrayWithSumK(int[] nums, int k) {

        Map<Integer,Integer> preSumMap=new HashMap<>();

        int lastNoOfMap=0;
        int sum=0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
             sum+=nums[i];
             if(sum==k){
                maxLen= Math.max(maxLen,i+1);
             }
             int rem= sum - k;

             if(preSumMap.containsKey(rem) ){
                 int len = i- preSumMap.get(rem);
             }
             if(lastNoOfMap!=sum){
                 preSumMap.put(sum,i);
                 lastNoOfMap=sum;
             }
        }
        return maxLen;
    }
}
