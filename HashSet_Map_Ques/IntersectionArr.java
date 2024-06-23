package HashSet_Map_Ques;
import java.util.*;

class IntersectionArr {
    public static void main(String[] args) {

        int[] num1={10,15,20,15,30,30,5,2,9};
        int[] num2 = {30,5,30,80,2};
        System.out.println(Arrays.toString(intersection(num1,num2)));
    }
  static public int[] intersection(int[] nums1, int[] nums2) {
      int[] ans= new int[Math.min(nums1.length, nums2.length)];
        HashSet<Integer> s=new HashSet<>();

        for(int  num: nums1){
            s.add(num);
        }
        int count=0;
        for(int num:nums2){
            if(s.contains(num)){
                ans[count]=num;
                count++;
                s.remove(num);
            }
        }
        return Arrays.copyOfRange(ans,0,count);
    }
}