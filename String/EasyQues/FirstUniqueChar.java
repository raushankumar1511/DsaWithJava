package com.String.EasyQues;

import java.util.*;

public class FirstUniqueChar {
    public static void main(String[] args) {

    }
   static public int firstUniqChar(String s) {
//        HashMap<Character,Integer> map= new LinkedHashMap<>();
//        for(int i=0;i<s.length();i++){
//            char ch = s.charAt(i);
//            if(map.containsKey(ch)){
//                map.put(ch,-1);
//            }else {
//                map.put(ch,i);
//            }
//        }
//        for (char ch : map.keySet()){
//            if(map.get(ch)!= -1){
//                return map.get(ch);
//            }
//        }
//        return -1;





       int ans = Integer.MAX_VALUE;

       for(char c ='a';c<='z';c++){
           int firstIndex= s.indexOf(c);
           if(firstIndex!=-1 && firstIndex== s.lastIndexOf(c)){
               ans=Math.min(ans,firstIndex);
           }
       }
       return ans==Integer.MAX_VALUE?-1:ans;
    }
}
