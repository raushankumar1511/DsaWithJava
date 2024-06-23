package HashSet_Map_Ques;

//leetcode 791;
/* You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.
Permute the characters of s so that they match the order that order was sorted. More specifically,
if a character x occurs before a character y in order, then x should occur before y in the permuted string.
Return any permutation of s that satisfies this property.
Example 1:
Input:  order = "cba", s = "abcd"
Output:  "cbad"
Explanation: "a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a".
Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.*/

import java.util.HashMap;
import java.util.HashSet;

class CustomSortString {
    public static void main(String[] args) {

//      String  order = "bcafg", s = "abcd";
        String order = "kqep" , s = "pekeq";

        System.out.println(customSortString(order,s));
    }
   public static String customSortString(String order, String s) {

        HashMap<Character,Integer> set = new HashMap<>();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
           set.put(s.charAt(i), set.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            if(set.containsKey(ch)){
               ans.append(String.valueOf(ch).repeat(set.get(ch)));
               set.remove(ch);
            }
        }

       for(char x: set.keySet()){
           ans.append(String.valueOf(x).repeat(set.get(x)));
           }

        return ans.toString();
    }
}