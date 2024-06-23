package com.String.EasyQues;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class A {

    public static void main(String[] args) {
       String s = "g", t = "";
        System.out.println(isAnagram(s,t));

    }

   static public boolean isAnagram(String s, String t) {

        if (s.length()!=t.length())return false;
//        char sArray[] = s.toCharArray();
//        char tArray[] = t.toCharArray();
//        Arrays.sort(sArray);
//        Arrays.sort(tArray);
//        for (int i = 0; i <s.length(); i++) {
//            if(sArray[i]!=tArray[i])return false;
//        }
//        return true;


        HashMap<Character, Integer> map= new HashMap<>();

        for(int i=0;i<s.length();i++){
            char curr= s.charAt(i);
            if (map.containsKey(curr)){
                map.put(curr,map.get(curr)+1);
            }else {
                map.put(curr,1);
            }
        }
        for(int i=0;i<t.length();i++){
            char ch= t.charAt(i);
            if(map.containsKey(ch)){
                if(map.get(ch)!=1){
                    map.put(ch,map.get(ch)-1);
                }else{
                   map.remove(ch,1);
                }
            }
        }
        if(map.size()!=0){

            return false;
        }
        return true;
    }
}
