package HashSet_Map_Ques;

import java.util.HashMap;
import java.util.Map;

public class Count_freq {
    public static void main(String[] args) {

        int[] arr ={7,7,5,3,2,6,3,6};
        printFreq(arr);
    }

    //Better solution with O(n) time and space
    static void printFreq(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
       int x = (int)map.get(5);
        for(int num: arr){
                map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            System.out.println(e.getKey()+" " + e.getValue());
        }
    }

    //Native solution with O(n^2) time
//    static void printFreq(int[] arr){
//        for(int i =0 ; i<arr.length;i++){
//            boolean flag = false;
//            for (int j = 0; j < i; j++) {
//                if(arr[i] == arr[j]){
//                    flag = true;
//                    break;
//                }
//            }
//            if(flag)continue;
//
//            int freq =1;
//            for (int j = i+1; j < arr.length; j++) {
//                if(arr[i]== arr[j]){
//                    freq++;
//                }
//            }
//            System.out.println(arr[i]+" "+freq);
//        }
//    }
}
