package ArrayQuestions;

import java.util.*;

class InsertArray {
    public static void main(String[] args) {
       int[][] intervals = {{1,2},{3,5},{6,7},{8,10},{12,16}};
       int[] newInterval = {4,8};
      int[][] result = insert(intervals,newInterval);
      for(int[] arr: result){
          System.out.print(Arrays.toString(arr));
      }
    }
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for(int[] in: intervals){
            if(in[1] < newInterval[0]){
                result.add(in);
            }
            else if(newInterval[1] < in[0]){
                result.add(newInterval);
                newInterval = in;
            }else{
                newInterval[0] = Math.min(newInterval[0], in[0]);
                newInterval[1] = Math.max(newInterval[1], in[1]);
            }
        }
        result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }
}