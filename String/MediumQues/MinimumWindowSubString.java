package com.String.MediumQues;

import java.util.HashMap;

public class MinimumWindowSubString {
    public static void main(String[] args) {
      String  s = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(s,t));
    }
   static public String minWindow(String s, String t) {
       int i=0;
       HashMap<Character,Integer> map = new HashMap<>();
       for (int k=0;k<t.length();k++){
           char c = t.charAt(k);
           if(map.containsKey(c)){
               map.put(c,map.get(c)+1);
           }else {
               map.put(c,1);
           }
       }
       int minLength = Integer.MAX_VALUE;
       int minStart=-1,minEnd=-1;
       while(i<s.length()){
           HashMap<Character,Integer> map1 = new HashMap<>();
           map1.putAll(map);
          if(!map1.containsKey(s.charAt(i)))i++;
           int j=i;

           while (j<s.length()){
               if(map1.isEmpty())break;
               char c= s.charAt(j);
               if(map1.containsKey(c)) {
                   if (map1.get(c) != 1) map1.put(c, map1.get(c) - 1);
                   else map1.remove(c);
               }
               j++;
           }

           if(map1.isEmpty()) {
               int count = j - i;
               if (count <= minLength) {
                   minLength = count;
                   minStart = i;
                   minEnd = j;
               }
           }

           i++;
       }
       if (minStart==-1)return "kdjhf";
       return s.substring(minStart,minEnd);
    }
}
