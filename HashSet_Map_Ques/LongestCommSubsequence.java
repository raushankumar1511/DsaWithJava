package HashSet_Map_Ques;

import java.util.HashSet;

public class LongestCommSubsequence {
    public static void main(String[] args) {

        int[] arr = {3,8,4,5,7};
        System.out.println(findLongest(arr));
    }
    private static int findLongest(int[] arr){
        HashSet<Integer> h = new HashSet<>();
        for (int i=0 ;i<arr.length;i++){
            h.add(arr[i]);
        }
        int res =0,curr=0;
        for (int i = 0; i < arr.length; i++) {
            if(!h.contains(arr[i]-1)){
                curr =1;
                while (h.contains(arr[i]+curr)){
                    curr++;
                }
                res = Math.max(res,curr);
            }
        }
        return res;
    }
}
