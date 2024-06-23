package HashSet_Map_Ques;

import java.util.HashSet;

public class PairSum {
    public static void main(String[] args) {
        int[] arr= {11,5,6};
        System.out.println(isPair(arr,10));
    }
    static boolean isPair(int[] arr,int sum){
        HashSet<Integer> s = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(s.contains(sum - arr[i])){
                return true;
            }
            s.add(arr[i]);
        }
        return false;
    }
}
