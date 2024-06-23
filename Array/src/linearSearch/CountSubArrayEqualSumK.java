package linearSearch;
import java.util.*;
class CountSubArrayEqualSumK {
     public static void main(String[] args) {
          int[] arr={1,4,6,-2,0,-3,9,3,1,1,1};
          System.out.println(subarraySum(arr,4));
     }
   static public int subarraySum(int[] nums, int k) {

        Map<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int sum=0;
        int count=0;
        
        for (int i = 0; i < nums.length; i++) {
             sum+=nums[i];
             int preSum= sum -k;
             if(map.containsKey(preSum))count+= map.get(preSum);
            
                //   map.put(sum,map.getOrDefault(sum,0)+1);
             if(map.containsKey(sum)){
                  map.put(sum,map.get(sum)+1);
             }else{
                 map.put(sum,1);
             }
             
        }
        return count;
    }
}