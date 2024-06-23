package HashSet_Map_Ques;

import java.util.HashMap;

public class LongestComSpanWithSameSumInTwoBinaryArray {
    public static void main(String[] args) {
        int[] arr1 ={0,1,0,0,0,0};
        int[] arr2 = {1,0,1,0,0,1};

        System.out.println(longestSpan(arr1,arr2));
    }
    private static int longestSpan(int[] arr1, int[] arr2){
        int[] temp = new int[arr1.length];
        for(int i =0; i< temp.length; i++){
            temp[i] = arr1[i] - arr2[i];
        }
        return maxLen(temp,0);

    }
    private static int maxLen(int[] arr, int sum) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int pre_sum=0;
        int res=0;
        for (int i = 0; i < arr.length; i++) {
            pre_sum += arr[i];
            if(pre_sum==sum){
                res = i+1;
            }
            if(!map.containsKey(pre_sum)){
                map.put(pre_sum,i);
            }
            if(map.containsKey(pre_sum- sum)){
                res = Math.max(res,(i-map.get(pre_sum-sum)));
            }
        }
        return res;
    }
}
