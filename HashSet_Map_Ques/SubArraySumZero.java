package HashSet_Map_Ques;

import java.util.HashSet;

public class SubArraySumZero {
    public static void main(String[] args) {

    }
    static boolean zeroSubArr(int[] arr){
        HashSet<Integer> h = new HashSet<>();
        int pre_sum =0;
        for (int i = 0; i < arr.length; i++) {
            pre_sum+=arr[i];
            if(h.contains(pre_sum))
                return true;
            if(pre_sum==0)
                return true;
            h.add(pre_sum);
        }
        return false;
    }
}
