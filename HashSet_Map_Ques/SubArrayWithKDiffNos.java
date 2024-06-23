package HashSet_Map_Ques;

import java.util.*;

public class SubArrayWithKDiffNos {
    public static void main(String[] args) {
        int[] nums= {1,2,1,2,3};
        System.out.println(subarraysWithKDistinct(nums,2));
    }
        private static int subarraysWithKDistinct(int[] nums, int k) {
            return atMostK(nums,k)- atMostK(nums,k-1);
        }
        private static int atMostK(int[] nums, int k){
            int s =0;
            int e =0;
            int ans =0;
            Map<Integer, Integer> map = new HashMap<>();
            while(e<nums.length){
                map.put(nums[e], map.getOrDefault(nums[e] , 0)+1);

                while(map.size()>k){
                    if(map.get(nums[s])>1){
                        map.put(nums[s],map.get(nums[s])-1);
                    }else{
                        map.remove(nums[s]);
                    }
                    s++;
                }
                ans += (e -s)+1;
                e++;
            }
            return ans;
        }
    }

