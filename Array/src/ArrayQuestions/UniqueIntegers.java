package ArrayQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class UniqueIntegers {
    public static void main(String[] args) {
          int[] arr = {4,3,1,1,3,3,2};
          findLeastNumOfUniqueInts(arr,3);
    }
   static public int findLeastNumOfUniqueInts(int[] arr, int k) {
       HashMap<Integer, Integer> count= new HashMap<>();
       for(int n:arr){
           count.put(n, count.getOrDefault(n, 0) + 1);
       }
       ArrayList<Integer> keyArr=new ArrayList<>();
       keyArr.addAll(count.values());

       Collections.sort(keyArr);
       int noOfRemoved=0;
       for (int i = 0; i < keyArr.size(); i++) {
           if(keyArr.get(i)<=k){
               k=k-keyArr.get(i);
               noOfRemoved++;
           }else {
               break;
           }
       }
       return keyArr.size()-noOfRemoved;
    }
}