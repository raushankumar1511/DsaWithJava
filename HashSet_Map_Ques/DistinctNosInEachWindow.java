package HashSet_Map_Ques;

import java.util.HashMap;

public class DistinctNosInEachWindow {
    public static void main(String[] args) {
          int[] arr = {10,20,10,10,30,40,10};
          distinctele(arr,4);
    }
    private static void distinctele(int[] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        System.out.println(map.size());

        // taking the other window also
        for (int i = k; i < arr.length; i++) {

            int preval= arr[i-k];
            int nextval = arr[i];
            if(map.get(preval)-1==0){
                map.remove(preval);
            }else {
                map.put(preval,map.get(preval)-1);
            }
            map.put(nextval,map.getOrDefault(nextval,0)+1);
            System.out.println(map.size());

        }
    }

}
