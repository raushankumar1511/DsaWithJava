package HashSet_Map_Ques;

import java.util.HashMap;

public class LongestSubArraySum {
    public static void main(String[] args) {
        int[] arr = {8,3,1,5,-6,6,2,2};
        int sum =4;
        System.out.println(maxLen(arr,sum));
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
