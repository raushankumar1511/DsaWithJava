package HashSet_Map_Ques;

import java.util.HashSet;

public class SubArrWithSumK {
    public static void main(String[] args) {

        int[] arr = {5,8,6,13,3,-1};
    }
    boolean isSum(int[] arr,int sum){
        HashSet<Integer> s = new HashSet<>();
        int pre_sum=0;
        for (int i = 0; i <arr.length; i++) {
            pre_sum+= arr[i];
            if(pre_sum == sum){
                return  true;
            }
            if(s.contains(pre_sum - sum)){
                return true;
            }
            s.add(pre_sum);
        }
        return false;
    }
}
