package HashSet_Map_Ques;

import java.util.Arrays;
import java.util.HashSet;

public class DistinctEle {
    public static void main(String[] args) {
        int[] arr= {3,3,3,5,6,4,2,6,7,3,4};
//        Integer[] arr= {3,3,3,5,6,4,2,6,7,3,4};
        System.out.println(countDistinct(arr));
    }
    static  int countDistinct(int[] arr){
        HashSet<Integer> s = new HashSet<>();
        for(int num:arr){
            s.add(num);
        }
        return s.size();
    }
//    static  int countDistinct(Integer[] arr){
//        HashSet<Integer> s = new HashSet<>(Arrays.asList(arr));
//
//        return s.size();
//    }
}
