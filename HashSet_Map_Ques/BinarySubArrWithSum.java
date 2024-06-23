package HashSet_Map_Ques;

import java.util.HashMap;

public class BinarySubArrWithSum {
    public static void main(String[] args) {
        int[] arr = {1,0,0,1,1,0,1,0,1,0};
        System.out.println(numSubarraysWithSum(arr,2));
    }
        public static int numSubarraysWithSum(int[] arr, int sum) {
            HashMap<Integer,Integer> s = new HashMap<>();
            int pre_sum=0;
            // s.put(0,1);
            int count =0;
            for (int i = 0; i <arr.length; i++) {
                pre_sum += arr[i];
                if(pre_sum == sum){
                    count ++;
                }
                if(s.containsKey(pre_sum - sum)){
                    count = count +  s.get(pre_sum - sum);
                }
                s.put(pre_sum ,s.getOrDefault(pre_sum,0)+1 );
            }
            return count;
        }

}
