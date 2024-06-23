package HashSet_Map_Ques;

import java.util.HashSet;

public class UnionArray {
    public static void main(String[] args) {
int[] num1 ={4,6,3,1,6,8};
int[]  num2 = {8,9,3,5,1,2};
union(num1,num2);
    }
    static void union(int[] num1, int[] num2){
        HashSet<Integer> s = new HashSet<>();
        for(int num:num1){
            s.add(num);
        }
        for(int num:num2){
            s.add(num);
        }
        System.out.println(s);
    }
}
