package HashSet_Map_Ques;

import java.util.HashMap;

public class SubArrEqualZeroOne {
    public static void main(String[] args) {
        int[] arr= {1,0,1,1,1,0,0};
        System.out.println();
        int len = maxLen(arr,0);
        System.out.println(len);
    }
    private static int maxLen(int[] arr, int sum) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int pre_sum=0;
        int res=0;
        for (int i = 0; i < arr.length; i++) {
            int a;
            if(arr[i]==1)a = 1;
            else a =-1;
            pre_sum += a;
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
